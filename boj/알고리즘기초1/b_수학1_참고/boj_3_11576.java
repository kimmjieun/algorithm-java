package 알고리즘기초1.b_수학1_참고;


import java.util.*;

// 11576번 Base Conversion
public class boj_3_11576 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int n = sc.nextInt();

        LinkedList<Integer> arr = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            arr.offer(sc.nextInt());
        }

        int sum = 0;
        int len = arr.size();

        for (int i = 1; i <= len; i++) {
            sum += Math.pow(A, len - i) * arr.peek();
            arr.pop();
        }

        arr.clear();

        while (sum > 0) {
            arr.offerFirst(sum % B);
            sum /= B;
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }

        sc.close();
    }
}


