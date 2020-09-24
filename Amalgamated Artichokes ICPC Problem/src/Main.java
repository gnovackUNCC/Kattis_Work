import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int p = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int n = scan.nextInt();

        PriorityQueue<Price> prices = new PriorityQueue<>(n, (o1, o2) -> {
            if(o1.value > o2.value)
                return 1;
            else if(o1.value == o2.value)
                return 0;
            else
                return -1;
        });

        for(int k = 1; k < n + 1; k++){
            prices.offer(new Price(k, p * (Math.sin(a * k + b) + Math.cos(c * k + d) + 2)));
        }



        double maxDecrease = 0;

        System.out.println(maxDecrease + "");
    }
}
