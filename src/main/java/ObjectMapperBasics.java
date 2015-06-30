import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ee on 19/06/15.
 */
public class ObjectMapperBasics {

    public static void main(String[] args) {

        ObjectMapper mapper = new  ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        Map<String,String> address = new HashMap<String,String>();
        address.put("addressLineOne", "Flat abc");
        address.put("addressLineTwo", "Milan");
        User user = new User("nameFromClass","newJob",address,22,"F");

        //Java to JSON   - generates user.json file
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("/home/ee/projects/self/src/main/java/user.json"), user);
        }
        catch(IOException io){
          io.printStackTrace();
        }

        //JSON to Java
        try{
        User userObj = mapper.readValue(new File("/home/ee/projects/self/src/main/java/jsonSample.json"),User.class);
        System.out.println(userObj);
        }
        catch(IOException io){
            io.printStackTrace();
        }

    }





}
