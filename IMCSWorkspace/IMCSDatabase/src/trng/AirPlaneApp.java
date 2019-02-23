package trng;

import static trng.AirPlaneUtil.changeAirPlaneCapacity;
import static trng.AirPlaneUtil.getAvailablePlanes;

public class AirPlaneApp {

	public static void main(String... args) {
		if (args.length < 1) {
			System.err.println("Argument is required");
			System.exit(0);
		}
		int noOfAirPlanes = Integer.parseInt(args[0]);
		AirPlane[] airPlanes = new AirPlane[noOfAirPlanes];
		
		for(int i=0; i<airPlanes.length; i++) {
			AirPlane temp = new AirPlane();
			airPlanes[i] = temp;
			temp.setInfo("Boing"+i, 786 + i, 240+i, "Suren"+i);
//			temp.displayInfo();
		}
		
		AirPlane[] availablePlanes = getAvailablePlanes(airPlanes, 245);
		for(int i=0; i<availablePlanes.length; i++) {
//			useAirPlane(airPlanes[i]);
			availablePlanes[i].displayInfo();
			System.out.println("-------------------\n");
		}
		
		changeAirPlaneCapacity(airPlanes, "Boing5");
		createNewAirPlane(airPlanes[0]);
	}

	private static AirPlane createNewAirPlane(AirPlane airPlane) {
		AirPlane newAirPlane = new AirPlane(airPlane);
		newAirPlane.setCapacity(250);
		return newAirPlane;
	}

	
}
