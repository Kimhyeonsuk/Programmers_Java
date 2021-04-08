package com.company;
import java.util.*;
public class OpenChattingRoom {
    public String[] solution(String[] record) {
        Map<String,String>map=new HashMap<>();//uid,name
        int answernum=0;
        for(int i=0;i<record.length;i++)
        {
            String [] split=record[i].split(" ");
            if(split[0].equals("Enter")||split[0].equals("Leave"))
                answernum++;
            if(split[0].equals("Change")||split[0].equals("Enter")){
                map.put(split[1],split[2]);
            }
        }

        String[] answer=new String[answernum];
        int cnt=0;
        for(int i=0;i<record.length;i++)
        {
            String [] split=record[i].split(" ");
            if(split[0].equals("Enter")){
                answer[cnt++]=map.get(split[1])+"님이 들어왔습니다.";
           }
            else if(split[0].equals("Leave")){
                answer[cnt++]=map.get(split[1])+"님이 나갔습니다.";
            }
        }
        return answer;
    }
}
