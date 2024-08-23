import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Function<String,Integer> findWordCount = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.split(" ").length;
            }
        };

        int count = findWordCount.apply("my name is vivek");
        System.out.print(count);
    }
}