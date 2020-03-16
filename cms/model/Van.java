package cms.model;

public class Van extends cms.model.AbstractVehicle
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
