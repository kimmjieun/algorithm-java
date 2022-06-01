package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();
            sb.append(checkPalindrome(s, 0, 0, s.length() - 1)).append("\n");
        }
        System.out.println(sb);
    }

    static int checkPalindrome(String s, int result, int start, int end) {
        if (result == 2) {
            return 2;

        }
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                result = Math.min(
                        checkPalindrome(s, result + 1, start + 1, end),
                        checkPalindrome(s, result + 1, start, end - 1));
                break;

            }
        }
        return result;
    }

    // 시간초과
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        while (n-- > 0) {
//            boolean flag = false;
//            String str = br.readLine();
//            int len = str.length();
//            if (isPalindrome(str)) {
//                System.out.println(0);
//            } else {
//                String newStr = "";
//                for (int i = 0; i < len; i++) {
//                    if (i == 0) {
//                        newStr = str.substring(1);
//                    } else if (i == len - 1) {
//                        newStr = str.substring(0, i);
//                    } else {
//                        newStr = str.substring(0, i) + str.substring(i + 1);
//                    }
////                    System.out.println(newStr);
//                    if (isPalindrome(newStr)) {
//                        flag = true;
//                        break;
//                    }
//                }
//                if (flag) System.out.println(1);
//                else System.out.println(2);
//            }
//        }
//    }
//
//    static boolean isPalindrome(String str) {
//        for (int i = 0; i < str.length() / 2; i++) {
//            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
