package com.company;

public class TargetNumber {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0,0,numbers,target);
        return answer;
    }
    private void dfs(int cnt,int sum,int[] numbers,int target){
        if(cnt==numbers.length){
            if(sum==target){
                answer++;
            }
        }
        else{
            dfs(cnt+1,sum+numbers[cnt],numbers,target);
            dfs(cnt+1,sum-numbers[cnt],numbers,target);
        }
    }
}
