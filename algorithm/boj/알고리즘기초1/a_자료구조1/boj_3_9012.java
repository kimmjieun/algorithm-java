package boj.알고리즘기초1.a_자료구조1;

import java.io.*;
import java.util.Stack;

// 9012번 괄호
public class boj_3_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        while (n-- > 0) {
            Stack<Character> stack = new Stack<>();
            String answer = "YES";
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push('(');
                } else if (s.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        answer = "NO";
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) {
                answer = "NO";
            }

            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int t = Integer.parseInt(br.readLine());
//
//        while(t-- > 0) {
//            Stack<String> stack = new Stack<>();
//            String answer = "YES";
//            String[] n = br.readLine().split("");
//
//            for (int i = 0; i < n.length; i++) {
//                if(n[i].equals("(")) stack.push("(");
//                else if(n[i].equals(")")) {
//                    if(stack.isEmpty()) answer = "NO";
//                    else stack.pop();
//                }
//            }
//            if(!stack.isEmpty()) {
//                answer = "NO";
//            }
//            bw.write(answer + "\n");
//        }
//        bw.flush();
//        bw.close();
//    }
//}
