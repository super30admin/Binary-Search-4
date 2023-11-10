//T.C-O(m+n)
//S.C-O(min(m,n))
//passed all the test cases
//the approach is to store the elements of smaller array in a hashmap and traverse and check the another array.
//when not sorted
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            if (hm.containsKey(nums1[i])) {
                hm.put(nums1[i], hm.get(nums1[i]) + 1);
            } else {
                hm.put(nums1[i], 1);
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n2; i++) {
            if (hm.containsKey(nums2[i])) {
                al.add(nums2[i]);
                hm.put(nums2[i], hm.get(nums2[i]) - 1);
                if (hm.get(nums2[i]) == 0) {
                    hm.remove(nums2[i]);
                }
            }
        }
        int a[] = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            a[i] = al.get(i);
        }
        return a;
    }
}

// T.C-O(m+n)
// S.C-O(1)
// the approach over here is two pointer approach
// when sorted
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> al = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                al.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int a[] = new int[al.size()];
        for (int k = 0; k < al.size(); k++) {
            a[k] = al.get(k);
        }
        return a;
    }
}