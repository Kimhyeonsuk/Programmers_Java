package com.company;

import java.util.ArrayList;
import java.util.*;
public class TakePicture {
    public int answer;
    public String everyOne1;
    private void dfs(String curStr,String[] data){//조합 만들기
        if(curStr.length()==8){
            if(canStand(curStr,data))
                answer++;
            return;
        }
        else{
            for(int i=0;i<8;i++){
                char a=everyOne1.charAt(i);
                if(curStr.indexOf(a)==-1){
                    dfs(curStr+a,data);
                }
            }
        }
    }
    private boolean canStand(String curStr,String[] data){
        for(int i=0;i<data.length;i++){
            char source1=data[i].charAt(0);
            char target1=data[i].charAt(2);
            char op=data[i].charAt(3);
            int num1=data[i].charAt(4)-'0';
            int sourceIdx=curStr.indexOf(source1);
            int targetIdx=curStr.indexOf(target1);
            int differ=Math.abs(sourceIdx-targetIdx)-1;
            if(op=='='&&differ!=0)
                return false;
            else if(op=='<'&&differ>=num1)
                return false;
            else if(op=='>'&&differ<=num1)
                return false;
        }
        return true;
    }
    public int solution(int n, String[] data) {
        answer = 0;
        everyOne1="ACFJMNRT";
        dfs("",data);
        return answer;
    }
}
