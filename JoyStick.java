package com.company;
import java.util.*;
public class JoyStick {
    public int solution(String name) {
        int answer = 0;
        boolean [] chk=new boolean[name.length()];
        int nameLen=name.length();
        int minMove=nameLen-1;
        for(int i=0;i<nameLen;i++){
            if(name.charAt(i)>='N'){
                answer+='Z'-name.charAt(i)+1;
            }
            else{
                answer+=name.charAt(i)-'A';
            }

            int next=i+1;
            while(next<nameLen&&name.charAt(next)=='A')
                next++;

            answer+=Math.min(minMove,i+i+nameLen-next);
        }
        return answer;
    }
}
