package 스택_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] res = new int[n];
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            res[i] = -1; // 1을 모두 초기화해준다
            a[i] = Integer.parseInt(st.nextToken()); // 입력값을 받는다.
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (int i = 1; i < n; i++) {
            while(!stack.isEmpty() && a[stack.peek()]<a[i]){ // 스택이 비어있지 않고 스택에 들어있는 top의 값보다 리스트의 값이 더 클 때
                res[stack.pop()]=a[i]; // 결과배열에 오큰수를 넣어준다.
            }
            stack.push(i); // 스택에 들어있는 값이 a[i]보다 클 때 push

        }

        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }


    }
}
