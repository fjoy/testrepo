import java.util.Map;

/**
 * Created by ee on 23/06/15.
 */
public class User {

   User(){

   }

    private String name;
    private String occupation;
    private Map<String,String> address;
    private int age;
    private String sex;

    User(String name, String occupation,Map<String,String> address,int age,String sex){
        this.name= name;
        this.occupation= occupation;
        this.address= address;
        this.age= age;
        this.sex= sex;
    }


    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Map<String,String> getAddress() {
        return address;
    }

    public void setAddress(Map<String,String> address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString(){
        return "Name :" + name +"," ;
    }


}
