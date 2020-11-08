package at_2020.design;

import java.util.*;

/**
 * @author hui.zhong
 * @date 2020/10/31
 */
public class RandomizedCollection {

    private LinkedList<Integer> linkedList = new LinkedList();

    private Map<Integer, List<Integer>> valIndexListMap = new HashMap<>(100);

    public RandomizedCollection() {

    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        List<Integer> indexList = valIndexListMap.getOrDefault(val, new ArrayList<>());
        boolean result = indexList.isEmpty();
        indexList.add(indexList.size());
        linkedList.add(val);
        valIndexListMap.put(val, indexList);
        return result;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        List<Integer> indexList = valIndexListMap.getOrDefault(val, new ArrayList<>());
        if (indexList.isEmpty()) {
            return false;
        }
        indexList.remove(0);
        linkedList.removeFirstOccurrence(val);
        valIndexListMap.put(val, indexList);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int index = (int) Math.floor((Math.random() * linkedList.size()));
        return linkedList.get(index);
    }
}
