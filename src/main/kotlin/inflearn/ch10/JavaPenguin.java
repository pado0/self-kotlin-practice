package inflearn.ch10;

public class JavaPenguin extends JavaAnimal implements Swimable, Flyable{

    private final int wingCount;

    public JavaPenguin(String species) {
        super(species, 2);
        this.wingCount = 2;
    }

    @Override
    public void move() {
        System.out.println("펭귄자바 움직인다");
    }

    // Animal의 getter를 오버라이드
    @Override
    public int getLegCount(){
        return super.legCount + this.wingCount;
    }

    @Override
    public void act() {
        Swimable.super.act();
        Flyable.super.act();
    }
}
