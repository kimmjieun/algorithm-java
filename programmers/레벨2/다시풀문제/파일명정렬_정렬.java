package 레벨2.다시풀문제;


import java.util.*;

class 파일명정렬_정렬 {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                if (result == 0) // 같은 문자일 경우 숫자로 비교
                    result = convertNum(o1, head1) - convertNum(o2, head2);
                return result;
            }

        });

        return files;
    }

    public int convertNum(String str, String head) {
        str = str.substring(head.length());// head길이만큼 잘라서 숫자부터 시작하게 만들기
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) && result.length() < 5) {
                result += c;
            } else
                break;
        }
        return Integer.valueOf(result);
    }
}