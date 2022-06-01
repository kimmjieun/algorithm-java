package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ4659 {
    static ArrayList<Character> mo = new ArrayList<>(Arrays.asList('a','e','i','o','u'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;
            boolean flag = testPassword(s);

            if (!flag) {
                System.out.println("<" + s + ">" + " is not acceptable.");
            } else {
                System.out.println("<" + s + ">" + " is acceptable.");
            }
        }
    }

    static boolean testPassword(String s) {

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (mo.contains(s.charAt(i))) {
                cnt++;
            }
        }
//        System.out.println(cnt);
        if (cnt == 0) {
//            System.out.println("0");
            return false;
        }

        for (int i = 0; i < s.length() - 2; i++) {
            if (mo.contains(s.charAt(i)) &&
                    mo.contains(s.charAt(i + 1)) &&
                    mo.contains(s.charAt(i + 2))) {
//                System.out.println("1");
                return false;
            }
            if (!mo.contains(s.charAt(i)) &&
                    !mo.contains(s.charAt(i + 1)) &&
                    !mo.contains(s.charAt(i + 2))) {
//                System.out.println("2");
                return false;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            String s1 = s.charAt(i) + "";
            String s2 = s.charAt(i + 1) + "";
            if (s1.equals(s2)) {
                if (!(s1 + s2).equals("ee") && !(s1 + s2).equals("oo")) {
//                    System.out.println("3");
                    return false;

                }
            }
        }


        return true;
    }
}
