package trng.design;

/*
   1. Vehicle
   2. 4 tiers
   3. Engine
*/
class Vehicle {
	public static final int NUMBER_OF_TIERS = 4;
	private Tire[] tires;
	private Engine engine;

	public Vehicle(Engine engine) {
		tires = new Tire[NUMBER_OF_TIERS];
	}

	public Vehicle(Engine engine, Tire[] tiers) {
		tiers = new Tire[NUMBER_OF_TIERS];
		this.tires = tiers;
	}

	void startEngine() {
		engine.start();
	}

	void stopEngine() {
		engine.stop();
	}

	public void setTiers(Tire[] tiers) {
		this.tires = tiers;
	}
}

class Tire {
	String color;
}

class Engine {
	void start() {
	}

	void stop() {
	}
}
