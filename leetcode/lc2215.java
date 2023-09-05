class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i: nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i : set1) {
            if (!set2.contains(i)) {
                list1.add(i);
            }
        }
        for (int i : set2) {
            if (!set1.contains(i)) {
                list2.add(i);
            }
        }
       
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        return list;
    }
}
