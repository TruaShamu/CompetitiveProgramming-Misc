import java.util.Arrays;

class Solution {
    public boolean squareIsWhite(String coordinates) {
        int c = coordinates.charAt(0) - 'a';
        int r = coordinates.charAt(1) - '0';

        int sum = c + r;
        if (sum % 2 == 0) {
            return true;
        }

        return false;


    }
}
