package main;

import java.util.*;

/**
 * Created by ee on 20/05/15.
 */
public class SomeMappingTime {

    public static void main(String[] args){
        Map<String,String> myMap  = new HashMap<String,String>();
        Map<String,String> myMap2 = new HashMap<String,String> ();
        myMap.put("key1", "value1");
        myMap.put("key2", "value2");
        myMap2.put("key3", "value3");
        myMap2.put("key4", "value4");
        System.out.println("myMap..."+myMap);

        //get map entries using iterator
        Iterator i = myMap.entrySet().iterator();     // returns set view of the map on which we can get a iterator
        while(i.hasNext()){
            Map.Entry entry = (Map.Entry)i.next();    // each entry in the map
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        myMap.putAll(myMap2);

//        Iterator i2 = myMap.entrySet().iterator();

        System.out.println("From myMap2...");

        Set entries = myMap2.entrySet();

        //using for loop instead of iterator
        for (Map.Entry entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }
}
