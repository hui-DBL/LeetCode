package LeetCode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 4));
        list.add(new Interval(0, 2));
        list.add(new Interval(3, 5));
        showInterval(list);
        List<Interval> result = merge(list);
        showInterval(result);
    }

    private static void showInterval(List<Interval> result) {
        for (Interval interval : result) {
            System.out.println(interval.start + "===>" + interval.end);
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (result.isEmpty()) {
                result.add(intervals.get(0));
            } else {
                if (result.get(result.size()-1).end >= intervals.get(i).start) {
                    //merge
                    Interval interval = result.get(result.size() - 1);
                    interval.start = Math.min(intervals.get(i).start, interval.start);
                    interval.end = Math.max(intervals.get(i).end, interval.end);
                    result.remove(result.size()-1);
                    result.add(interval);
                } else {
                    // no-merge
                    result.add(intervals.get(i));
                }
            }
        }
        return result;
    }
}

/**
 * Definition for an interval.
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}