import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int bridges = scanner.nextInt();
        int[] h = new int[bridges];
        boolean crashes = false;
        while (bridges > 0) {
            int next = scanner.nextInt();
            if (next <= height) {
                System.out.println("Will crash on bridge " + (h.length - bridges + 1));
                crashes = true;
                break;
            }
            bridges--;
        }
        if (!crashes) {
            System.out.println("Will not crash");
        }
    }
}