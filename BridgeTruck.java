package com.company;
import java.util.*;
public class BridgeTruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Pair> q=new LinkedList<>();
        int total_weight=0;
        int sec=2;
        int idx=1;
        q.add(new Pair(truck_weights[0],1));
        total_weight=truck_weights[0];
        while(true)
        {
            while(!q.isEmpty()&&sec-q.peek().getValue()>=bridge_length){
                total_weight-=q.peek().getKey();
                q.poll();
            }
            if(idx==truck_weights.length&&q.isEmpty())
                break;

            if(idx<truck_weights.length&&total_weight+truck_weights[idx]<=weight){
                q.add(new Pair(truck_weights[idx],sec));
                total_weight+=truck_weights[idx++];
            }
            sec++;
        }
        return sec;
    }
}
