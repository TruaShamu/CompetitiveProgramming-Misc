import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        Set<Integer> mySet = new HashSet<Integer>();
        int sum1 = 0;
        for (int i : nums) {
            mySet.add(i);
            sum1 += i;
        }

        int sum2 = 0;
        for (int i : mySet) {
            sum2 += i;
        }
        sum2 = sum2 * 2;
        return -(sum1 - sum2);
    }
}
