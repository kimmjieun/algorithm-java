package 레벨1;


class 신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";

        answer = new_id.toLowerCase();

        answer = answer.replaceAll("[^-_.a-z0-9]",""); // 2단계

        answer = answer.replaceAll("[.]{2,}","."); //3단계

        answer = answer.replaceAll("^[.]|[.]$",""); // 4단계


        if(answer.equals("")){
            answer+="a";
        }
        if(answer.length()>=16){
            answer = answer.substring(0,15);
            answer = answer.replaceAll("[.]$","");
        }
        if(answer.length()<=2){
            while(answer.length()<3){
                answer+=answer.charAt(answer.length()-1);
            }
        }

        return answer;
    }
}