package 코딩테스트고득점키트.스택큐;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();
        int[] works = new int[progresses.length];


        for (int i = 0; i < speeds.length; i++) {
            works[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                works[i] += 1;
            }
        }

        int x = works[0];
        int count = 1;
        for (int i = 1; i < progresses.length; i++) {

            if (x >= works[i]) {
                count += 1;
            } else {
                list.add(count);
                count = 1;
                x = works[i];
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    // 큐를 사용하는 방법
    public int[] solution2(int[] progresses, int[] speeds) {

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            if((100-progresses[i])%speeds[i]==0){
                q.add((100-progresses[i])/speeds[i]);
            }else{
                q.add((100-progresses[i])/speeds[i]+1);
            }
        }

        int x = q.poll();
        int count =1;
        while(!q.isEmpty()){
            if(x>=q.peek()){
                count++;
                q.poll();
            }else{
                list.add(count);
                count=1;
                x=q.poll();
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] =list.get(i);
        }


        return answer;
    }
}
