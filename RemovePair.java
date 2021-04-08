package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class RemovePair {
    public int solution(String s)
    {
        int answer = 0;
        char[] arr=s.toCharArray();
        Stack<Character>st=new Stack<>();
        for(char c:arr){
            if(st.empty())
                st.push(c);
            else{
                if(st.peek()==c)
                {
                    st.pop();
                }
                else
                    st.push(c);
            }

        }
        if(st.empty())
            answer=1;
        else
            answer=0;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
