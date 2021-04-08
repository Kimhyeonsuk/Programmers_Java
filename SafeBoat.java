package com.company;

import java.util.Arrays;

public class SafeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int j=0;
        for(int i=people.length-1;i>=j;i--){
            if(people[i]+people[j]>limit){
                answer++;
            }
            else{
                j++;
                answer++;
            }
        }
        return answer;
    }
}
