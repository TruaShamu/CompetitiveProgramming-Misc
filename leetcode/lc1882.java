
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int N = servers.length;
        int M = tasks.length;

        // Comparator for the free servers. Assume we are recieving [weight, idx, freed_time]
        Comparator<int[]> freeComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] != arr2[0]) {
                    return Integer.compare(arr1[0], arr2[0]);
                } else {
                    return Integer.compare(arr1[1], arr2[1]);
                }

            }
        };

        // Comparator for the jailed servers. Assume we are recieving [weight, idx, freed_time]
        Comparator<int[]> jailedComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                // Get closest time
                if (arr1[2] != arr2[2]) {
                    return Integer.compare(arr1[2], arr2[2]);
                } else {
                    // If the times are the same, get the lowest weight
                    if (arr1[0] != arr2[0]) {
                        return Integer.compare(arr1[0], arr2[0]);
                    }
                    return Integer.compare(arr1[1], arr2[1]);
                }
            }
        };

        PriorityQueue<int[]> free = new PriorityQueue<>(freeComparator);
        PriorityQueue<int[]> jailed = new PriorityQueue<>(jailedComparator);
        
        // Populate free pq
        for (int i = 0; i < N; i++) {
            free.add(new int[] {servers[i], i, 0});
        }

        int[] ret = new int[M];
        for (int i=0; i< M; i++) {
            // Move items from jailed to free
            while (jailed.size() > 0 && jailed.peek()[2] <= i) {
                free.add(jailed.poll());
            }

            if (free.size() > 0) {
                // Get the free server and move to jailed
                int[] oServer = free.poll();
                ret[i] = oServer[1];
                oServer[2] = i + tasks[i];
                jailed.add(oServer);
            } else {
                // Wait for the jailed server and get it back
                if (jailed.size() > 0) {
                    int[] oServer = jailed.poll();
                    ret[i] = oServer[1];
                    oServer[2] += tasks[i];
                    jailed.add(oServer);
                }
            }
        }
        return ret;

    }
}

