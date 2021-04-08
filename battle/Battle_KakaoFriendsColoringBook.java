package com.company.battle;
import java.util.*;
public class Battle_KakaoFriendsColoringBook {
    public class ColorNode{
        public int x;
        public int y;
        public ColorNode(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    private int BFS(int x,int y,int[][] picture,boolean[][] visit){
        Queue<ColorNode> q=new LinkedList<>();
        int res=1;
        visit[x][y]=true;
        q.add(new ColorNode(x,y));
        while(!q.isEmpty()){
            int tx=q.peek().x;
            int ty=q.peek().y;
            q.poll();
            for(int i=0;i<4;i++){
                int nx=tx+dx[i];
                int ny=ty+dy[i];
                if(nx<0||ny<0||nx>=picture.length||ny>=picture[0].length)continue;
                if(visit[nx][ny])continue;
                if(picture[tx][ty]!=picture[nx][ny])continue;
                visit[nx][ny]=true;
                res++;
                q.add(new ColorNode(nx,ny));
            }
        }
        return res;
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visit=new boolean[picture.length][picture.length];
        for(int i=0;i< picture.length;i++)
            for(int j=0;j<picture[0].length;j++)
                if(picture[i][j]!=0&&!visit[i][j]){
                    numberOfArea++;
                    maxSizeOfOneArea=Math.max(maxSizeOfOneArea,BFS(i,j,picture,visit));
                }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
