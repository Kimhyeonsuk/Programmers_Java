package com.company;
import java.lang.reflect.Array;
import java.util.*;
public class MenuRenewal {
    Map<String,Integer> map;
    int m;
    public String[] solution(String[] orders, int[] course) {
        map=new HashMap<>();
        PriorityQueue<String>pq=new PriorityQueue<>();
        String[] answer = {};
        Arrays.sort(course);

        for(int menuNum:course){
            m=0;
            for(String orderList:orders){
                permutation(0,orderList,"",menuNum);
            }
            for(String a : map.keySet()){
                if(map.get(a)==m&&m!=1){
                    pq.offer(a);
                }
            }
            map.clear();
        }

        answer=new String[pq.size()];
        int k=0;
        while(!pq.isEmpty()){
            answer[k++]=pq.poll();
        }
        return answer;
    }

    private void permutation(int idx,String orderList,String str,int menuNum){
        if(str.length()==menuNum){
            char[] cArr= str.toCharArray();
            Arrays.sort(cArr);
            StringBuilder tmp=new StringBuilder();
            for(char a :cArr){
                tmp.append(a);
            }
            map.put(tmp.toString(), map.getOrDefault(tmp.toString(),0)+1);
            m=Math.max(m,map.get(tmp.toString()));
        }
        else{
            for(int i=idx;i<orderList.length();i++){
                String now=orderList.substring(i,i+1);
                permutation(i+1,orderList,str+now,menuNum);
            }
        }
    }
}
