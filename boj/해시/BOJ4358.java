package 해시;

import java.util.*;
import java.io.*;


public class BOJ4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int total = 0;
        Map<String, Integer> map = new TreeMap<>();
        while ((s = br.readLine()) != null) {
            total++;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key + " " + String.format("%.4f", (map.get(key) * 100.0) / total));
            sb.append("\n");
        }
//        StringBuilder sb = new StringBuilder();
//        for (String tree : list) {
//            int count = map.get(tree) * 100;
//            sb.append(tree + " " + String.format("%.4f", (double)count / (double)total) + "\n");
//        }
        System.out.print(sb);
    }
}
