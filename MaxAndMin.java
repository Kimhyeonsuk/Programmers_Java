package com.company;

public class MaxAndMin {
    public String solution(String s) {
        String answer = "";
        String[] split=s.split(" ");
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(String a:split){
            int num=Integer.parseInt(a);
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        answer+=min+" "+max;
        return answer;
    }
}
