package com.company;

import java.util.*;
public class CandidateKey {
    private void permutation(int idx, int cnt,int mx,ArrayList<Integer>list,String[][]relation,ArrayList<ArrayList<Integer>>CandidateKeySet){
        if(list.size()==cnt){
            Set<String> chkSet = new HashSet<>();
            for (int rn = 0; rn < relation.length; rn++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sb.append(relation[rn][list.get(i)] + "-");
                }
                chkSet.add(sb.toString());
            }
            if(chkSet.size()==relation.length){
                boolean mincity=true;
                for(ArrayList childList:CandidateKeySet){
                    if(list.containsAll(childList)){
                        mincity=false;
                        break;
                    }
                }
                if(mincity||CandidateKeySet.isEmpty()){
                    ArrayList<Integer> newList=new ArrayList<>(list);
                    CandidateKeySet.add(newList);
                }
            }
            return;
        }
        for(int i=idx;i<mx;i++){
            list.add(i);
            permutation(i+1,cnt,mx,list,relation,CandidateKeySet);
            list.remove(list.size()-1);
        }
    }
    public int solution(String[][] relation) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> CandidateKeySet=new ArrayList<>();
        for(int i=1;i<=relation[0].length;i++){//컬럼의 개수
            ArrayList<Integer>list=new ArrayList<>();
            permutation(0,i,relation[0].length,list,relation,CandidateKeySet);
        }
        answer=CandidateKeySet.size();
        return answer;
    }
}
