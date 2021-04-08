package com.company.battle2;

import java.util.Arrays;

public class battle2_Nlcm {
    private int gcd(int a,int b){
        while(b!=0){
            int r=a%b;
            a=b;
            b=r;
        }

        return a;
    }
    private int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int tmp=arr[0];
        for(int i=1;i<arr.length;i++){
            tmp=lcm(tmp,arr[i]);
            answer=tmp;

        }
        return answer;
    }
}
