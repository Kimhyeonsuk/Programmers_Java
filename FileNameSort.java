package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FileNameSort {
    public class FileNode implements Comparable<FileNode> {
        public String Header;
        public String Number;
        public String Tail;
        public FileNode(String h,String n,String t){
            this.Header=h;
            this.Number=n;
            this.Tail=t;
        }
        @Override
        public int compareTo(FileNode target) {
            if(this.Header.compareToIgnoreCase(target.Header)==0){
                int n1=Integer.parseInt(this.Number);
                int n2=Integer.parseInt(target.Number);
                return n1-n2;
            }
            else
            {
                return this.Header.compareToIgnoreCase(target.Header);
            }

        }
    }
    public String[] solution(String[] files) {
        String[] answer = {};
        ArrayList<FileNode> list= new ArrayList<>();

        for(String s:files){
            String h="",n="",t="";
            int cnt=0;//0: h 1:n 2: t
            for(int i=0;i<s.length();i++){
                if(cnt==0&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    cnt++;
                    n+=s.charAt(i);
                }
                else if(cnt==1&&(s.charAt(i)<'0'||s.charAt(i)>'9')){
                    cnt++;
                    t=s.substring(i);
                    break;
                }
                else if(cnt==0)
                    h+=s.charAt(i);
                else if(cnt==1)
                    n+=s.charAt(i);
            }
            list.add(new FileNode(h,n,t));
        }
        Collections.sort(list);
        answer=new String[list.size()];
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            answer[i]=list.get(i).Header+list.get(i).Number+list.get(i).Tail;
        }
        return answer;
    }

}
