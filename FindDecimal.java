package com.company;

import java.util.*;
public class FindDecimal {
    Set<Integer> possilbeNumset=new HashSet<>();
    int res=0;
    private boolean isDecimal(int num){
        if(num==1)return false;
        if(num==2)return true;
        if(num%2==0)return false;
        int sqrtn=(int)Math.sqrt((double)num);
        for(int div=3;div<=sqrtn;div++) {
            if (num % div == 0)
                return false;
        }
        return true;
    }
    public int solution(String numbers) {
        int answer = 0;
        ArrayList<Character>list=new ArrayList<>();
        for(int i=0;i<numbers.length();i++){
            list.add(numbers.charAt(i));
        }
        ArrayList<Character>resultList=new ArrayList<>();
        for(int len=0;len<numbers.length();len++){//조합을 만들 길이 len
            permutation(list,resultList,len+1);
        }

        Iterator<Integer>iterator=possilbeNumset.iterator();
        while(iterator.hasNext()){
            if(isDecimal(iterator.next()))
                answer++;
        }
        return answer;
    }

    private void permutation(ArrayList<Character> list,ArrayList<Character> resultList,int len){
        if(resultList.size()==len){
            StringBuilder resString=new StringBuilder();
            for(int i=0;i<resultList.size();i++){
                resString.append(resultList.get(i));
            }
            possilbeNumset.add(Integer.parseInt(resString.toString()));
        }
        else{
            for(int i=0;i<list.size();i++){
                resultList.add(list.remove(i));
                permutation(list,resultList,len);
                list.add(i,resultList.remove(resultList.size()-1));
            }
        }
    }

}
