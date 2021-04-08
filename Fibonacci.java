package com.company;

import java.util.ArrayList;

public class Fibonacci {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer>list=new ArrayList<>();
        list.add(0);
        list.add(1);
        while(list.size()-1!=n){
            int idx=list.size();
            answer=(list.get(idx-1)+list.get(idx-2))%1234567;
            list.add(answer);
        }
        return answer;
    }
}
