package com.company.battle2;

import java.util.ArrayList;
import java.util.*;
public class battle2_NewsClustering {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String,Integer>Amap=new HashMap<>();
        Map<String,Integer>Bmap=new HashMap<>();
        int intersection=0;
        int union=0;


        for(int i=0;i<str1.length()-1;i++){
            String tmp=str1.substring(i,i+2);
            tmp=tmp.replaceAll("[^A-Za-z]","");
            tmp=tmp.toUpperCase();
            if(tmp.length()==2){
                Amap.put(tmp,Amap.getOrDefault(tmp,0)+1);
            }

        }
        for(int j=0;j<str2.length()-1;j++){
            String tmp=str2.substring(j,j+2);
            tmp=tmp.replaceAll("[^a-zA-Z]","");
            tmp=tmp.toUpperCase();
            if(tmp.length()==2){
                Bmap.put(tmp,Bmap.getOrDefault(tmp,0)+1);
            }
        }


        //intersection 구하기
        for(String s:Amap.keySet()){
            if(Bmap.containsKey(s)){
                intersection+=Math.min(Amap.get(s),Bmap.get(s));
                union+=Math.max(Amap.get(s),Bmap.get(s));
            }
            else{
                union+=Amap.get(s);
            }
        }

        //union 구하기
        for(String s:Bmap.keySet()){
            if(!Amap.containsKey(s)){
                union+=Bmap.get(s);
            }
        }
        if(union==0)
            answer=1*65536;
        else{
            double a=(double)intersection/(double)union;
            a=a*65536;
            answer=(int)a;
        }
        return answer;
    }
}
