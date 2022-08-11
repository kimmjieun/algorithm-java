package 레벨1.수학;

import java.util.*;

public class 삼진법뒤집기 {

    public int solution(int n) {
        int answer = 0;

        String s = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder();
        //   System.out.println(s);
        String news = sb.append(s).reverse().toString();
        // System.out.println(news);
        answer = Integer.parseInt(news, 3);
        //  System.out.println(answer);
        return answer;

    }
}
