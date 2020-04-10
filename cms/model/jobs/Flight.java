package cms.model.jobs;

import cms.model.interfaces.Job;

public class Flight extends AbstractJob
{

    public Flight(int id, double distance, double wearAndTearCost)
    {
        super(id, distance, wearAndTearCost);
    }

    public Flight(Job job)
    {
        this(job.getId(), job.getDistance(), job.getWearAndTearCost());
    }
}
