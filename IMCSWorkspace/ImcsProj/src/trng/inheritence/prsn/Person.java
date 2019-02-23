package trng.inheritence.prsn;

public class Person {

	private String gender;
	String name;
	protected String color;

	public Person(String nm, String gen) {
		this.name = nm;
		this.gender = gen;
	}

	public Person(String gender, String name, String color) {
		super();
		this.gender = gender;
		this.name = name;
		this.color = color;
	}

	public Person() {

	}

	public void eat() {
		System.out.println("Person eating");
	}

	public void display() {
		System.out.println("Person information: ");
		System.out.println(" Name : " + name);
		System.out.println(" Gender : " + gender);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [gender=" + gender + ", name=" + name + ", color=" + color + "]";
	}

}
