package 알고리즘기초1.a_자료구조1_연습;

import java.io.*;
import java.util.Stack;

// 17299번 오등큰수
public class boj_4_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열의 입력
        int num = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        // 결과값을 넣을 배열
        int[] result = new int[num];

        // 입력된 숫자를 담는 배열
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }


        // 숫자들의 등장한 횟수를 담는 배열
        int[] nums_count = new int[1000001]; // 이 수 주의
        for (int i = 0; i < num; i++)
            nums_count[nums[i]] += 1;

        // 인덱스를 담을 stack
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num; i++) {
            if (stack.isEmpty())
                stack.push(i);
            while (!stack.isEmpty() && nums_count[nums[stack.peek()]] < nums_count[nums[i]]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty())
            result[stack.pop()] = -1;

        for (int i = 0; i < num; i++) {
            bw.write(result[i] + " ");
        }

        bw.flush();
        return;
    }
}
