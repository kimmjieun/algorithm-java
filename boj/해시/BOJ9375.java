package 해시;

import java.util.*;
import java.io.*;

public class BOJ9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, ArrayList<String>> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");

                if (!map.containsKey(str[1])) {
                    map.put(str[1], new ArrayList<>());
                }

                map.get(str[1]).add(str[0]);
            }

            int sum = 1;
            for (String key : map.keySet()) {
                sum *= (map.get(key).size() + 1);
            }
            System.out.println(sum - 1);
        }
    }


        // 쉽게 푸는 법
//        public static void main(String[] args) throws IOException {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int t = Integer.parseInt(br.readLine());
//
//            while (t-- > 0) {
//                int n = Integer.parseInt(br.readLine());
//                HashMap<String, Integer> map = new HashMap<>();
//
//                for (int i = 0; i < n; i++) {
//                    String[] str = br.readLine().split(" ");
//                    map.put(str[1], map.getOrDefault(str[1], 0) + 1);
//
//                }
//
//                int sum = 1;
//                for (String key : map.keySet()) {
//                    sum *= (map.get(key) + 1);
//                }
//                System.out.println(sum - 1);
//            }
//        }



}
