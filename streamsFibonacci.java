
import java.util.stream.Stream;

public class streamsFibonacci {
    public static void main(String[] args) {
        int n = 10;

        Stream.iterate(new int[]{0,1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
            .limit(n)
            .map(fib -> fib[0])
            .forEach(System.out::println);
    }
}
