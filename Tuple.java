package com.company;

import javax.swing.text.html.HTMLEditorKit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tuple {
    public int[] solution(String s) {

        //s=s.substring(2,s.length()-2).replaceAll("},{","-");
        String[] split=s.split("-");
        Map<Integer, List<Integer>> map=new HashMap<>();

        ArrayList<Integer> list=new ArrayList<>();
        for(String atom: split){
            if(atom.substring(0,1).equals("{")&&atom.substring(atom.length()-1).equals("}")){//원소가 하나인 경우
                int num= Integer.parseInt(atom.replaceAll("^[{]|[}]$",""));
                map.computeIfAbsent(1,d->new ArrayList<>()).add(num);
            }
            else if(atom.substring(0,1).equals("{")){//원소 시작
                int num=Integer.parseInt(atom.replaceAll("\\{",""));
                list.add(num);
            }
            else if(atom.substring(atom.length()-1).equals("}")){//원소 끝
                int num=Integer.parseInt(atom.replaceAll("}",""));
                list.add(num);
                int listNum=list.size();
                for(int i=0;i<listNum;i++){
                    map.computeIfAbsent(listNum,d->new ArrayList<>()).add(list.get(i));
                }
                list.clear();
            }
            else{
                list.add(Integer.parseInt(atom));
            }

        }
        int[] answer = new int[map.size()];
        ArrayList<Integer> newList=new ArrayList<>();
        newList.add(map.get(1).get(0));
        for(int i=2;i<=map.size();i++){
            for(int j=0;j< newList.size();j++){
                //map.gdfekjio
            }
        }
        answer[0]=map.get(1).get(0);
        return answer;
    }
}
