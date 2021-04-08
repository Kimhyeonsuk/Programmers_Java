package com.company;
import java.lang.reflect.Array;
import java.util.*;
public class FriendsFourBlock {
    int []dx={-1,-1,0};
    int []dy={-1,0,-1};
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        ArrayList<ArrayList<Character>> list=new ArrayList<>();
        for(String s : board){
            char[] tmp=s.toCharArray();
            ArrayList<Character> clist=new ArrayList<>();
            for(char c: tmp)
                clist.add(c);
            list.add(clist);
        }
        boolean[][] chk=new boolean[list.size()][list.get(0).size()];
        while(chkRemoveLoc(list,chk)){
            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++)
                    if(chk[i][j]==true){
                        list.get(i).add(j,' ');
                        list.get(i).remove(j+1);
                        answer++;
                    }


            for(int i=m-1;i>0;i--) {
                for (int j = 0; j < n; j++) {
                    if (list.get(i).get(j) == ' ') {
                        int idx = i - 1;
                        while (idx >= 0) {
                            if (list.get(idx).get(j) != ' ') {
                                list.get(i).add(j,list.get(idx).get(j));
                                list.get(i).remove(j+1);
                                list.get(idx).add(j,' ');
                                list.get(idx).remove(j+1);
                                break;
                            }
                            else
                                idx--;
                        }
                    }
                }
            }
            for(boolean[] chrow:chk)
                Arrays.fill(chrow,false);
        }

        return answer;
    }
    private boolean chkRemoveLoc(ArrayList<ArrayList<Character>> list, boolean[][] chk){
        int n=list.size();
        int m=list.get(0).size();
        boolean res=false;
        for(int i=1;i<n;i++) {
            for (int j = 0; j<m; j++) {
                int removeCnt = 0;
                char curChar = list.get(i).get(j);
                if (curChar == ' ') continue;
                for (int k = 0; k < 3; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;
                    if (list.get(nx).get(ny) == curChar)
                        removeCnt++;
                }
                if (removeCnt == 3) {
                    chk[i][j] = true;
                    for (int k = 0; k < 3; k++)
                        chk[i + dx[k]][j + dy[k]] = true;
                    res = true;
                }
            }
        }
        return res;
    }
}
