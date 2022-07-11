package inflearn.ch13;

public class Main {
    public static void main(String[] args) {
        JavaHouse house = new JavaHouse("제주도");
        System.out.println("house.getLivingRoom().getAddress() = " + house.getLivingRoom().getAddress());

        JavaHouse.LivingRoomWithStatic livingRoomWithStatic = new JavaHouse.LivingRoomWithStatic(100);
    }
}
