package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ9933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();

            if (isPalindrome(s) || set.contains(s)) {
                System.out.println(s.length() + " " + s.charAt(s.length() / 2));
                break;
            }
            set.add(sb.append(s).reverse().toString());

        }
    }
    static boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder();
        if (s.substring(0, s.length() / 2).equals(sb.append(s.substring(s.length() / 2 + 1)).reverse().toString()))
            return true;
        else
            return false;
    }

}
