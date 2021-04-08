package com.company;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sqrtYellow= (int)Math.sqrt(yellow);
        for(int i=1;i<=sqrtYellow;i++){
            if(yellow%i==0){
                int h=i;
                int c=yellow/i;
                if(4+i*2+c*2==brown){
                    answer[0]=c+2;
                    answer[1]=h+2;
                    break;
                }
            }
        }
        return answer;
    }
}
