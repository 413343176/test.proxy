package test.proxy.cglib;

public class HelloImpl {
	
	private void say() {
		System.out.println("hello say");

	}
	
	public void say1() {
		say();
		System.out.println("hello say1");

	}
}
