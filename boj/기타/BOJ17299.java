package 기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열 a의 크기 n
        int n = Integer.parseInt(br.readLine());

        // 수열 a의 원소를 저장할 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] f = new int[1000001]; // 최대 수열 길이 0으로 초기화

        // 각 숫자의 f 값 저장
        for (int i = 0; i < n; i++) {
            f[a[i]] += 1;
        }

        // 스택 선언
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && f[a[stack.peek()]] < f[a[i]]) {
                ans[stack.pop()] = a[i];
            }

            stack.push(i);

        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);


    }
}
