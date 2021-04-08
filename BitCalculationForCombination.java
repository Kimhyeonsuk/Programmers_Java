package com.company;
import java.util.*;
public class BitCalculationForCombination {
    public BitCalculationForCombination(){
        Map<String, List<Integer>> infos = new HashMap<>();
        for (int i = 0; i < (1 << 4); i++) {
            StringBuilder key = new StringBuilder();

            for (int j = 0; j < 4; j++) {
                //if ((i & (1 << j)) > 0) key.append(split[j]);
            }
            //infos.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
        }
    }
    ////i가 1001이면 0번과 3번 인덱스에 해당하는 조건이 선택되어 조합을 만들게 된다.
}
