package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Character, Integer> map = new TreeMap<>();
        while (n-- > 0) {
            Character s = br.readLine().charAt(0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        String result = "";
        for (Character key : map.keySet()) {
            if (map.get(key) >= 5) {
                result += key;
            }
        }
        if (result.equals("")) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(result);
        }


    }
}
