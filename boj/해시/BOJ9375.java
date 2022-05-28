package 해시;

import java.lang.reflect.Array;
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
                String[] s = br.readLine().split(" ");

                if (!map.containsKey(s[1])) {
//                    ArrayList<String> list = new ArrayList<>();
//                    list.add(s[0]);
//                    map.put(s[1], list);
//
                    map.put(s[1], new ArrayList<>());
                    map.get(s[1]).add(s[0]);
                } else {
//                    ArrayList<String> arr = map.get(s[1]);
//                    arr.add(s[0]);
//                    map.put(s[1], arr);
                    map.get(s[1]).add(s[0]);
                }
            }
            int sum = 1;
            for (String key : map.keySet()) {
//                ArrayList<String> result = map.get(key);
                sum *= (map.get(key).size() + 1);
//                System.out.println(key+": ");
//                for(String l : result){
//                    System.out.print(l+" ");
//                }
//                System.out.println();
            }
            System.out.println(sum - 1);

        }

    }

}
