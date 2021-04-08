package com.company;
import java.net.Inet4Address;
import java.util.*;
class NumNode implements Comparable<NumNode>{
    String value;
    public NumNode(String s){
        this.value=s;
    }
    @Override
    public int compareTo(NumNode target) {
        String shortStr=this.value.length()>target.value.length()?target.value:this.value;
        String longerStr=this.value.length()<target.value.length()?target.value:this.value;

        for(int i=0;i<shortStr.length();i++){
            String sNum=shortStr.substring(i,i+1);
            String lNum=longerStr.substring(i,i+1);
            if(Integer.parseInt(sNum)>Integer.parseInt(lNum)){
                return -1;
            }
        }
        return 1;
    }
}
public class BiggestNum {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String>list=new ArrayList<>();
        for(int a : numbers){
            list.add(Integer.toString(a));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(list.get(0)=="0")
            answer+="0";
        else
        {
            Iterator<String>iterator=list.iterator();
            while(iterator.hasNext()){
                answer+=iterator.next();
            }
        }
        return answer;
    }

/*
    public String solution(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }*/
}
