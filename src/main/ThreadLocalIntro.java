package main;

/**
 * Created by ee on 12/06/15.
 */
public class ThreadLocalIntro {

    public static void main(String[] args){
        ThreadLocal tl = new ThreadLocal<String>();
        tl.set("my tl value1");
        System.out.println(tl.get());



    //Each thread can set a value to the variable that is visible only to the particular thread using the above 'set' method.
    //But there can be a initial value for the variable that is visible to all threads.

    tl = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "Initial value";
        }
    };

    System.out.println(tl.get());
    }
}
