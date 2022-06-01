package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine().split("\\.")[1];
            map.put(s, map.getOrDefault(s, 0) + 1); // 트리맵에서 안되나
        }

        // 키정렬
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

    }
}
