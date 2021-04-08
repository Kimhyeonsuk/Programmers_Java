package com.company;

import java.util.*;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<priorities.length;i++){
            pq.add(priorities[i]);
        }
        while(!pq.isEmpty()){
            for(int i=0;i<priorities.length;i++){
                if(pq.peek()==priorities[i]){
                    pq.poll();
                    answer++;
                    if(i==location){
                        pq.clear();
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
