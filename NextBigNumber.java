package com.company;

public class NextBigNumber {
    public int solution(int n) {
        int answer = 0;
        int nOneNum=caculateOneNum(n);
        while(true){
            ++n;
            if(nOneNum==caculateOneNum(n))
                break;
        }
        return n;
    }
    //n에서 1의 개수 반환
    private int caculateOneNum(int n){
        int num=n;
        int res=1;
        while(num!=1){
            if(num%2==1)
                res++;
            num=num/2;
        }
        return res;
    }
}
