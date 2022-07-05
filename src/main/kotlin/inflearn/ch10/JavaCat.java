package inflearn.ch10;

public class JavaCat extends JavaAnimal{


    // 상속시 부모 클래스의 생성자를 서브 클래스에서 반드시 불러줘야하는 룰
    // 부모 클래스의 생성자가 없다면 디폴트 생성자가 호출된다
    public JavaCat(String species) {
        super(species, 4);
    }

    @Override
    public void move() {
        System.out.println("사뿐사뿐 고양이");
    }
}
