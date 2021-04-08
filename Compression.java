package com.company;

import java.lang.reflect.Array;
import java.util.*;
public class Compression {
    public int[] solution(String msg) {
        int[] answer = {};
        Map<String,Integer>dic=new HashMap<>();
        ArrayList<Character>alpList=new ArrayList<>();
        ArrayList<Character>msgList=new ArrayList<>();
        char[] sarr=msg.toCharArray();
        for(char c: sarr)
            msgList.add(c);

        for(int i='A';i<='Z';i++){
            char val=(char)i;
            dic.put(Character.toString(val),val-'A'+1);
        }
        ArrayList<Integer>res=new ArrayList<>();
        while(!msgList.isEmpty()){
            int idx=0;
             String w=""+msgList.get(idx++);
             while(dic.containsKey(w)&&msgList.size()!=idx){
                 w+=msgList.get(idx++);
             }

             if(dic.containsKey(w)){
                 res.add(dic.get(w));
                 for(int i=0;i<w.length();i++)
                     msgList.remove(0);
             }
             else{
                 w=w.substring(0,w.length()-1);
                 res.add(dic.get(w));
                 for(int i=0;i<w.length();i++)
                     msgList.remove(0);
                 String newString=w+msgList.get(0);
                 dic.put(newString,dic.size()+1);
             }
        }
        answer=new int[res.size()];
        for(int i=0;i<res.size();i++){
            answer[i]=res.get(i);
        }
        return answer;
    }
}
