import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciNumbers {
    public static final int N = 4;

    public static void main(String[] args) {
        List<Integer> result = countFib();
        result.forEach(System.out::println);

        List<Integer> resultFibStream = countFibWithStreams();
        resultFibStream.forEach(System.out::println);
    }

    private static List<Integer> countFibWithStreams() {
        List<Integer> result = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(N)
                .map(t -> t[0])
                .collect(Collectors.toList());
        return result;
    }

    private static List<Integer> countFib() {
        List<Integer> result = new ArrayList<>();
        if (N == 1) {
            result.add(0);
        } else if (N == 2) {
            result.add(0);
            result.add(1);
        } else {
            int nextFibNumber;
            result.add(0);
            result.add(1);
            for(int i = 2; i < N; i++){
                nextFibNumber = result.get(i-1) + result.get(i-2);
                result.add(nextFibNumber);
            }
        }
        return result;
    }
}
