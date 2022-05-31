package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String team = br.readLine();
            map.put(team, new ArrayList<>());
            int t = Integer.parseInt(br.readLine());
            for (int j = 0; j < t; j++) {
                map.get(team).add(br.readLine());
            }

        }

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 0) {
                ArrayList<String> members = map.get(question);
                Collections.sort(members);
                for (String val : members) {
                    System.out.println(val);
                }
            } else {
                for (String key : map.keySet()) {
                    if (map.get(key).contains(question)) {
                        System.out.println(key);
                        break;
                    }
                }
            }
        }
    }
}
