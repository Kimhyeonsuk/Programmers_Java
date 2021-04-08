package com.company.battle;

import java.util.Arrays;

public class Battle_SafeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int idx=0;
        for(int i=people.length-1;i>=idx;i--){
            int min=people[idx];
            int max=people[i];
            if(min+max>limit){
                answer++;
            }
            else
            {
                idx++;
                answer++;
            }
        }
        return answer;
    }
}
