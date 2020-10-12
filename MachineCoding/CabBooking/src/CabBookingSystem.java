import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CabBookingSystem implements CabBookingSystemInteractor {
	
	//map storing customers objects corresponding to customer name
	HashMap<String, Person> customers;
	//map storing drivers objects corresponding to drivers name
	HashMap<String, Person> drivers;

	public CabBookingSystem() {
		this.customers = new HashMap<String, Person>();
		this.drivers = new HashMap<String, Person>();
	}

	//method to register a trip into the system
	@Override
	public void addTrip(String driverName, int driverToCustomerRating, String customerName,
			int customerToDriverRating) {
		Driver d = (Driver) drivers.get(driverName);
		Customer c = (Customer) customers.get(customerName);
		if (d == null) {
			d = new Driver(driverName);
			drivers.put(driverName, d);
		}
		d.addRating(customerName, customerToDriverRating);

		if (c == null) {
			c = new Customer(customerName);
			customers.put(customerName, c);
		}
		c.addRating(driverName, driverToCustomerRating);
	}

	//method to get the customer's average rating
	@Override
	public double getCustomerAverage(String customerName) throws PersonNotExistException{
		Customer c = (Customer) this.customers.get(customerName);
		if(c == null) throw new PersonNotExistException();
		return c.getAvg();
	}

	//method to get all the eligible drivers corresponding to the customer name
	@Override
	public List<Driver> getEligibleDrivers(String customerName) throws PersonNotExistException {
		List<Driver> eligibleDrivers = new LinkedList<Driver>();
		Customer customer = (Customer) customers.get(customerName);
		if(customer == null)  throw new PersonNotExistException();
		for (Map.Entry<String, Person> entry : drivers.entrySet()) {
			Driver d = (Driver) entry.getValue();
			if (d.getAvg() >= customer.getAvg() && isEligible(customer, d) && d.isOnline())
				eligibleDrivers.add(d);
		}

		if (eligibleDrivers.size() == 0) {
			List<String> drivers = customer.getTravelledWithPersons();
			for (String driver : drivers) {
				Driver d = (Driver) this.drivers.get(driver);
				//System.out.println(d.getName() + " " + d.isOnline());
				if (isEligible(customer, d) && d.isOnline())
					eligibleDrivers.add(d);
			}
		}

		return eligibleDrivers;
	}

	//method to check the eligibility of customer and driver based on criteria that no one has rated 1 to another
	private boolean isEligible(Person customer, Person driver) {
		if (customer.isEligible(driver) && driver.isEligible(customer))
			return true;
		return false;
	}

	//method to make driver offline or online
	@Override
	public void setDriverOnline(String driverName, boolean isOnline) throws PersonNotExistException {
		Driver d = (Driver) drivers.get(driverName);
		//System.out.println("setting " + d.getName() +isOnline);
		if (d != null) {
			d.setOnline(isOnline);
			return;
		}			
		 throw new PersonNotExistException();
	}

}
