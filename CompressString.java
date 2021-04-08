package com.company;
import java.util.*;
public class CompressString {
    public int solution(String s) {
        int answer = 0;
        int min=s.length();
        for(int unit_size=1;unit_size<=s.length()/2;unit_size++){
            int compLen=compression(s,unit_size).length();
            min=Math.min(min,compLen);
        }
        return min;
    }
    private String compression(String s, int unit_size){
        StringBuilder res=new StringBuilder();
        String pattern="";
        int cnt=0;
        for(int idx=0;idx<=s.length();idx+=unit_size){
            if(unit_size>s.substring(idx).length()){
                if(cnt!=0){
                    res.append(cnt+1);
                }
                res.append(pattern);
                res.append(s.substring(idx));
                break;
            }
            else if(pattern.equals(s.substring(idx,idx+unit_size))==true){
                cnt++;
            }
            else{
                if(cnt!=0){
                    res.append(cnt+1);
                }
                res.append(pattern);
                pattern=s.substring(idx,idx+unit_size);
                cnt=0;
            }
        }
        return res.toString();
    }
}
