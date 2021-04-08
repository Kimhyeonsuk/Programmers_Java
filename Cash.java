package com.company;

import java.util.PriorityQueue;
import java.util.*;
public class Cash {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String>list=new ArrayList<>();
        Set<String>set=new HashSet<>();
        if(cacheSize==0)
            return  cities.length*5;
        for(int i=0;i<cities.length;i++){
            cities[i]=cities[i].toUpperCase();
            if(set.contains(cities[i])){
                answer++;
                for(int j=0;j<list.size();j++){
                    if(list.get(j).equals(cities[i])){
                        list.remove(j);
                        list.add(cities[i]);
                        break;
                    }
                }
            }
            else{
                answer+=5;
                if(list.size()==cacheSize){
                    set.remove(list.get(0));
                    list.remove(0);
                    set.add(cities[i]);
                    list.add(cities[i]);
                }
                else{
                    list.add(cities[i]);
                    set.add(cities[i]);
                }

            }
        }
        return answer;

    }
}
