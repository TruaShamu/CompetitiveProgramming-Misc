import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int idx = 0;
        while (list.size() != 1) {
            int toRemove = (idx + k - 1) % list.size();
            idx = toRemove;
            list.remove(toRemove);
        }
        return list.get(0);
    }

}
