package com.company;

public class FindBiggestRec {
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][]dp=new int[board.length][board[0].length];
        for(int i=0;i<board[0].length;i++){
            dp[0][i]=board[0][i];
        }
        for(int i=1;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(j==0){
                    dp[i][j]=board[i][j]==1?1:0;
                }
                else if(board[i][j]==0){
                    dp[i][j]=0;
                }
                else if(board[i][j]==1){
                    int min=0;
                    if(dp[i][j-1]!=0&&dp[i-1][j]!=0&&dp[i-1][j-1]!=0){
                        min=Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                        dp[i][j]=min+1;
                    }
                    else
                        dp[i][j]=1;
                }

                answer=Math.max(answer,dp[i][j]);
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        return answer;
    }
}
