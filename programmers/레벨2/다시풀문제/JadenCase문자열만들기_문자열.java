package 레벨2.다시풀문제;


class JadenCase문자열만들기_문자열 {
    public String solution(String s) {
        String answer = "";
        // 공백 여러개여야함

        String[] str = s.toLowerCase().split("");
        // 이전이 공백인지 체크
        boolean space =true;
        for(String ss:str){
            // space가 true면 대문자로, 아니면 그냥 그대로 사용
            answer+=space?ss.toUpperCase():ss;

            //공백이 오면 space를 true 아니면 false
            space = ss.equals(" ") ? true: false;
        }
        return answer;
    }
}