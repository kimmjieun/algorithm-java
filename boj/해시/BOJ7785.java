package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (!set.contains(a) && b.equals("enter")) {
                set.add(a);
            } else if (set.contains(a) && b.equals("leave")) {
                set.remove(a);
            }
        }

//        // 해시를 리스트로 바꾸는것 ?
//        ArrayList<String> list = new ArrayList<>();
//        Iterator iter = set.iterator();
//        while(iter.hasNext()){
//            list.add((String) iter.next());
//        }

        ArrayList<String> list = new ArrayList<>(set); // 여기 넣어주면 된다
        Collections.sort(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

    }
}
