
import java.util.PriorityQueue;


    class Solution {
        public int[] getOrder(int[][] tasks) {
            int N = tasks.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

            for (int i = 0; i < N; i++) {
                int start = tasks[i][0];
                int length = tasks[i][1];
                pq.add(new int[]{start, length, i});
            }


            PriorityQueue<int[]> avail = new PriorityQueue<>((a, b) -> (a[1] != b[1]) ?
                    a[1] - b[1] : a[2] - b[2]);

            int time = 0;
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                while (!pq.isEmpty() && pq.peek()[0] <= time) {
                    avail.add(pq.poll());
                }


                if (avail.isEmpty()) {
                    time = pq.peek()[0];
                }
                while (!pq.isEmpty() && pq.peek()[0] <= time) {
                    avail.add(pq.poll());
                }

                int[] cur = avail.poll();
                res[i] = cur[2];
                time += cur[1];
            }

            return res;
        }
    }

