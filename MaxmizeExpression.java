package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxmizeExpression {
    public long solution(String expression) {
        long answer = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(j==i)continue;
                for(int k=0;k<3;k++){
                    if(k==i||k==j)continue;
                    answer=Math.max(answer,Caluculate(i,j,k,expression));
                }
            }
        }
        return answer;
    }
    private long Caluculate(int comb,int plus,int minus,String expression){
        Map<Integer,Character> priorityMap=new HashMap<>();
        priorityMap.put(comb,'*');priorityMap.put(plus,'+');priorityMap.put(minus,'-');
        String[] NumSplit=expression.split("[-*+]");
        char[] op=expression.replaceAll("[0-9]","").toCharArray();
        ArrayList<String> Numlist=new ArrayList<>();
        ArrayList<Character> OpList=new ArrayList<>();
        for(String s:NumSplit)
            Numlist.add(s);
        for(char c:op)
            OpList.add(c);

        for(int i=2;i>=0;i--){
            for(int j=0;j<OpList.size();j++){
                if(priorityMap.get(i)==OpList.get(j)){
                    long fnum=Long.parseLong(Numlist.remove(j));
                    long snum=Long.parseLong(Numlist.remove(j));
                    char ope=OpList.remove(j);

                    if(ope=='+')
                        Numlist.add(j,Long.toString(fnum+snum));
                    else if(ope=='-')
                        Numlist.add(j,Long.toString(fnum-snum));
                    else if(ope=='*')
                        Numlist.add(j,Long.toString(fnum*snum));
                    j--;
                }
            }
        }
        return Math.abs(Long.parseLong(Numlist.get(0)));
    }
}
