package 코딩테스트고득점키트.해시;


import java.util.*;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        // 119 11955~ 97674
        // 123 456 789
        // 12 123 1235 567 88
        // 말그대로 문자순 1이 9보다 앞이므로 앞에 오되 문자열의 길이는 상관없다

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
