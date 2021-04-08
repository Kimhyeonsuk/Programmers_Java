package com.company;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class SelectTwoPlus {
    /*public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<numbers.length;i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int num = numbers[i] + numbers[j];
                set.add(num);
            }
        }
        answer=set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }*/

    public int[] solution(int [] numbers){

        Set<Integer>set=new TreeSet<>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                int num=numbers[i]+numbers[j];
                set.add(num);
            }
        }

        int[] answer=new int[set.size()];
        int idx=0;
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            answer[idx++]=(int)iterator.next();
        }

        return answer;
    }
}
