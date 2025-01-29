
import java.util.stream.IntStream;

public class streamsStringReverse {
    public static void main(String[] args) {
        String input = "Hello World";

        /* 
        String revString = IntStream.range(1, input.length()+1)
                            .mapToObj(i -> input.charAt(input.length() - i))
                            .map(String::valueOf)
                            .collect(Collectors.joining());

              OR
        
        String revString = IntStream.rangeClosed(1, input.length())
                            .mapToObj(i -> input.charAt(input.length() - i))
                            .map(String::valueOf)
                            .collect(Collectors.joining());
        */
        IntStream.rangeClosed(1, input.length())
                        .mapToObj(i -> input.charAt(input.length() - i))
                        .map(String::valueOf)
                        .forEach(System.out::print);

        System.out.println("");

        //System.out.println("reversed String :" + revString);
    }
}
