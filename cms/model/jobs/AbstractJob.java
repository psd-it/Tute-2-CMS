package cms.model.jobs;

import cms.model.interfaces.Job;

import java.text.DateFormat;

public abstract class AbstractJob implements Job
{
    protected int id;
    protected double kms;
    protected double wearAndTearCost;
    protected String scheduledDate;
    protected boolean isValid;

    public AbstractJob(int id, double distance, double wearAndTearCost)
    {
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
    @Override
    public boolean isAccepted()
    {
        return isValid;
    }

    /**
     * Vehicles registration handling this job
     *
     * @return the vehicleRego
     */
    @Override
    public int getId()
    {
        return id;
    }

    /**
     * Number of Kilometers traveled to complete this job
     *
     * @return the kms
     */
    @Override
    public double getDistance()
    {
        return kms;
    }

    /**
     * Date and time this job was accepted
     *
     * @return the scheduledDate
     */
    @Override
    public String getScheduledDate()
    {
        return scheduledDate;
    }

    /**
     * Ammount of profit made on this job
     *
     * @return profit
     */
    @Override
    public double getProfit()
    {
        return  wearAndTearCost / 2;
    }

    /**
     * Cost of the job the customer will be charged
     *
     * @return totalCost
     */
    @Override
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
                             getId(), getDistance(), getTotalCost(), getWearAndTearCost(), getProfit());
    }


    /**
     * Dictates if the job is accepted
     *
     * @param valid true if accepted, false if rejected
     */
    @Override
    public void accept(boolean valid)
    {
        this.isValid = valid;
    }

    /**
     * ?The anticipated wear and tear cost of this job
     *
     * @return the wearAndTearCost
     */
    @Override
    public double getWearAndTearCost()
    {
        return wearAndTearCost;
    }
}
