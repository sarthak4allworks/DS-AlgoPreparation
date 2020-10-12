import java.util.List;

public interface CabBookingSystemInteractor {

	void addTrip(String driverName, int driverRating, String customerName, int customerRating);
	
	double getCustomerAverage(String customerName) throws PersonNotExistException;
	
	List<Driver> getEligibleDrivers(String customerName) throws PersonNotExistException;
	
	public void setDriverOnline(String driverName, boolean isOnline) throws PersonNotExistException;
	
}
