package com.company;

public class BinaryConvertion {
    public int[] solution(String s) {
        int[] answer = {};
        int convertNum=0;
        int zeroNum=0;
        while(!s.equals("1")){
            String newString=s.replaceAll("0","");
            zeroNum+=s.length()-newString.length();
            int num=newString.length();

            StringBuilder sb=new StringBuilder();
            while(num!=1){
                sb.insert(0,num%2);
                num=num/2;
            }
            sb.insert(0,1);
            s=sb.toString();
            convertNum++;
        }
        answer[0]=convertNum;
        answer[1]=zeroNum;
        return answer;
    }
}
