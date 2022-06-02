package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1032 {
    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        String[] cmd = new String[n];
//        for (int i = 0; i < n; i++) {
//            cmd[i] = br.readLine();
//        }
//        int len = cmd[0].length();
//        boolean[] arr = new boolean[len];
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i; j < n; j++) {
//                for (int k = 0; k < len; k++) {
//                    if (cmd[i].charAt(k) != cmd[j].charAt(k)) {
//                        arr[k] = true;
//                    }
//                }
//            }
//        }
//
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i]) result.append("?");
//            else result.append(cmd[0].charAt(i));
//        }
//        System.out.println(result);
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] pattern = br.readLine().toCharArray();
        for(int i=0;i<n-1;i++){
            char[] filename = br.readLine().toCharArray();
            for(int j=0;j<pattern.length;j++){
                if(pattern[j]!=filename[j]){
                    pattern[j]='?';
                }
            }
        }
        System.out.println(pattern);

    }
}
