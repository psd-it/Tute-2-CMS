package cms.model;

public class Truck extends AbstractVehicle
{
    private final int capacity;
    private final double wearRate = 0.5;

    public Truck(String reg, String make, String model, int year, double odo, double serviceInterval, int capacity)
    {
        super(reg, make, model, year, odo, serviceInterval);
        this.capacity = capacity;
    }

    public int getCapacity()
    {
        return capacity;
    }

    @Override
    public double getWearRate()
    {
        return wearRate * capacity;
    }

    @Override
    public String toString()
    {
        return String.format("Truck: Reg_Number: %s, Make: %s, Model: %s, Year: %d, Capacity: %d \nOdometer: %.2fkm, Last Serviced: %.2fkm, Service Interval: %.2fkm",
                             getReg(), getMake(), getModel(), getYear(), getCapacity(), getOdo(), getLastServiced(), getServiceInterval());
    }
}
