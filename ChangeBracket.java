package com.company;
import java.util.*;
public class ChangeBracket {
    public String solution(String p) {
        String answer=solve("",p);
        return answer;
    }

    private String solve(String u,String v){
        String uStr=u, vStr=v;
        if(vStr.equals(""))
            return "";
        int openCharNum=0,closeCharNum=0,i=0;
        for(i=0;i<vStr.length();i++){
            if(vStr.charAt(i)=='(')
                openCharNum++;
            else if(vStr.charAt(i)==')')
                closeCharNum++;
            if(openCharNum==closeCharNum)
                break;
        }
        uStr=vStr.substring(0,i+1);
        vStr=vStr.substring(i+1);

        //u가 올바른가?
        if(isRight(uStr)){
            return uStr+solve("",vStr);
        }
        //u가 올바르지 않는가?
        else{
            String tmp="("+solve("",vStr)+")";
            uStr=uStr.substring(1,uStr.length()-1);
            uStr=reverseString(uStr);
            return tmp+uStr;
        }
    }

    private String reverseString(String u){
        StringBuilder tmp=new StringBuilder();
        char[] cArr=u.toCharArray();
        for(char c : cArr){
            tmp.append(c=='('?')':'(');
        }
        return tmp.toString();
    }
    //u가 올바른 String 이면 true 반환
    private boolean isRight(String u){
        Stack<Character> s=new Stack<>();

        char [] cArr=u.toCharArray();
        for(char a :cArr){
            if(a=='('){
                s.push(a);
            }else
            {
                if(s.empty()||s.peek()!='(')
                    return false;
                else if(s.peek()!='('){
                    s.pop();
                }
            }
        }

        if(s.empty())
            return false;
        return true;
    }
}
