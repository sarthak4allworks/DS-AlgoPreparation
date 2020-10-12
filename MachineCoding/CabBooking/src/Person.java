import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public abstract class Person {
	private String name;
	private long noOfTrips;
	private double avg; // average rating
	
	public String getName() {
		return name;
	}

	public double getAvg() {
		return avg;
	}

	// map stores all the ratings given to this person by other persons
	HashMap<String, List<Integer>> ratings;

	Person(String name) {
		this.name = name;
		this.noOfTrips = 0;
		this.avg = 0;
		ratings = new HashMap<String, List<Integer>>();
	}

	/* method to add rating given to this person by another person */
	public void addRating(String raterName, int rating) {
		avg = ((avg * noOfTrips) + rating) / (++noOfTrips);
		List<Integer> l = this.ratings.get(raterName);
		if (l == null) {
			l = new LinkedList<Integer>();
			ratings.put(raterName, l);
		}
		l.add(rating);
	}

	/*
	 * method returns whether this person is eligible for the person 'p' based on
	 * criteria whether 'p' has rated him 1 before or not
	 */
	public boolean isEligible(Person p) {
		String raterName = p.name;
		LinkedList<Integer> list = (LinkedList<Integer>) ratings.get(raterName);
		if (list == null)
			return true;
		else if (list.contains(1))
			return false;
		else
			return true;
	}

	/*
	 * method returns list of all the persons with whom this person has traveled
	 * earlier
	 */
	public List<String> getTravelledWithPersons() {
		List<String> persons = new LinkedList<String>();
		for (Entry<String, List<Integer>> entry : ratings.entrySet()) {
			persons.add(entry.getKey());
		}
		return persons;

	}

}
