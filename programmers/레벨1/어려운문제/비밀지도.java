package 레벨1.어려운문제;
// format, 비트연산
public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%" + n + "s", Integer.toString(arr1[i] | arr2[i], 2));
            //System.out.println(answer[i]);
            answer[i] = answer[i].replace("1", "#");
            answer[i] = answer[i].replace("0", " ");
        }

        return answer;
    }
}
