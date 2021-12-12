package 알고리즘기초1.자료구조1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class boj_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> inputList = new ArrayList<>();

        // 1. 입력한 수를 list에 저장
        for (int i = 0; i < n; i++) {
            inputList.add(Integer.parseInt(br.readLine()));
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // 2. 1부터 n까지 순서대로 push 한다
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+\n");
            // 3. 만약 stack의 꼭대기 값과 저장한 리스트의 첫번째 값과 같다면 pop한다
            while (!stack.isEmpty() && !inputList.isEmpty() && stack.peek().equals(inputList.get(0))) {
                stack.pop();
                inputList.remove(0);
                sb.append("-\n");
            }
        }

        // 4. 반복문을 모두 돌았지만 stack이 비어있지 않다면 스택 수열은 불가능 한 경우
        if(!stack.isEmpty()){
            sb.setLength(0); // 초기화
            sb.append("NO\n");
        }

        System.out.print(sb.toString());

    }
}
