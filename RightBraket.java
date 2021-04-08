package com.company;
import java.util.*;
public class RightBraket {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st=new Stack<>();

        int size=s.length();
        for(int i=0;i<size;i++){
            if(s.charAt(i)=='(')
                st.push('(');
            else
            {
                if(st.empty()){
                    answer=false;
                    break;
                }
                else
                    st.pop();
            }
        }

        if(!st.empty())
            answer=false;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        return answer;
    }
}
