package cms.model.interfaces;

public interface Vehicle {

	double getLastServiced();

	/**
	 * Adds the passed in value to the odometer reading
	 *
	 * @param odo the number of Kilometers to add to the odometer
	 */
	void addKmToOdometer(double odo);

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
	double getOdo();

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

}