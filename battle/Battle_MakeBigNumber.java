package com.company.battle;

import java.util.Stack;

public class Battle_MakeBigNumber {
    public String solution(String number, int k) {
        String answer = "";
        int startIdx=0;
        int len=number.length();

        Stack<Character> st=new Stack<>();
        for(int i=0;i<len;i++){
            while(!st.empty()&&st.peek()<number.charAt(i)&&k>0)
            {
                st.pop();
                --k;
            }
            st.add(number.charAt(i));

        }
        while(k>0){
            st.pop();
            k--;
        }
        for(int i=0;i<st.size();i++){
            answer+=st.get(i);
        }
        return answer;
    }
}
