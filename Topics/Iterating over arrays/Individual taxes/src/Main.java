import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] incomes = new int[num];
        int[] taxes = new int[num];
        double max = 0;
        int counter = 0;

        for (int i = 0; i < num; i++) {
            incomes[i] = scanner.nextInt();
        }

        for (int j = 0; j < num; j++) {
            taxes[j] = scanner.nextInt();
        }

        for (int k = 0; k < num; k++) {
            double t = incomes[k] * (taxes[k] / 100.0);
            if (t > max) {
                counter = k + 1;
                max = t;
            }
        }
        System.out.println(counter);
    }
}