class Solution {
    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));

        int N = courses.length;
        Queue<Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int time = 0;
        int exclude = 0;

        for (int i = 0; i < N; i++) {
            int[] course = courses[i];
            time = time + course[0];
            q.add(course[0]);

            while (time > course[1] && !q.isEmpty()) {
                exclude++;
                int highestDuration = q.poll();
                time = time - highestDuration;
            }
        }

        return N - exclude;
    }
}
