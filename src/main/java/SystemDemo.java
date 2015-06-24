import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
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
            File file = new File(dir+"/resources/ll.properties");
            props.load(new FileInputStream(file));
            //TODO have to find out how to read in the below case
           /* InputStream input = SystemDemo.class.getResourceAsStream("/resources/ll.properties");
            if(input!=null) {
                props.load(input);
            }*/
            System.out.println("From properties file :");
           /* System.out.println(props.getProperty("user.dir"));
            System.out.println(props.getProperty("os.name"));
            System.out.println(props.getProperty("sampleProp"));
*/
            //Better way to print props file
            Enumeration keys = props.keys();
            while(keys.hasMoreElements()){
                String key = (String) keys.nextElement();
                String value = props.getProperty(key);
                System.out.println(key + "=" + value);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File is not found!");
        }
    }
}
