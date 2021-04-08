package com.company;
import java.util.*;
class Node{
    int x;
    int y;
    public Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class KakaoFriendsColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        Queue<Node>q=new LinkedList<>();
        boolean[][] isVisit=new boolean[m][n];

        for(int i=0;i<picture.length;i++){
            for(int j=0;j<picture[i].length;j++){
                if(isVisit[i][j]==false&&picture[i][j]!=0){
                    int num=1;
                    isVisit[i][j]=true;
                    q.add(new Node(i,j));
                    while(!q.isEmpty()){
                        int tx=q.peek().x;
                        int ty=q.peek().y;
                        q.poll();

                        for(int k=0;k<4;k++){
                            int nx=tx+dx[k];
                            int ny=ty+dy[k];
                            if(nx<0||ny<0||nx>=m||ny>=n)continue;
                            if(isVisit[nx][ny])continue;
                            if(picture[nx][ny]!=picture[tx][ty])continue;
                            isVisit[nx][ny]=true;
                            q.add(new Node(nx,ny));
                            num++;
                        }
                    }
                    numberOfArea++;
                    maxSizeOfOneArea=Math.max(maxSizeOfOneArea,num);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
