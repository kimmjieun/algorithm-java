package 레벨1.어려운문제;
// 문자열쪼개기+구현
public class 다트게임 {
    public int solution(String dartResult) {
        int answer = 0;
        String temp = ""; // 문자열 내 1번의 점수 저장 변수
        int[] arr = new int[3];// 3번의 점수를 저장할 배열
        int idx = 0;// 배열 참조위한 Idx

        for (int i = 0; i < dartResult.length(); i++) {
            switch (dartResult.charAt(i)) {
                case '*':
                    arr[idx - 1] *= 2;
                    if (idx > 1) arr[idx - 2] *= 2;
                    break;
                case '#':
                    arr[idx - 1] *= -1;
                    break;
                case 'S':
                    arr[idx] = (int) Math.pow(Integer.parseInt(temp), 1);
                    idx++;
                    temp = "";
                    break;
                case 'D':
                    arr[idx] = (int) Math.pow(Integer.parseInt(temp), 2);
                    idx++;
                    temp = "";
                    break;
                case 'T':
                    arr[idx] = (int) Math.pow(Integer.parseInt(temp), 3);
                    idx++;
                    temp = "";
                    break;
                default:
                    temp += String.valueOf(dartResult.charAt(i));
                    break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        return answer;
    }
}
