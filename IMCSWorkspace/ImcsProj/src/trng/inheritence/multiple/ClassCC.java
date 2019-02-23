package trng.inheritence.multiple;

public class ClassCC {

	ClassA objA = new ClassA();
	ClassB objB = new ClassB();
	
	public void test(){
		objA.doSomething();
	}
	
	public void methodA(){
		objA.methodA();
	}
	
	public void methodB(){
		objB.methodB();
	}
}