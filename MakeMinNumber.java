package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class MakeMinNumber {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int n=A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<n;i++){
            answer+=A[i]*B[n-i-1];
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        return answer;
    }
}
