package 레벨2.문자열;


import java.util.*;

class 방금그곡 {
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


    public String solution2(String m, String[] musicinfos) {
        String answer = "";
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        m = replaceCode(m);
        for (String music : musicinfos) {
            String[] mu = music.split(",");
            String[] start = mu[0].split(":");
            String[] end = mu[1].split(":");
            String title = mu[2];
            String code = replaceCode(mu[3]);
            int totalminute = (Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]))
                    - (Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]));

            String song = "";
            for (int i = 0; i < totalminute; i++) {
                song += code.charAt(i % code.length());
            }

            if (song.contains(m)) {
                map.put(title, totalminute);
            }

        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });


        if (list.size() == 0) answer = "(None)";
        else {
            for (Map.Entry<String, Integer> l : list) {
                answer = l.getKey();
                break;
            }
        }

        return answer;
    }


    public String replaceCode(String s) {
        s = s.replace("C#", "Z");
        s = s.replace("D#", "Y");
        s = s.replace("F#", "X");
        s = s.replace("G#", "M");
        s = s.replace("A#", "N");
        return s;
    }
}


