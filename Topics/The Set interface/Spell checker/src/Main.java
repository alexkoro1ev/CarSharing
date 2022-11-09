import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<String> dic = new HashSet<>();
        List<String> l = new ArrayList<>();
        int w = s.nextInt();
        while (w >= 0) {
            l.add(s.nextLine().toLowerCase());
            w--;
        }
        int t = s.nextInt();
        while (t >= 0) {
            dic.addAll(List.of(s.nextLine().toLowerCase().split(" ")));
            t--;
        }
        dic.removeAll(l);
        for (String r : dic) {
            System.out.println(r);
        }
    }
}