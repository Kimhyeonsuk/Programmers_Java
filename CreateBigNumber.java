package com.company;
import java.util.*;
public class CreateBigNumber {
    public String solution(String number, int k) {
        StringBuilder answer=new StringBuilder();
        char [] sArr=number.toCharArray();
        int ansLen=number.length()-k;//뽑아야할 수
        int idx=0;
        for(int i=0;i<number.length()-k;i++){
            char max='0';
            for(int j=idx;j<=i+k;j++){
                if(max<number.charAt(j)){
                    max=number.charAt(j);
                    idx=j;
                }
            }
            answer.append(number.charAt(idx));
            idx=idx+1;
        }

        return answer.toString();
    }
}
