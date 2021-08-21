import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] newArray = reconstructQueue(people);
        System.out.println(Arrays.deepToString(newArray));

    }

    public static int[][] reconstructQueue(int[][] people) {
        java.util.Arrays.sort(people, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(b[0], a[0]);
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        list.toArray(people);
        return people;

    }
}
