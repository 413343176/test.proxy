package test.proxy.statical;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloProxy implements InvocationHandler {
	private Object subject;

	public HelloProxy(Object subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		method.invoke(subject, args);
		return null;
	}

	public static void main(String[] args) {
		Hello hello = new Hello();
		InvocationHandler handler = new HelloProxy(hello);
		HelloInterface hi = (HelloInterface) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
				hello.getClass().getInterfaces(), handler);
		hi.say();
	}
}
