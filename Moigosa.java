package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Moigosa {
    public Integer[] solution(int[] answers) {
        List<Integer> ans=new ArrayList<>();
        int[] score = {0,0,0};
        int[] student1={1,2,3,4,5};
        int[] student2={2,1,2,3,2,4,2,5};
        int[] student3={3,3,1,1,2,2,4,4,5,5};


        for(int i=0;i<answers.length;i++){
            if(student1[i%5]==answers[i])
                score[0]++;
            if(student2[i%8]==answers[i])
                score[1]++;
            if(student3[i%10]==answers[i])
                score[2]++;
        }

        int max=0;
        for(int i=0;i<score.length;i++){
            max=Math.max(score[i],max);
        }

        for(int i=0;i<score.length;i++){
            if(max==score[i]){
                ans.add(i+1);
            }
        }

        return ans.toArray(new Integer[ans.size()]);
    }
}
