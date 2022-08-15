package 레벨2.다시풀문제;

public class 문자열압축_문자열 {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) { // 압축 최대 s.length/2까지 가능
            int ziplevel = 1; // 압축카운트
            String zipstr = s.substring(0, i); // 압축할 문자
            StringBuilder sb = new StringBuilder(); // 압축된 문자열

            // i개 단위로 잘라가며 압축하기 위해 for문 사용
            for (int j = i; j <= s.length(); j += i) {
                // 다음 문자 추출
                String next = s.substring(j, j + i > s.length() ? s.length() : i + j);
                // 다음 문자와 현재 문자가 같으면 zipLevel 증가
                if (zipstr.equals(next)) ziplevel++;
                else {
                    // 압축 안됐을경우 공백, 압축됐을경우 ziplevel을 붙여줌 + 압축할 문자를 넣어줌
                    sb.append((ziplevel != 1 ? ziplevel : "") + zipstr);
                    zipstr = next;
                    ziplevel = 1;
                }
            }
            sb.append(zipstr); // 마지막에 추가안된 zipstr추가
            answer = Math.min(answer, sb.length()); //가장 작은 문자열길이 저장

        }


        return answer;
    }
}
