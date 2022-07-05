package inflearn;

import org.jetbrains.annotations.NotNull;

class JavaMoney implements Comparable<JavaMoney> {

    private final long amount;

    JavaMoney(long amount) {
        this.amount = amount;
    }


    @Override
    public int compareTo(@NotNull JavaMoney o) {
        // 주어진게 더 작으면 양수, 같으면 0 , 더 크면 음수를 반환
        return Long.compare(this.amount, o.amount);
    }
}
