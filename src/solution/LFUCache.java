package solution;/*solution.LFUCache.java
Copyright 2011-2020 Qunhe Tech, all rights reserved.
Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.

@Author: tianming
@created: 2020/4/7
*/

/**
 * Your solution.LFUCache object will be instantiated and called as such:
 * solution.LFUCache obj = new solution.LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * https://leetcode-cn.com/problems/lfu-cache/
 */

import java.util.*;

/**
 * @author tianming
 */
public class LFUCache {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        lfuCache.get(1);
        lfuCache.put(3,3);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.put(4,4);
        lfuCache.get(1);
        lfuCache.get(3);
        lfuCache.get(4);
    }


    private int capacity;
    private Map<Integer, Integer> valueMap = new HashMap<>();
    private Map<Integer, Long> lastUseMap = new HashMap<>();
    private Map<Integer, Long> useNumMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = valueMap.get(key);
        if (Objects.nonNull(value)) {
            lastUseMap.put(key, System.currentTimeMillis());
            useNumMap.put(key, useNumMap.get(key) == null ? 1 : useNumMap.get(key) + 1);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        int size = valueMap.size();
        if (Objects.isNull(valueMap.get(key))){
            if (size == capacity){
                this.removeOne();
            }
            valueMap.put(key, value);
        }
        lastUseMap.put(key, System.currentTimeMillis());
        useNumMap.put(key, useNumMap.get(key) == null ? 1 : useNumMap.get(key) + 1);
    }

    private void removeOne() {
        List<Integer> needRemoveKeys = new ArrayList<>();
        Long minUseNum = null;
        for (Integer key : useNumMap.keySet()) {
            long u = useNumMap.get(key);
            if (minUseNum == null){
                minUseNum = u;
            }else if (minUseNum > u) {
                minUseNum = u;
            }
        }
        for (Integer key : useNumMap.keySet()) {
            long u = useNumMap.get(key);
            if (minUseNum == u) {
                needRemoveKeys.add(key);
            }
        }
        int removeKey = 0;
        if (needRemoveKeys.size() == 1) {
            removeKey = needRemoveKeys.get(0);
        } else {
            long lastUseTime = 0;
            for (Integer key : needRemoveKeys) {
                long last = lastUseMap.computeIfAbsent(key, key1 -> 0L);
                if (lastUseTime <= last) {
                    lastUseTime = last;
                    removeKey = key;
                }
            }
        }
        valueMap.remove(removeKey);
        lastUseMap.remove(removeKey);
        useNumMap.remove(removeKey);
    }

}
