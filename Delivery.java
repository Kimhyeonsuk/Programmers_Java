package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Delivery {
    public class DeliveryNode implements Comparable<DeliveryNode> {
        public int dist;
        public int here;

        DeliveryNode(int d,int h){
            this.dist=d;
            this.here=h;
        }

        @Override
        public int compareTo(DeliveryNode o) {
            return this.dist-o.dist;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[]distArr=new int[N+1];
        Arrays.fill(distArr,Integer.MAX_VALUE);
        PriorityQueue<DeliveryNode>pq= new PriorityQueue<>();

        int[][] map=new int[N+1][N+1];
        for(int i=0;i<road.length;i++){
            if(map[road[i][0]][road[i][1]]!=0){
                map[road[i][0]][road[i][1]]= Math.min(map[road[i][0]][road[i][1]],road[i][2]);
            }
            else
                map[road[i][0]][road[i][1]]=road[i][2];
            if(map[road[i][1]][road[i][0]]!=0)
            {
                map[road[i][1]][road[i][0]]=Math.min(map[road[i][1]][road[i][0]],road[i][2]);
            }
            else
                map[road[i][1]][road[i][0]]=road[i][2];


        }

        pq.add(new DeliveryNode(0,1));
        distArr[1]=0;
        while(!pq.isEmpty()){
            int here=pq.peek().here;
            int dist=pq.peek().dist;
            pq.poll();
            for(int i=0;i<map[here].length;i++){
                if(map[here][i]==0)continue;
                if(distArr[i]>dist+map[here][i]){
                    distArr[i]=dist+map[here][i];
                    pq.add(new DeliveryNode(distArr[i],i));
                }
            }
        }

        for(int i=1;i<=N;i++){
            if(distArr[i]<=K)
                answer++;
        }


        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
