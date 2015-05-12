package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ee on 11/05/15.
 */
public class SystemDemo {

    public static void main(String[] args){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("java.runtime.version"));

        Properties props = new Properties();
        try {
            String dir = System.getProperty("user.dir");
//            props.load(new FileInputStream(dir + "/resources/myProps.properties"));
            InputStream input = SystemDemo.class.getResourceAsStream("myProps.properties");
            if(input!=null) {
                props.load(input);
            }
            System.out.println("From myProps file :");
            System.out.println(props.getProperty("user.dir"));
            System.out.println(props.getProperty("os.name"));
            System.out.println(props.getProperty("sampleProp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
