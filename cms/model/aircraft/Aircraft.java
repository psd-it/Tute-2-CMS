package cms.model.aircraft;

import cms.model.AbstractTransport;
import cms.model.interfaces.Job;
import cms.model.jobs.Flight;

public class Aircraft extends AbstractTransport
{
    private final int KM_RATE = 5;
    private final int FLIGHT_OVERHEAD = 30000;
    private double flightHours, averageSpeed;
    private int maxFlights, flightCount;
    public Aircraft(String id, String make, String model, int year, double averageSpeed, int maxFlights,
                    double flightHours, double serviceInterval)
    {
        super(id,make,model,year, flightHours, serviceInterval);
        this.averageSpeed = averageSpeed;
        this. maxFlights = maxFlights;
    }

    /**
     * Gets the rate charged per KM for wear and tear
     *
     * @return rate
     */
    @Override
    public double getWearRate()
    {
        return (getMileage() * KM_RATE) + FLIGHT_OVERHEAD;
    }

    @Override
    public void recordService()
    {
        super.recordService();
        this.flightCount = 0;
    }

    /**
     * Attempt to schedule a job
     *
     * @param id       Identifier for this job
     * @param distance distance of this flight
     * @return job it will only be applied to the vehicle if it's accepted
     */
    @Override
    public Job scheduleJob(int id, double distance)
    {
        double hours = distance / averageSpeed;
        // Create proposed job as flight
        Job job = new Flight(super.scheduleJob(id, distance));
        // Check if this job is valid
        job.accept((this.getMileage() - this.getLastServiced()) + hours < this.getServiceInterval()
                           && flightCount < maxFlights);

        if(job.isAccepted())
        {
            // Record new odometer for a valid job
            this.addMileage(hours);
            ++flightCount;
        }
        return job;
    }

}

