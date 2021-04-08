package com.company;

import java.io.FilePermission;
import java.util.*;
public class EnglishWordGame {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int FailPeopleNum=0;
        int FailCnt=0;
        Set<String> set=new HashSet<>();
        String tmpWord=words[0];
        set.add(tmpWord);
        for(int i=1;i<words.length;i++){
            if(tmpWord.charAt(tmpWord.length()-1)!=words[i].charAt(0))
            {
                FailPeopleNum=(i%n)+1;
                FailCnt=(i/n)+1;
                break;
            }
            else if(set.contains(words[i])){
                FailPeopleNum=(i%n)+1;
                FailCnt=(i/n)+1;
                break;
            }
            else{//성공
                tmpWord=words[i];
                set.add(tmpWord);
            }
        }

        answer[0]= FailPeopleNum;
        answer[1]=FailCnt;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
