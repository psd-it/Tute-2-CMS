package cms.model;

import cms.exceptions.VehicleDoesNotExistException;
import cms.model.interfaces.CourierManagementSystem;
import cms.model.interfaces.Vehicle;
import cms.model.interfaces.Job;
import cms.model.jobs.LandTransport;

import java.util.*;

public class CourierManagementSystemImpl implements CourierManagementSystem
{
    private Map<String, Vehicle> vehicles;
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
    	// Create proposed job
    	Job job = this.vehicles.get(rego).scheduleJob(jobs.size(), distance);
    	// Track job whether valid or not
    	jobs.add(job);
    	return job.isAccepted();
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
    	    if (j.isAccepted())
            {
                System.out.println(j);
            }
    	}
    }

    /**
     * Remove a vehicle from the manage system
     *
     * @param vehicleRego ID of the vehicle
     */
    @Override
    public void removeVehicle(String vehicleRego)
    {
        Vehicle vehicle = vehicles.remove(vehicleRego);
        if (vehicle == null)
        {
            throw new IllegalArgumentException(String.format("Vehicle with registration %s doesn't exist", vehicleRego));
        }
    }

    /**
     * Remove a vehicle from the manage system
     *
     * @param vehicleRego ID of the vehicle
     * @return Vehicle with the parameter identifier
     */
    @Override
    public Vehicle getVehicle(String vehicleRego)
    {
        // Would have rather thrown an exception than just return null here
        return vehicles.get(vehicleRego);
    }
}

