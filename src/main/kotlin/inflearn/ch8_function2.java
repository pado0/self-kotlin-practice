package inflearn;

public class ch8_function2 {
    public static void main(String[] args) {
        String[] array = new String[]{"A", "B", "C"};
        printAll(array);
        printAll("a", "b", "c");
    }

    // new 라인 옵션에 따른 줄바꿈 적용여부
    public void repeat(String str, int num, boolean useNewLine) {
        for (int i = 1; i <= num; i++) {
            if (useNewLine) {
                System.out.println(str);
            } else {
                System.out.print(str);
            }
        }
    }

    // useNewLine = true를 많이 쓴다면 오버로딩으로 true 옵션 함수 선언
    public void repeat(String str, int num) {
        repeat(str, num, true);
    }

    // 많은 코드에서 출력을 3회씩 하고있다면?
    public void repeat(String str) {
        repeat(str, 3, true);
    }

    public static void printAll(String... strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
