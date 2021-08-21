class Solution {
public int arraySign(int[] nums) {
        int negative = 0;
        for (int a : nums) {
            if (a==0) {
                return 0;
            }
            
            if (a < 0) {
                negative++;
            }
        }
        
        if (negative % 2 == 0) {
            return 1;
        }
        return -1;

    }
}
