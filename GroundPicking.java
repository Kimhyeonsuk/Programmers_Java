package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class GroundPicking {
   /* int solution(int[][] land) {
        int answer = 0;

        int [][]dp=new int[land.length][4];
        for(int i=0;i<4;i++){
            dp[0][i]=land[0][i];
            answer=Math.max(answer,dp[0][i]);
        }

        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                ArrayList<Integer>list=new ArrayList<>();
                for(int a:land[i])
                    list.add(a);
                Collections.sort(list);
                if(land[i][j]==list.get(3))
                    dp[i][j]=dp[i-1][j]+list.get(2);
                else,
                    dp[i][j]=dp[i-1][j]+list.get(3);

                answer=Math.max(answer,dp[i][j]);
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }*/
   int solution(int[][] land) {
       int answer = 0;

       for(int i=1;i<land.length;i++){
           land[i][0]+=Math.max(land[i-1][1],Math.max(land[i-1][3],land[i-1][2]));
           land[i][1]+=Math.max(land[i-1][0],Math.max(land[i-1][3],land[i-1][2]));
           land[i][2]+=Math.max(land[i-1][1],Math.max(land[i-1][3],land[i-1][0]));
           land[i][3]+=Math.max(land[i-1][1],Math.max(land[i-1][0],land[i-1][2]));
       }


       for(int i=0;i<4;i++){
           answer= Math.max(answer,land[land.length-1][i]);
       }
       // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
       System.out.println("Hello Java");

       return answer;
   }
}
