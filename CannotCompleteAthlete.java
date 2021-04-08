package com.company;
import java.util.*;
public class CannotCompleteAthlete {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> participantMap=new HashMap<>();
        for(int i=0;i<participant.length;i++){
            if(participantMap.containsKey(participant[i])){
                participantMap.put(participant[i], participantMap.get(participant[i])+1);
            }
            else{
                participantMap.put(participant[i],1);
            }
        }
        for(int i=0;i<completion.length;i++){
            participantMap.put(completion[i],participantMap.get(completion[i])-1);
        }

       Iterator<Map.Entry<String,Integer>> iterator=participantMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> entry=iterator.next();
            if(entry.getValue()!=0)
            {
                answer=entry.getKey();
                break;
            }
        }
        return answer;
    }
}
