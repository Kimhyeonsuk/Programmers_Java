package com.company;

public class PresentNumber {
    public int solution(int n) {
        int answer = 0;
        for(int i=1;i<n;i++){
            int sum=i;
            int cnt=i;
            boolean fnd=false;
            while(sum<n){
                sum+=++cnt;
                if(sum==n){
                    fnd=true;
                    break;
                }
            }
            if(fnd)
                answer++;
        }
        answer++;
        return answer;
    }
}
