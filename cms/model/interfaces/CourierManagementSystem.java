package cms.model.interfaces;

public interface CourierManagementSystem
{
    /**
     * Add a new vehicle to the fleet
     *
     * @param vehicle
     *  Vehicle to add
     */
    void addVehicle(Vehicle vehicle);

    /**
     * Describes the vehicle with the requested rego
     *
     * @param rego
     *  Identify the vehicle to describe
     */
    void displayVehicleInfo(String rego);

    /**
     * Services the vehicle recording the odometer in the vehicle
     * @param rego
     *  Vehicle to service
     */
    void serviceVehicle(String rego);

    /**
     * Attempt to schedule a job for a vehicle
     *
     * @param distance
     *  Distance in kilometers the vehicle will travel to complete this job
     *
     * @param rego
     *  The vehicle the job will be scheduled for
     *
     * @return
     *  true - the job was accepted
     *  false - the job was rejected
     */
    boolean scheduleJob(double distance, String rego);

    /**
     * Displays the vehicle information for every vehicle in the fleet
     */
    void displayAllVehicles();

    /**
     * Displays all accepted jobs
     */
    void displayAllJobs();


    /**
     * Remove a vehicle from the manage system
     *
     * @param vehicleRego ID of the vehicle
     */
    void removeVehicle(String vehicleRego);

    /**
     * Remove a vehicle from the manage system
     *
     * @param vehicleRego ID of the vehicle
     * @return Vehicle with the parameter identifier
     */
    Vehicle getVehicle(String vehicleRego);
}
