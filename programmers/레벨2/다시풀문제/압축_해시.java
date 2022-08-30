package 레벨2.다시풀문제;


import java.util.*;

class 압축_해시 {
    public int[] solution(String msg) {
        ArrayList<Integer> array = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        // a-z까지 초기화시킴
        char ch = 'A';
        for (int i = 1; i < 27; i++) {
            map.put(ch + "", i);
            ch += 1;
        }
        int startin = 27;

        // 문자열의 끝인지를 확인하기 위한 boolean
        boolean flag = false;
        for (int i = 0; i < msg.length(); i++) {
            String word = msg.charAt(i) + "";
            while (map.containsKey(word)) {
                i++;
                if (i == msg.length()) {
                    flag = true;
                    break;
                }
                word += msg.charAt(i);
            }
            if (flag) {
                array.add(map.get(word));
                break;
            }
            //현재 word에 지금 사전에 넣을 단어 이므로 뒤에서 문자하나 제거해야 사전에 있는 단어
            array.add(map.get(word.substring(0, word.length() - 1)));
            // 사전에는 현재순서보다 +1된 값 더한다
            map.put(word, startin++);
            // 현재 i는 단어를 만들면서 다음을 가리키기 때문에 -1해줘야함
            i--;
        }

        int[] answer = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            answer[i] = array.get(i);
        }
        return answer;
    }

}
