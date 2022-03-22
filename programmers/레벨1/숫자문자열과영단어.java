package 레벨1;

public class 숫자문자열과영단어 {

    public static int solution(String s) {

        if(s.contains("zero")){
            s = s.replace("zero","0");
        }
        if(s.contains("one")){
            s = s.replace("one","1");
        }
        if(s.contains("two")){
            s = s.replace("two","2");
        }
        if(s.contains("three")){
            s = s.replace("three","3");
        }
        if(s.contains("four")){
            s = s.replace("four","4");
        }
        if(s.contains("five")){
            s = s.replace("five","5");
        }
        if(s.contains("six")){
            s = s.replace("six","6");
        }
        if(s.contains("seven")){
            s = s.replace("seven","7");
        }
        if(s.contains("eight")){
            s = s.replace("eight","8");
        }
        if(s.contains("nine")){
            s = s.replace("nine","9");
        }


        int answer = 0;
        answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
    }

}
