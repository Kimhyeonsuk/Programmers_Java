package com.company.battle2;

public class battle2_TempMove {
    private int solve(int n){
        if(n==1)
            return 1;
        if(n%2==0){
            return solve(n/2);
        }
        else{
            return solve(n-1)+1;
        }
    }
    public int solution(int n) {
        int ans = 0;
        ans=solve(n);
        while(n!=1){
            if(n%2==0){
                n=n/2;
            }
            else{
                ans++;
                n=(n-1)/2;
            }
        }
        ans++;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return ans;
    }
}
