package com.company.battle2;

public class battle2_NumberExpression {
    public int solution(int n) {
        int answer = 0;
        for(int i=1;i<n;i++){
            int idx=i;
            int sum=i;
            while(sum<n){
                sum+=++idx;
                if(sum==n)
                {
                    answer++;
                    break;
                }
            }
        }
        answer++;
        return answer;
    }
}
