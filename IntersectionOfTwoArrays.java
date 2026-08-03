class Solution {
    /*
        TC - O(n + m), where n and m are the lengths of the two input arrays.
        SC - O(min(n, m)), where n and m are the lengths of the two input arrays.
        This solution uses a HashMap to store the frequency of elements from the smaller array.
        If nums1 is larger than nums2, the arrays are swapped so the HashMap stores the smaller array, reducing space usage.
        Traverse nums1 and store the count of each element in the HashMap.
        Traverse nums2:
        If the current element exists in the map, it is part of the intersection.
        Add it to the result list.
        Decrease its frequency in the map.
        Remove the key when its count becomes 0 to avoid adding it again.
        Finally, convert the result list into an integer array and return it.
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) return intersect(nums2, nums1);

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) - 1);
                list.add(num);
                map.remove(num, 0);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}