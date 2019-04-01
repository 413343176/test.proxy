package test.proxy.bytebuddy;

import java.util.Date;

public class FooTest {

    public void fun1()  {
        System.out.println("this is fun 1.");
        fun2(new Date());

    }

    private void fun2(Date date) {
        System.out.println("this is fun 2. " + date);
    }


}
