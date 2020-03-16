package cms.model;

import cms.exceptions.VehicleDoesNotExistException;
import cms.model.interfaces.CourierManagementSystem;
import cms.model.interfaces.Vehicle;

import java.util.*;

public class CourierManagementSystemImpl implements CourierManagementSystem
{
    private HashMap<String, Vehicle> vehicles;
    private Collection<Job> jobs;

    public CourierManagementSystemImpl()
    {
        this.vehicles = new HashMap<>();
        this.jobs = new Vector<>();
    }

    @Override
    public void addVehicle(Vehicle vehicle)
    {
        if(vehicle == null)
        {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        vehicles.put(vehicle.getReg(), vehicle);
    }

    @Override
    public void displayVehicleInfo(String rego)
    {
    	// Don't like calling System.out.print in here instead of returning string
        System.out.println(vehicles.get(rego));
    }

    @Override
    public void serviceVehicle(String rego)
    {
    	if(!this.vehicles.containsKey(rego))
    	{
    		throw new VehicleDoesNotExistException("No vehicle exists in the fleet with rego " + rego);
    	}
    	this.vehicles.get(rego).recordService();
    }

    @Override
    public boolean scheduleJob(double distance, String rego)
    {
    	if(!this.vehicles.containsKey(rego))
    	{
    		throw new VehicleDoesNotExistException("No vehicle exists in the fleet with rego " + rego);
    	}
    	// get vehicle ref for simplicity
        Vehicle vehicle = this.vehicles.get(rego);
    	// Create proposed job
    	Job job = new Job(jobs.size(), distance, vehicle.getWearRate() * distance);
    	// Check if this job is valid
    	job.setValid((vehicle.getOdo() - vehicle.getLastServiced()) + distance < vehicle.getServiceInterval());
    	// Track job whether valid or not
    	jobs.add(job);

    	if(job.isValid())
    	{
    	    // Record new odometer for a valid job
    		vehicle.addKmToOdometer(distance);
    	}
    	return job.isValid();
    }

    @Override
    public void displayAllVehicles()
    {
    	for(Vehicle v : vehicles.values())
    	{
    		System.out.println(v);
    	}
    }

    @Override
    public void displayAllJobs()
    {
    	for(Job j : jobs)
    	{
    	    if (j.isValid())
            {
                System.out.println(j);
            }
    	}
    }
}

