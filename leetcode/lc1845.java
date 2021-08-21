
import java.util.Arrays;

class SeatManager {
    public boolean[] used;
    public int minUnres;


    public SeatManager(int n) {
        used = new boolean[n+1];
        minUnres = 1;
        Arrays.fill(used, false);

    }

    public  Integer  reserve() {

        for (int i=minUnres; i<= used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                minUnres = i+1;
                //System.out.println("res: "+ i);
                return i;

            }
        }
        return null;
    }

    public void unreserve(int seatNumber) {
        used[seatNumber] = false;
        minUnres = Integer.min(minUnres, seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
