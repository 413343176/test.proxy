package test.proxy.bytebuddy;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.util.concurrent.Callable;

public class Interceptor {


    @RuntimeType
    public void intercept(@SuperCall Callable<?> zuper, @AllArguments Object... args) throws Exception {
        System.out.println("agent start " + args[0]);
        zuper.call();
        System.out.println("agent end " + zuper);
    }
    
    
    
    private Interceptor(){}
    
    private static class SingleTonHoler{
       private static Interceptor INSTANCE = new Interceptor();
   }
   
    public static Interceptor getInstance(){
      return SingleTonHoler.INSTANCE;
    }



}
