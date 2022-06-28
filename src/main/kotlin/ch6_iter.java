import java.util.Arrays;
import java.util.List;

public class ch6_iter {
    public static void main(String[] args) {

        List<Long> numbers = Arrays.asList(1L, 2L, 3L);
        for (Long number : numbers) {
            System.out.println("number = " + number);
        }

    }
}
