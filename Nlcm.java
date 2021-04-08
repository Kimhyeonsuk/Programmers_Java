package com.company;

public class Nlcm {
    private int gcd(int a,int b){
        while(b!=0){
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
    private int lcm(int a,int b){
        return a*b/gcd(a,b);
    }
    public int solution(int[] arr) {
        int answer = 0;
        int num=arr[0];
        for(int i=1;i<arr.length;i++){
            num=lcm(num,arr[i]);
        }
        return num;
    }
}
