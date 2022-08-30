package 레벨2.다시풀문제;


class 방금그곡_문자열 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = convert(m);
        int max = 0;
        for (int i = 0; i < musicinfos.length; i++) {
            String[] str = musicinfos[i].split(",");
            String title = str[2];
            String music = convert(str[3]);
            String[] start = str[0].split(":");
            String[] end = str[1].split(":");
            int hour = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60;
            int minute = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
            int time = hour + minute;
            StringBuilder sb = new StringBuilder();// 재생시간동안 재생된 전체 멜로디
            for (int j = 0; j < time; j++) {
                sb.append(music.charAt(j % music.length()));
            }
            if (sb.toString().contains(m)) {
                if (max < sb.toString().length()) {
                    max = sb.toString().length();
                    answer = title;
                }
            }
        }

        return answer;
    }

    public String convert(String m) {
        m = m.replace("A#", "a");
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");
        return m;

    }
}
