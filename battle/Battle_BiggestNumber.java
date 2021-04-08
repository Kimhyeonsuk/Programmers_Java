package com.company.battle;

import javax.swing.text.html.HTMLEditorKit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Battle_BiggestNumber {

    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Integer>list=new ArrayList<>();
        for(int a: numbers){
            list.add(a);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=String.valueOf(o1);
                String s2=String.valueOf(o2);
                return (s2+s1).compareTo(s1+s2);
            }
        });

        Iterator iterator=list.iterator();
        if(list.get(0)==0)
            answer+="0";
        else{
            for(int i=0;i<list.size();i++){
                answer+=list.get(i);
            }
        }
        return answer;
    }
}
