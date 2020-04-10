package cms.model.vehicle;

import cms.model.AbstractTransport;
import cms.model.interfaces.Job;
import cms.model.jobs.LandTransport;

public class Van extends AbstractTransport
{
    private final double wearRate = 0.6;

    public Van(String reg, String make, String model, int year, double odo, double serviceInterval)
    {
        super(reg, make, model, year, odo, serviceInterval);
    }


    @Override
    public double getWearRate()
    {
        return wearRate;
    }

    /**
     * Information about a van
     * @return
     *  A formatted string describing the vehicle attributes
     */
    @Override
    public String toString()
    {
        return String.format("Van: %s", super.toString());
    }
}
