package 알고리즘기초1.자료구조1_참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 1935번 후위 표기식2
public class boj_1_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 후위 표기식을 저장, 피연산자는 A부터 순서대로 N개의 영대문자만이 사용
        char[] array = br.readLine().toCharArray();

        // 후입선출의 자료구조 Stack 선언
        Stack<Double> stack = new Stack<>();

        // 키와 값으로 구성된 Map선언
        Map<Character, Double> map = new HashMap<>();

        // N의 개수만큼 피연산자에 대응되는 값을 설정
        char key = 'A';
        for (int i = 0; i < n; i++) {
            map.put(key, Double.parseDouble(br.readLine()));
            key++;
        }

        for (int i = 0; i < array.length; i++) {
            // 인덱스의 값이 a-z인경우
            if ('A' <= array[i] && array[i] <= 'Z') {
                stack.push(map.get(array[i]));
            } else {
                double answer1 = stack.pop();
                double answer2 = stack.pop();

                switch (array[i]) {
                    case '+':
                        stack.push(answer2 + answer1);
                        break;
                    case '-':
                        stack.push(answer2 - answer1);
                        break;
                    case '*':
                        stack.push(answer2 * answer1);
                        break;
                    case '/':
                        stack.push(answer2 / answer1);
                        break;
                }
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));


    }
}
