import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ch7_exception {
    // 주어진 문제를 정수로 변경하는 예제
    public static void main(String[] args) throws IOException {
        parseIntOrThrow("123");
        //parseIntOrThrow("A");

        readFile();
    }

    private static int parseIntOrThrow(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) { // 파싱에 실패하면 number format exception이 나오니까 그때 예외를 던진다
            throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다", str));
        }
    }

    // 파일 안 내용물을 가져오는 예제
    public static void readFile() throws IOException {
        File currentFile = new File("."); // 현재 위치 찾고
        File file = new File(currentFile.getAbsolutePath() + "/src/main/a.txt"); // 절대 위치 기준 a라는 파일 가져오기
        BufferedReader reader = new BufferedReader(new FileReader(file)); // 파일을 버퍼로 한줄한줄 읽어
        System.out.println(reader.readLine()); // 결과 출력
        reader.close(); // 후 닫아주기
    }

    public void readFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println(reader.readLine());
        }
    }

}
