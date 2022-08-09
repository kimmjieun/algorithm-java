package 레벨1;
import java.util.*;
public class 같은숫자는싫어 {
    public int[] solution(int []arr) {

        ArrayList<Integer> list = new ArrayList<>();

        int tmp = arr[0];
        list.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(tmp==arr[i]){
                continue;
            }
            list.add(arr[i]);
            tmp = arr[i];
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
    public int[] solution2(int []arr) {

        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            //System.out.println(s.peek()+" "+arr[i]);
            if(s.peek()!=arr[i]){
                s.push(arr[i]);
            }
        }

        int[] answer = new int[s.size()];
        int i=s.size()-1;
        while(!s.isEmpty()){

            answer[i--] =s.pop();
        }

        return answer;
    }
}
