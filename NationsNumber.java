package com.company;
import java.util.*;
public class NationsNumber {
    public String solution(int n) {
        String answer = "";
        StringBuffer sb=new StringBuffer();
        char[] arr={'1','2','4'};
        while(n!=0){
            sb.insert(0,arr[(n-1)%3]);
            n=(n-1)/3;
        }
        answer=sb.toString();
        return answer;
    }
}
