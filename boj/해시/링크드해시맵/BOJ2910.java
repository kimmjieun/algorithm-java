package 해시.링크드해시맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2910 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);

        str = br.readLine().split(" ");
        HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

        for (int i = 0; i < str.length; i++) {
            map.put(Integer.parseInt(str[i]), map.getOrDefault(Integer.parseInt(str[i]), 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < map.get(list.get(i)); j++) {
                System.out.print(list.get(i) + " ");
            }

        }
    }

}
