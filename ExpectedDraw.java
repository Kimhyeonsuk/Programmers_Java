package com.company;

public class ExpectedDraw {
    public int solution(int n, int a, int b)
    {
        int answer = 3;

        int power=0;
        int tmp=n;
        while(tmp!=1){
            power++;
            tmp=tmp/2;
        }
        int cnt=power;
        while(n!=1){
            n=n/2;
            cnt--;
            if((a-1)/n!=(b-1)/n){
                answer=cnt+1;
                break;
            }
            else
                continue;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
