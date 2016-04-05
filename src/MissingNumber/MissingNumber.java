package MissingNumber;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * For example, Given nums = [0, 1, 3] return 2.
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 */

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int head = 0, tail = nums.length+1;

        int sum = (head + tail) * size /2;

        int acctualSum = 0;
        for(int num: nums) {
            acctualSum += num;
        }

        return sum - acctualSum;
    }
}
