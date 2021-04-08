package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ThatMusic {
    public class MusicNode{
        public String name;//제목
        public int playTime;//재생길이
        public MusicNode(String n,int pt){
            this.name=n;
            this.playTime=pt;
        }
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m=m.replaceAll("C#","X").replaceAll("D#","Y")
                .replaceAll("F#","Z").replaceAll("G#","W")
                .replaceAll("A#","P");
        ArrayList<String> musicArray=new ArrayList<>();
        for(int i=0;i<musicinfos.length;i++){
            musicinfos[i]=musicinfos[i].replaceAll("C#","X").replaceAll("D#","Y")
                    .replaceAll("F#","Z").replaceAll("G#","W")
                    .replaceAll("A#","P");
            String[] split=musicinfos[i].split(",");
            int startTime=convertStringToTime(split[0]);
            int endTime=convertStringToTime(split[1]);
            int playTime=endTime-startTime;//재생시간
            String score=split[3];//악보
            int scorelen=score.length();//악보 길이
            StringBuilder sb=new StringBuilder();
            for(int minute=0;minute<playTime;minute++){
                sb.append(score.charAt(minute%scorelen));
            }
            musicArray.add(sb.toString());
        }

        int cnt=0;
        ArrayList<MusicNode> resultList=new ArrayList<>();
        for(String music:musicArray){
            int idx=0;
            if(music.contains(m)){
                resultList.add(new MusicNode(musicinfos[cnt].split(",")[2],music.length()));
            }
            cnt++;
        }


        if(resultList.isEmpty())
            answer="(None)";
        else
        {
            int max=0;
            int maxIdx=0;
            for(int i=0;i<resultList.size();i++){
                if(max<resultList.get(i).playTime) {
                    max = resultList.get(i).playTime;
                    maxIdx = i;
                }

           }
            answer=resultList.get(maxIdx).name;
        }
        return answer;
    }
    private int convertStringToTime(String s){
        int h=Integer.parseInt(s.substring(0,2))*60;
        int m=Integer.parseInt(s.substring(3,5));
        return h+m;
    }
}
