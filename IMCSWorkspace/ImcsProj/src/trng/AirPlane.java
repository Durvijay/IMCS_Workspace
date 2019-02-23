package trng;

public class AirPlane {
    private String make;
    private int model;
    private int capacity;
    private String pilot;
    private static int MAX_CAPACITY = true ? 500 : 600;
    
    static {
    	if (true) //any condition 
    		MAX_CAPACITY = 550;
    	else 
        	MAX_CAPACITY = 600;
        	
    }
    
    {
    	//init logic
    }
    
    public AirPlane() {
		super();
	}

    public AirPlane(AirPlane airPlane) {
    	super();
		this.make = airPlane.make;
		this.model = airPlane.model;
		this.capacity = airPlane.capacity;
		this.pilot = airPlane.pilot;
	}
    
	public AirPlane(String make, int model, int capacity, String pilot, final String planeName) {
		super();
		this.make = make;
		this.model = model;
		this.capacity = capacity;
		this.pilot = pilot;
	}

	public void setInfo(String make, int model, int capacity, String pilot) {
    	this.make = make;
    	this.model = model;
    	this.capacity = capacity;
    	this.pilot = pilot;
    }
    
    public boolean canAccomodate(final int noOfPassengers) {
    	/*if (capacity > noOfPassengers) {
    		return true;
    	} else {
    		return false;
    	}*/
    	
    	return capacity > noOfPassengers;
    }
    
    
    
    public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		if (capacity> 50 && capacity < 350)
			this.capacity = capacity;
		else 
			throw new RuntimeException("Capacity not in range");
	}

	public void displayInfo() {
    	System.out.println("Make: " + make);
    	System.out.println("model: " + model);
    	System.out.println("capacity: " + capacity);
    	System.out.println("pilot:" + pilot);
    }
	
	public static int getMaxCapacity() {
		/*if (capacity > MAX_CAPACITY) {
			//dosomething
		}*/
		return MAX_CAPACITY;
	}
	
	public AirPlane getHighCapacityPlane(AirPlane airPlane) {
		return this.getCapacity() > airPlane.getCapacity() ? this : airPlane;
	}
}
