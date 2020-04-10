package cms.model;

import cms.exceptions.VehicleDoesNotExistException;
import cms.model.interfaces.Job;
import cms.model.interfaces.Vehicle;
import cms.model.jobs.LandTransport;

public abstract class AbstractTransport implements Vehicle
{
    private String reg, make, model;
    private int year;
    private double odo, serviceInterval, lastServiced;

    public AbstractTransport(String reg, String make, String model, int year, double odo, double serviceInterval)
    {
        this.reg = reg;
        this.make = make;
        this.model = model;
        this.year = year;
        this.odo = odo;
        this.serviceInterval = serviceInterval;
        this.lastServiced = 0;
    }

    /* (non-Javadoc)
	 * @see cms.model.Vehicle#getLastServiced()
	 */
    @Override
	public double getLastServiced()
    {
        return lastServiced;
    }

    @Override
    public void recordService()
    {
        this.lastServiced = this.odo;
    }

    /* (non-Javadoc)
	 * @see cms.model.Vehicle#setOdo(double)
	 */
    @Override
	public final void addMileage(double mileage)
    {
        if (mileage < 0)
        {
            throw new IllegalArgumentException("Odometer can only take a positive number");
        }
        this.odo = this.odo + mileage;
    }

    /* (non-Javadoc)
	 * @see cms.model.Vehicle#getReg()
	 */
    @Override
	public String getReg()
    {
        return reg;
    }

    /* (non-Javadoc)
	 * @see cms.model.Vehicle#getMake()
	 */
    @Override
	public String getMake()
    {
        return make;
    }

    /* (non-Javadoc)
	 * @see cms.model.Vehicle#getModel()
	 */
    @Override
	public String getModel()
    {
        return model;
    }

    /* (non-Javadoc)
	 * @see cms.model.Vehicle#getYear()
	 */
    @Override
	public int getYear()
    {
        return year;
    }

    /* (non-Javadoc)
	 * @see cms.model.Vehicle#getOdo()
	 */
    @Override
	public double getMileage()
    {
        return odo;
    }

    /* (non-Javadoc)
	 * @see cms.model.Vehicle#getServiceInterval()
	 */
    @Override
	public double getServiceInterval()
    {
        return serviceInterval;
    }

    /**
     * Attempt to schedule a job
     *
     * @param id       Identifier for this job
     * @param distance distance travelled
     * @return a land transport job, it will only be applied to the vehicle if it's accepted.
     */
    @Override
    public Job scheduleJob(int id, double distance)
    {
        // Create proposed job
        Job job = new LandTransport(id, distance, this.getWearRate() * distance);
        // Check if this job is valid
        job.accept((this.getMileage() - this.getLastServiced()) + distance < this.getServiceInterval());

        if(job.isAccepted())
        {
            // Record new odometer for a valid job
            this.addMileage(distance);
        }
        return job;
    }

    @Override
    public String toString()
    {
        return String.format("Reg_Number: %s, Make: %s, Model: %s, Year: %d \nOdometer: %.2fkm, Last Serviced: %.2fkm, Service Interval: %.2fkm",
                             getReg(), getMake(), getModel(), getYear(), getMileage(), getLastServiced(), getServiceInterval());
    }
}
