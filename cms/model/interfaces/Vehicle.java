package cms.model.interfaces;

public interface Vehicle {

	double getLastServiced();

	/**
	 * Adds the passed in value to the odometer reading
	 *
	 * @param mileage the number of Kilometers to add to the odometer
	 */
	void addMileage(double mileage);

	/**
	 * The registration of the vehicle
	 *
	 * @return rego
	 */
	String getReg();

	/**
	 * The manufacturer of this vehicle
	 *
	 * @return make
	 */
	String getMake();

	/**
	 * The model of this vehicle
	 *
	 * @return model
	 */
	String getModel();

	/**
	 * The year the vehicle was manufactured
	 * @return year
	 */
	int getYear();

	/**
	 * Gets the current odometer reading of the vehicle
	 *
	 * @return odometer
	 */
	double getMileage();

	/**
	 * Defines the recommended service interval for the vehicle
	 *
	 * @return serviceInterval
	 */
	double getServiceInterval();

	/**
	 * Gets the rate charged per KM for wear and tear
	 *
	 * @return rate
	 */
	double getWearRate();

	/**
	 * Records the odometer reading of a service
	 */
	void recordService();

	/**
	 * Attempt to schedule a job
	 *
	 * @param id       Identifier for this job
	 * @param distance distance travelled
	 * @return job it will only be applied to the vehicle if it's accepted
	 */
	Job scheduleJob(int id, double distance);

}