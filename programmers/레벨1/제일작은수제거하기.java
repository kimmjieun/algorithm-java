package 레벨1;

public class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        else {
            int[] answer = new int[arr.length - 1];
            int min = arr[0];

            for (int i = 0; i < arr.length; i++) {
                min = Math.min(arr[i], min);
            }

            //반복문 index 용
            int index = 0;

            //가장 작은 수를 제외한 배열 만들기
            for (int i = 0; i < arr.length; i++) {
                //배열의 값이 가장 작은 수라면
                if (arr[i] == min) {
                    //continue를 이용해 배열에 넣지 않고 넘어간다.
                    continue;
                }
                answer[index++] = arr[i];
            }
            return answer;
        }
    }
}
