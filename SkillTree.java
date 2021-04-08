package com.company;

import java.util.*;
public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<Character>queue=new LinkedList<>();
        Map<Character,Boolean> map=new HashMap<>();

        for(int i=0;i<skill_trees.length;i++){
            for(int j=0;j<skill.length();j++){
                map.put(skill.charAt(j),true);
                queue.add(skill.charAt(j));
            }

            boolean success=true;
            for(int j=0;j<skill_trees[i].length();j++){
                char a=skill_trees[i].charAt(j);
                if(map.containsKey(a)&&map.get(a)==true){
                    if(queue.peek()==skill_trees[i].charAt(j)){
                        map.put(skill_trees[i].charAt(j),false);
                        queue.poll();
                    }
                    else
                    {
                        success=false;
                        break;
                    }
                }
            }

            if(success)
                answer++;
            queue.clear();

        }
        return answer;
    }
}
