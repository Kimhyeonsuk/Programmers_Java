package com.company;
import java.util.*;
public class GameMapMinDistance {
    int []dx={-1,1,0,0};
    int []dy={0,0,-1,1};
    public class GameNode{
        public int x;
        public int y;
        public int cnt;
        public GameNode(int x,int y,int cnt){
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
    }
    private int BFS(int[][] maps,boolean[][] visit){
        Queue<GameNode> q=new LinkedList<>();

        q.add(new GameNode(0,0,1));
        visit[0][0]=true;
        int res=0;
        while(!q.isEmpty()){
            int x=q.peek().x;
            int y=q.peek().y;
            int cnt=q.peek().cnt;

            q.poll();
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx<0||ny<0||nx>= maps.length||ny>=maps[0].length)continue;
                if(visit[nx][ny])continue;
                if(maps[nx][ny]==0)continue;

                if(nx== maps.length-1&&ny==maps[0].length-1)
                    return cnt+1;
                visit[nx][ny]=true;
                q.add(new GameNode(nx,ny,cnt+1));
            }
        }

        return -1;
    }
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] chk=new boolean[maps.length][maps[0].length];
        answer=BFS(maps,chk);
        return answer;
    }
}
