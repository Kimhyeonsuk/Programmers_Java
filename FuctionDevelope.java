package com.company;

import java.util.*;
class Pair implements Comparable<Pair>{
    Integer Key;
    Integer Value;

    public Pair(Integer Key,Integer Value){
        this.Key=Key;
        this.Value=Value;
    }
    public Integer getKey() {
        return Key;
    }
    public Integer getValue(){
        return Value;
    }

    @Override
    public int compareTo(Pair target) {
        if(this.Key==target.getKey()){
            return this.Value<=target.getValue()?1:-1;
        }
        else
            return this.Key<=target.getKey()? 1: -1;
    }
}
public class FuctionDevelope {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Vector<Integer>ans=new Vector<>();
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            queue.offer(new Pair(i,progresses[i]));
        }

        while(!queue.isEmpty()){
            int cnt=1;
            int left=100-queue.peek().getValue();
            int day=0;
            if(left%speeds[queue.peek().getKey()]!=0){
                day=left/speeds[queue.peek().getKey()]+1;
            }
            else{
                day=left/speeds[queue.peek().getKey()];
            }
            queue.poll();
            while(!queue.isEmpty()&&day*speeds[queue.peek().getKey()]>=100-queue.peek().getValue()){
                cnt++;
                queue.poll();
            }
            ans.add(cnt);
        }
        answer=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
}
