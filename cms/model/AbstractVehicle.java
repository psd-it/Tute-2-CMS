package cms.model;

import cms.model.interfaces.Vehicle;

public abstract class AbstractVehicle implements Vehicle
{
    private String reg, make, model;
    private int year;
    private double odo, serviceInterval, lastServiced;

    public AbstractVehicle(String reg, String make, String model, int year, double odo, double serviceInterval)
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
    public final void recordService()
    {
        this.lastServiced = this.odo;
    }

    /* (non-Javadoc)
	 * @see cms.model.Vehicle#setOdo(double)
	 */
    @Override
	public final void addKmToOdometer(double odo)
    {
        if (odo < 0)
        {
            throw new IllegalArgumentException("Odometer can only take a positive number");
        }
        this.odo = this.odo + odo;
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
	public double getOdo()
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

    /* (non-Javadoc)
	 * @see cms.model.Vehicle#getWearRate()
	 */
    @Override
	public abstract double getWearRate();

    @Override
    public String toString()
    {
        return String.format("Reg_Number: %s, Make: %s, Model: %s, Year: %d \nOdometer: %.2fkm, Last Serviced: %.2fkm, Service Interval: %.2fkm",
                                getReg(), getMake(), getModel(), getYear(), getOdo(), getLastServiced(), getServiceInterval());
    }
}
