package cms.exceptions;

/**
 * @author Tristan McSwain
 *
 */
public class VehicleDoesNotExistException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5772825976274868518L;

	/**
	 * @param message
	 * 	Description of the cause for the exception
	 */
	public VehicleDoesNotExistException(String message)
	{
		super(message);
	}


}
