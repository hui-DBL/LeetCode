package at_2018.LeetCode.binerysearch;

public class SearchinRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        if (nums.length <= 0) {
            return false;
        }

        int st = nums[0];
        int ed = nums[nums.length - 1];

        if (st == target || ed == target) {
            return true;
        }

        int stIndex = 0;
        int edIndex = nums.length - 1;
        int mdIndex = 0;

        while (stIndex < edIndex) {
            if (nums[stIndex] == nums[edIndex]) {
                if (edIndex - stIndex == 1) {
                    break;
                }
                stIndex++;
                edIndex--;
            } else if (nums[stIndex] > nums[edIndex]) {
                stIndex++;
            } else if (nums[stIndex] < nums[edIndex]) {
                edIndex--;
            }
        }
        mdIndex = stIndex;

        stIndex = 0;
        edIndex = nums.length - 1;

        if (nums[mdIndex] == target) {
            return true;
        } else if (nums[mdIndex] < target) {
            if (nums[edIndex] < target) {
                while (stIndex < mdIndex) {
                    if (stIndex + 1 < mdIndex) {
                        if (nums[stIndex + 1] == target) {
                            return true;
                        }
                    }
                    stIndex++;
                }
            } else {
                while (mdIndex < edIndex) {
                    if (mdIndex + 1 < edIndex) {
                        if (nums[mdIndex + 1] == target) {
                            return true;
                        }
                    }
                    mdIndex++;
                }
            }
        } else {
            return false;
        }

        return false;
    }
}
