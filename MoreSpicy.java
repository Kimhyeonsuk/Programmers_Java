package com.company;
import java.util.*;
public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int a :scoville){
            pq.add(a);
        }

        int cnt=0;
        while(pq.peek()<K){
            if(pq.size()==1)
                break;
            int smallest=pq.poll();
            int next_smallest=pq.poll();
            int tmp=smallest+next_smallest*2;
            pq.add(tmp);
            cnt++;

        }

        if(pq.size()==1&&pq.peek()<K)
            answer=1;
        else
            answer=cnt;
        return answer;
    }
}
