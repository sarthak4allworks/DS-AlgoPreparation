
public class Driver extends Person{

	private boolean isOnline;
	
	Driver(String name) {
		super(name);
		this.isOnline = true;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	
	
	
}
