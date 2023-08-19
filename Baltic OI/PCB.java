import java.io.*;
import java.util.*;
 
public class PCB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
 
        //finding the LIS of a reversed array = finding the LDS
        int ans = 0;
        TreeSet<Integer> lis = new TreeSet<>();
        for (int i : map.values()) {
            if (lis.higher(i) == null) {
                ans++;
            }
            else {
                lis.remove(lis.higher(i));
            }
            lis.add(i);
        }
 
        System.out.println(ans);
    }
}
