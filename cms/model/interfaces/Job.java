package cms.model.interfaces;

/**
 * A job for a particular vehicle scheduled fr4om the CMS
 */
public interface Job
{
    /**
     * Check if the job was accepted, if accepted the mileage is recorded against
     * the vehicle that was scheduled for this job
     *
     * @return <li>True: Job has been \scheduled for a vehicle<li/>
     *          <li>False: Job was not scheduled for the vehicle</li>
     */
    boolean isAccepted();

    /**
     * Denotes whether this job has been accepted or rejected
     * @param valid true if job is accepted, false if job is rejected
     */
    void accept(boolean valid);

    /**
     * Get job identifier
     *
     * @return identifier of job
     */
    int getId();

    /**
     * Get the amount of distance that will be covered completing this job
     *
     * @return distance on kms
     */
    double getDistance();

    /**
     * The wear and tear cost on the vehicle for this job
     *
     * @return vehicle wear and tear cost incurred on this job
     */
    double getWearAndTearCost();

    /**
     * Date this job was scheduled
     *
     * @return string formatted date
     */
    String getScheduledDate();

    /**
     * The profit accrued by this job
     * @return profit
     */
    double getProfit();

    /**
     * Get the gross cost for this job, includes wear and tear and profit margin
     *
     * @return gross cost
     */
    double getTotalCost();
}
