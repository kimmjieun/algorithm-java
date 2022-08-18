package 레벨2.그리디;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        // 몸무게가 적게 나가는 사람 index
        int index = 0;
        for (int i = people.length - 1; i >= index; i--) {
            //System.out.println(i+" "+index);
            //최대 최소 합이 limit보다 크면 제일 무거운 사람 먼저 보냄
            if (people[i] + people[index] > limit) {
                answer++;
            } else {
                index++;
                answer++;
            }
        }


        return answer;
    }
}
