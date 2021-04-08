package com.company;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.*;

public class RankSearch {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String,List<Integer>> infos=new HashMap<>();
        for(String s: info){
            String[] sArr=s.split(" ");
            int score=Integer.parseInt(sArr[4]);
            for(int i=0;i<(1<<4);i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<4;j++){
                    if((i&(1<<j))>0){
                        sb.append(sArr[j]);
                    }
                }
                infos.computeIfAbsent(sb.toString(), c -> new ArrayList<>()).add(score);
            }
        }

        int idx=0;
        for(String s: infos.keySet()){
            Collections.sort(infos.get(s));
        }

        for(String s:  query){
            String[] split=s.replaceAll("-","").split(" and | ");
            String key=String.join("",split[0],split[1],split[2],split[3]);
            int score=Integer.parseInt(split[4]);

            if(infos.containsKey(key)){
                List<Integer>list=infos.get(key);
                int low=0,high=list.size()-1;

                while(low<=high){
                    int mid=(low+high)/2;

                    if(list.get(mid)>=score){
                        high=mid-1;
                    }
                    else{
                        low=mid+1;
                    }
                }
                answer[idx++]=list.size()-low;
            }
            else{
                answer[idx++]=0;
            }
        }
        return answer;
    }
}
