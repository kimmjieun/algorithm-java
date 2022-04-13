package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1926 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String tmp = String.valueOf(i);

            // 1안
            if (tmp.contains("3") || tmp.contains("6") || tmp.contains("9")) {
                for (int j = 0; j < tmp.length(); j++) {
                    if (tmp.charAt(j) == '3' || tmp.charAt(j) == '6' || tmp.charAt(j) == '9') {
                        System.out.print("-");
                    }
                }
                System.out.print(" ");
            } else {
                System.out.print(i + " ");
            }
//
//            // 2안
//            if (tmp.contains("3") || tmp.contains("6") || tmp.contains("9")) {
//                for (int j = 0; j < tmp.length(); j++) {
//                    tmp = tmp.replaceAll("[369]", "-");
//                }
//                tmp = tmp.replaceAll("[0124578]", "");
//            }
//            System.out.print(tmp + " ");
//
//            // 3안
//            if (tmp.contains("3") || tmp.contains("6") || tmp.contains("9")) {
//                tmp = tmp.replace("3", "-");
//                tmp = tmp.replace("6", "-");
//                tmp = tmp.replace("9", "-");
//
//                tmp = tmp.replace("0", "");
//                tmp = tmp.replace("1", "");
//                tmp = tmp.replace("2", "");
//                tmp = tmp.replace("4", "");
//                tmp = tmp.replace("5", "");
//                tmp = tmp.replace("7", "");
//                tmp = tmp.replace("8", "");
//
//            }
//            System.out.print(tmp + " ");
        }

    }
}

