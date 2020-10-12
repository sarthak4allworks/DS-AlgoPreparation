import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		
		CabBookingSystemInteractor system = new CabBookingSystem();
		system.addTrip("d1", 4, "c1", 5);
		system.addTrip("d1", 5, "c2", 4);
		system.addTrip("d1", 1, "c3", 2);
		system.addTrip("d2", 5, "c1", 1);
		system.addTrip("d2", 5, "c2", 5);
		system.addTrip("d2", 4, "c3", 5);
		system.addTrip("d3", 3, "c1", 2);
		system.addTrip("d3", 4, "c2", 5);
		system.addTrip("d3", 3, "c3", 3);
		
		try {
			system.setDriverOnline("d1", false);
			system.setDriverOnline("d3", false);
		} catch (PersonNotExistException e) {
			System.out.println(e.getMessage());
		}
		
		//test case for customer c1
		try {
			System.out.println("Customer c1 rating : " + system.getCustomerAverage("c1"));
			System.out.println("Eligible drivers : ");
			LinkedList<Driver> drivers = (LinkedList<Driver>) system.getEligibleDrivers("c1");
			for(Driver d : drivers) {
				System.out.println("name : " + d.getName() + "  rating : " + d.getAvg());
			}
		} catch (PersonNotExistException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		//test case for customer c2
		try {
			System.out.println("Customer c2 rating : " + system.getCustomerAverage("c2"));
			System.out.println("Eligible drivers : ");
			LinkedList<Driver> drivers = (LinkedList<Driver>) system.getEligibleDrivers("c2");
			for(Driver d : drivers) {
				System.out.println("name : " + d.getName() + "  rating : " + d.getAvg());
			}
		} catch (PersonNotExistException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		//test case for customer c3
		try {
			System.out.println("Customer c3 rating : " + system.getCustomerAverage("c3"));
			System.out.println("Eligible drivers : ");
			LinkedList<Driver> drivers = (LinkedList<Driver>) system.getEligibleDrivers("c3");
			for(Driver d : drivers) {
				System.out.println("name : " + d.getName() + "  rating : " + d.getAvg());
			}
		} catch (PersonNotExistException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		
		//test case for not registered customer
		try {
			System.out.println("Customer rating : " + system.getCustomerAverage("c4"));
			System.out.println("Eligible drivers : ");
			LinkedList<Driver> drivers = (LinkedList<Driver>) system.getEligibleDrivers("c4");
			for(Driver d : drivers) {
				System.out.println("name : " + d.getName() + "  rating : " + d.getAvg());
			}
		} catch (PersonNotExistException e) {
			System.out.println(e.getMessage());
		}

	}

}
