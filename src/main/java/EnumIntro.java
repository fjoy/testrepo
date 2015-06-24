/**
 * Created by ee on 15/06/15.
 */

public class EnumIntro{

//Enum declaration
public enum myEnums {
    HIGH(5),
    MEDIUM(3),    LOW(1) ;

    int number;
    private myEnums(int number){
        this.number = number;
    }

    int getNumber(){    // have to explicitly define method to get teh values
        return number;
    }
}

//method which uses the above enum
static final String priority = "MED" ;

public static void main(String[] args){

    String myPriority = EnumIntro.priority;
    myPriority = "Change value";  // values of variable given static final constants can be changed to any value but enums have to be one of the num values
    System.out.println(myPriority);

    for (myEnums enumValue : myEnums.values()){   // enums have a implicit values() method which gives array of enums
        System.out.println(enumValue);   // enum name
        System.out.println(enumValue.name()); // alternate way to get enum name
        System.out.println(enumValue.number);  // enum value

    }

    //Enums are type safe, they can have only types defined of that Enum type.
    myEnums myPriorityEnum = myEnums.MEDIUM;

}

}
