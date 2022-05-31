package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ22252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();
        long sum = 0;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            if (type == 1) {
                while (count-- > 0) {
                    if (!map.containsKey(name)) {
                        map.put(name, new PriorityQueue<>(Collections.reverseOrder()));
                    }
                    map.get(name).add(Integer.parseInt(st.nextToken()));
                }
            } else {
                if (map.get(name) == null) continue;
                while (!map.get(name).isEmpty() && count-- > 0) {
                    sum += map.get(name).poll();
                }
            }
        }
        System.out.println(sum);
    }

}
