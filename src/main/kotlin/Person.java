import org.jetbrains.annotations.Nullable;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Nullable
    public String getName() {
        return name;
    }

    private boolean startsWIthA(Object obj) {
        if (obj instanceof String) {
            return ((String) obj).startsWith("A");
        }
        return false;
    }

    private void judgeNumber2(int number) {
        if (number == 0) {
            System.out.println("0입니다");
            return;
        }
        if (number % 2 == 0) {
            System.out.println("짝수입니다");
            return;
        }

        System.out.println("홀수입니다.");
    }
}