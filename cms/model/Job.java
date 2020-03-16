package cms.model;

import java.text.DateFormat;

public class Job
{
    private int id;
    private double kms;
    private double wearAndTearCost;
    private String scheduledDate;
    private boolean isValid;

    /**
     * Constructs a new job
     *
     * @param id
     *  Unique identifier of the job
     * @param distance
     *  Distance in kilometers, must be a positive number greater than 0
     * @param wearAndTearCost
     *  Expected wear and tear cost on the vehicle, must be a positive number greater than 0
     */
    public Job(int id, double distance, double wearAndTearCost)
    {
        if (id < 0|| distance <= 0 || wearAndTearCost <= 0)
        {
            throw new IllegalArgumentException("Job parameters are invalid!");
        }
        this.id = id;
        this.kms = distance;
        this.wearAndTearCost = wearAndTearCost;
        this.scheduledDate = DateFormat.getInstance().format(System.currentTimeMillis());
    }

    /**
     * Denotes if this is a valid job
     *
     * @return true if accepted, false if rejected
     */
    public boolean isValid()
    {
        return isValid;
    }

    /**
     * Dictates if the job is accepted
     *
     * @param valid true if accepted, false if rejected
     */
    public void setValid(boolean valid)
    {
        isValid = valid;
    }

    /**
     * Vehicles registration handling this job
     *
     * @return the vehicleRego
     */
    public int getId()
    {
        return id;
    }

    /**
     * Number of Kilometers traveled to complete this job
     *
     * @return the kms
     */
    public double getKms()
    {
        return kms;
    }

    /**
     * ?The anticipated wear and tear cost of this job
     *
     * @return the wearAndTearCost
     */
    public double getWearAndTearCost()
    {
        return wearAndTearCost;
    }

    /**
     * Date and time this job was accepted
     *
     * @return the scheduledDate
     */
    public String getScheduledDate()
    {
        return scheduledDate;
    }

    /**
     * Ammount of profit made on this job
     *
     * @return profit
     */
    public double getProfit()
    {
        return  wearAndTearCost / 2;
    }

    /**
     * Cost of the job the customer will be charged
     *
     * @return totalCost
     */
    public double getTotalCost()
    {
        return wearAndTearCost + getProfit();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return String.format("Id: %d, Distance: %.2f, Cost: $%.2f, Expense: $%.2f, Profit: $%.2f",
                             getId(), getKms(), getTotalCost(), getWearAndTearCost(), getProfit());
    }


}
