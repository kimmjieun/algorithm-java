package 해시.해시셋;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String[] A = br.readLine().split(" ");

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        while (b-- > 0) {
            set.add(Integer.parseInt(st.nextToken()));
        }


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            if (!set.contains(Integer.parseInt(A[i]))) {
                list.add(Integer.parseInt(A[i]));
            }
        }

        Collections.sort(list);

        if (list.size() == 0)
            System.out.println(0);
        else {
            System.out.println(list.size());
            for (int l : list) {
                System.out.print(l + " ");
            }
        }


    }
}
