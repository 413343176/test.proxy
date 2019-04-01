package test.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class HelloMethodInterceptor implements MethodInterceptor{

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		
		
		System.out.println(o.getClass() + "  " + method + " " + objects + " " + methodProxy);
		System.out.println("before");
//		method.invoke(o, objects);
		Method[] ms = o.getClass().getSuperclass().getDeclaredMethods();
		for(Method m : ms) {
			System.out.println(m.getName());
//			m.invoke(obj, args)
		}
		
//		m.setAccessible(true);
//		m.invoke(o, null);
		Object object = methodProxy.invokeSuper(o, objects);
		System.out.println("after");
//		method.invoke(o, objects);
		return object;
	}
	
	
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(HelloImpl.class);
		enhancer.setCallback(new HelloMethodInterceptor());
		HelloImpl hello = (HelloImpl)enhancer.create();
		hello.say1();
	}

}
