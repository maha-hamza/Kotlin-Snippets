import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LoadBalancerInJava {
    public static void main(String[] args) {
        var data1 = Arrays.asList(3, 1, 1, 4, 1, 1, 1, 1, 1);
        System.out.println(loadBalancer(data1));

        var data2 = Arrays.asList(1, 3, 4, 2, 2, 2, 1, 1, 2);
        System.out.println(loadBalancer(data2));

        var data3 = Arrays.asList(1, 1, 1, 1, 1, 1);
        System.out.println(loadBalancer(data3));

        var data4 = Arrays.asList(2, 2, 1, 1, 5, 1, 5);
        System.out.println(loadBalancer(data4));
    }

    private static Boolean loadBalancer(List<Integer> n) {
        var part1Sum = 0;
        var part2Sum = 0;
        var part3Sum = 0;

        for (var i = 1; i < n.size(); i++) {
            part1Sum = n.subList(0, i)
                    .stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            for (var j = n.size() - 2; j > i + 1; j--) {
                part2Sum = n.subList(j + 1, n.size())
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum();
                part3Sum = n.subList(i + 1, j)
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum();
                if (part1Sum != 0 && (part1Sum == part2Sum && part2Sum == part3Sum)) {
                    return true;
                }
            }

        }
        return false;
    }
}
