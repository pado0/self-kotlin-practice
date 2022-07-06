package inflearn.ch12;

public class anonymous {

    public static void main(String[] args) {
        moveSomething(new Movable() {
            @Override
            public void move() {
                System.out.println("움직임");
            }

            @Override
            public void fly() {
                System.out.println("날다");
            }
        });

    }
    private static void moveSomething(Movable movable) {
        movable.move();
        movable.fly();
    }
}
