package com.company;

import java.util.*;
public class VisitDistance {
    int []dx={0,0,-1,1};
    int []dy={1,-1,0,0};
    public int solution(String dirs) {
        int answer = 0;
        Map<String,boolean[]> map=new HashMap<>();

        for(int i=-5;i<=5;i++){
            for(int j=-5;j<=5;j++){
                StringBuilder sb=new StringBuilder();
                sb.append(i);sb.append(j);
                boolean[] arr=new boolean[]{false,false,false,false};
                map.put(sb.toString(),arr);
            }
        }

        int x=0,y=0;
        for(int i=0;i<dirs.length();i++){
            char op=dirs.charAt(i);
            int dir=0;
            if(op=='U')
                dir=0;
            else if(op=='D')
                dir=1;
            else if(op=='R')
                dir=2;
            else if(op=='L')
                dir=3;
            int ndir=dir%2==1?dir-1:dir+1;
            int nx=x+dx[dir];
            int ny=y+dy[dir];
            String tmp=String.valueOf(x)+String.valueOf(y);
            if(Math.abs(nx)>=6||Math.abs(ny)>=6||Math.abs(nx)<0||Math.abs(ny)<0)continue;
            String ntmp=String.valueOf(nx)+String.valueOf(ny);
            if(map.get(tmp)[dir]==false){
                map.get(tmp)[dir]=true;
                map.get(ntmp)[ndir]=true;
                answer++;
            }
            x=nx;
            y=ny;
        }
        return answer;
    }
}
