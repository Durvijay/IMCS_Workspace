package trng.polymorphism;

import java.util.ArrayList;
import java.util.List;


interface Animal {
	public final static int LEGS_COUNT = 4; 
	
	public void communicate();
}

class Dog implements Animal {
	public void communicate() {
		System.out.println("Bow Bow");
	}
	
	public boolean smell() {
		System.out.println("Smelling...");
		return true;
	}
}

class Cat implements Animal {
	private String color = "Brown";
	
	public void communicate() {
		System.out.println("Mew Mew");
	}
}

class Rabit implements Animal {
	public final void communicate() {
		throw new RuntimeException("can't communicate");
	}
}


public class AnimalTest {
	public static void main(String... args) {
		
		Animal dog = new Dog();
		Animal cat = new Cat();
		Animal rabit = new Rabit();
		
		dog.communicate();
		cat.communicate();
		rabit.communicate();
		
		/*List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Rabit());
		for(Animal animal: animals) {
			animal.communicate();
		}*/
	}
}