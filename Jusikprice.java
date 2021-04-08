package com.company;

import java.util.*;
public class Jusikprice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<prices.length;i++){

            while(!stack.empty()&&prices[stack.peek()]>prices[i]){
                answer[stack.peek()]=i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        int s=prices.length-1;
        while(!stack.empty()){
            answer[stack.peek()]=s-stack.peek();
            stack.pop();
        }
        return answer;
    }
}
