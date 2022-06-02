package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20944 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        String s= "";
//        for(int i=0;i<n;i++){
//            s+='a'; // 이게 시간초과 원인일 듯
//        }
//        System.out.println(s);
//    } // 시간초과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println("a".repeat(n));
    } // 맞음 자바 11이상만 가능
}
