import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        int N = groups.length;
        int[] remFreq = new int[batchSize];
        int ans = 0;
        int remGroup = 0;


        //Find remainders of each group.
        for (int i : groups) {
            int r = i % batchSize;
            remFreq[r]++;
            if (r != 0) {
                remGroup++;
            }
        }


        // (donuts left, remainder, groups, map)
        ans = ( remFreq[0] + search(0, remFreq, remGroup, new HashMap<>())); //Full groups;
        return(ans);
    }



    public int search(int donutLeft, int[] remFreq, int remGroup, HashMap<String, Integer> map){
        //We are done.
        if (remGroup == 0) {
            return(0);
        }


        int N = remFreq.length;

        //Hash string.
        String key = Integer.hashCode(donutLeft) + Arrays.toString(remFreq);
        if (map.containsKey(key)) {
            return (map.get(key));
        }

        //Happy groups
        int ans = 0;

        //No donuts left, curGroup works.
        if (donutLeft == 0) {
            ans++;
            donutLeft = N; //new batch.
        }
        int curRes = 0;

        //Loop through all remainder freq
        for (int i = 1; i < N; i++) {
            //Empty

            if (remFreq[i] == 0) {
                continue;
            }

            //Process
            remFreq[i]--; //Remove group.
            int groupsLeft = remGroup - 1;


            //Donuts left
            int nextDonut = donutLeft - i;

            if (nextDonut < 0) {
                nextDonut += N;
            }

            curRes = Integer.max(curRes, search(nextDonut, remFreq, groupsLeft, map));
            //Undo.
            remFreq[i]++;
        }

        ans += curRes;
        map.put(key, ans); //
        return (ans);
    }
}
