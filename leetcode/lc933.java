// Can be optimized using bool array to store last 3000 ms of activity
class RecentCounter {
    Queue<Integer> q = new LinkedList<>();
    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        q.add(t);
        while (!q.isEmpty() && q.peek() < t-3000) {
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
