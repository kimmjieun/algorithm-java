package 레벨2.문자열;


import java.util.*;

class 튜플 {
    public int[] solution(String s) {
        String[] str = s.split("},");

        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].replace("{", "");
            str[i] = str[i].replace("}", "");
        }

        System.out.println(Arrays.toString(str));
        // 길이로 정렬
        Arrays.sort(str, new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        System.out.println(Arrays.toString(str));

        ArrayList<String> list = new ArrayList<>();
        list.add(str[0]);

        for (int i = 1; i < str.length; i++) {
            String[] arr = str[i].split(",");
            for (int j = 0; j < arr.length; j++) {
                if (!list.contains(arr[j])) {
                    list.add(arr[j]);

                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        return answer;
    }
}
