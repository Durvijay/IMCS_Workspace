package trng;

import java.util.ArrayList;
import java.util.List;

public class AirPlaneUtil {

	public static void changeAirPlaneCapacity(final AirPlane[] airPlanes, String make) {
		AirPlane matchingAirPlane = null;
		for (AirPlane airPlane : airPlanes) {
			if (airPlane.getMake().equals(make)) {
				matchingAirPlane = airPlane;
				break;
			}
		}
		
		//do something to use matchingAirPlane
		if(matchingAirPlane != null) {
			matchingAirPlane.setCapacity(300);
		}
	}

	public static List<AirPlane> getAvailablePlanes(final List<AirPlane> airPlanes, int noOfSeats) {
		List<AirPlane> availablePlanes = new ArrayList<>();
		for(AirPlane airPlane : airPlanes) {
			if (airPlane.canAccomodate(noOfSeats)) {
				availablePlanes.add(airPlane);
			}
		}
		
		return availablePlanes;
	}

	
	public static AirPlane[] getAvailablePlanes(AirPlane[] airPlanes, int noOfSeats) {
		List<AirPlane> availablePlanes = new ArrayList<>();
		for(AirPlane airPlane : airPlanes) {
			if (airPlane.canAccomodate(noOfSeats)) {
				availablePlanes.add(airPlane);
			}
		}
		
		return availablePlanes.toArray(new AirPlane[0]);
	}


	public static void useAirPlane(final AirPlane airPlane) {
//		airPlane.setInfo("AirBus", 789, 550, "Exc");
		airPlane.displayInfo();
		if(airPlane.canAccomodate(250)) {
			System.out.println("Its tooo big");
		} else {
			System.out.println("Its ok");
		}
		
		airPlane.setCapacity(500);;
		
		airPlane.getCapacity();
	}
}
