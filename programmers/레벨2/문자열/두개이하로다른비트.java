package 레벨2.문자열;


class 두개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int i = 0;
        for (long num : numbers) {
            String bit = Long.toString(num, 2);
            String result = "";
            if (num % 2 == 0) {
                // 짝수인 경우
                answer[i++] = num + 1;
            } else {
                // 홀수인 경우
                if (bit.contains("0")) {
                    // 마지막 0 찾기
                    int idx = bit.lastIndexOf("0");
                    // 마지막 0을 1로 바꾸고 뒤에 1을 0으로 바꾸기

                    result = bit.substring(0, idx) + "10" + bit.substring(idx + 2);
                } else {
                    result = bit.substring(0, 1) + "0" + bit.substring(1);
                }
                answer[i++] = Long.parseLong(result, 2);
            }

        }

        return answer;
    }
}