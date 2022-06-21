public class ch3_type_in_java {
    public static void main(String[] args) {
        JavaMoney money1 = new JavaMoney(1000);
        JavaMoney money2 = new JavaMoney(2000);
        JavaMoney money3 = new JavaMoney(3000);
    }
    public static void printAgeIfPerson (Object obj){
        if(obj instanceof Person){
            Person person = (Person) obj;
            System.out.println(person.getName());
        }
    }
}
