package test.proxy.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;

import net.bytebuddy.implementation.MethodDelegation;

public class MainTest {
    public static void main(String[] args) throws Exception {
    		//version 1.8
//        String className = "test.proxy.bytebuddy.AgentTest";
//        TypePool typePool = TypePool.Default.ofClassPath();
//        TypeDescription resolve = typePool.describe(className).resolve();
//        ClassFileLocator locator = ClassFileLocator.ForClassLoader.ofClassPath();
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        new ByteBuddy()
//                .rebase(resolve, locator)
//                .method(ElementMatchers.named("fun2"))
//                .intercept(MethodDelegation.to(TimeInterceptor.getInstance()))
//                .make()
//                .load(classLoader, ClassLoadingStrategy.Default.INJECTION);
//
//        new AgentTest().fun1();
    	
    	//version 19.2
      String className = "test.proxy.bytebuddy.FooTest";
      ClassLoader classLoader = MainTest.class.getClassLoader();;
      System.out.println(classLoader);
      TypePool typePool = TypePool.Default.of(classLoader);
      TypeDescription resolve = typePool.describe(className).resolve();
      ClassFileLocator locator = ClassFileLocator.ForClassLoader.of(classLoader);
      
      new ByteBuddy()
              .rebase(resolve, locator)
              .method(ElementMatchers.named("fun2"))
              .intercept(MethodDelegation.to(Interceptor.getInstance()))
              .make()
              .load(classLoader, ClassLoadingStrategy.Default.INJECTION);

      new FooTest().fun1();
        
        
    }
}
