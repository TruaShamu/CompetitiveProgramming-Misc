class Solution {
    public String predictPartyVictory(String senate) {
        // queue problem. categorize r and d by index, every single time we compare top of queue nodes index. for the one with smaller index, we push it back. otherwise we just poll the element.

        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        for (int i=0; i< senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.add(i);
            } else {
                dQueue.add(i);
            }
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.poll();
            int d = dQueue.poll();
            if (r < d) {
                rQueue.add(r+ senate.length());
            } else {
                dQueue.add(d + senate.length());
            }
        }
        if (rQueue.size() > dQueue.size()) {
            return "Radiant";
        }
        return "Dire";
    }
}
