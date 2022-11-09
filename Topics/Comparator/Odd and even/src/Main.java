import java.util.Comparator;
import java.util.List;

class Utils {

    public static List<Integer> sortOddEven(List<Integer> numbers) {

        Comparator<Integer> comparator = (x, y) ->
                (x % 2 == 0 && y % 2 == 0) ? Integer.compare(y, x) :
                (x % 2 != 0 && y % 2 == 0) ? -1 :
                        x % 2 == 0 ? 1 : Integer.compare(x, y);

        numbers.sort(comparator);
        return numbers;
    }
}