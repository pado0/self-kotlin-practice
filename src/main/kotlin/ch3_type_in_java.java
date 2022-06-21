public class ch3_type_in_java {
    public static void printAgeIfPerson (Object obj){
        if(obj instanceof Person){
            Person person = (Person) obj;
            System.out.println(person.getName());
        }
    }
}
