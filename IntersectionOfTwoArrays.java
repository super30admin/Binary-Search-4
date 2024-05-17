// Time Complexity : O(m+n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Usinh hash map approach
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) {
            return intersect(nums2, nums1);
        }

        for(int i=0;i< nums1.length;i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i],0) + 1);
        }

        for(int i=0;i< nums2.length;i++) {
            if(map.containsKey(nums2[i])) {
                li.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
                map.remove(nums2[i],0);
            }
        }
        int[] result = new int[li.size()];

        for(int i=0;i< li.size();i++){
            result[i]= li.get(i);
        }

        return result;
    }
}

// Usimh 2 pointers approach since arrays are not sorted it will take T = O(m log n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> li = new ArrayList<>();

        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2){
            return intersection(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1=0;
        int l2=0;

        while(l1 < n1 && l2 < n2) {
            if(nums1[l1] == nums2[l2] && !li.contains(nums1[l1])) {
                li.add(nums1[l1]);
            }else if(nums1[l1] > nums2[l2]) {
                l2++;
            }else {
                l1++;
            }
        }

        int[] result = new int[li.size()];

        for(int i=0;i< li.size();i++) {
            result[i] = li.get(i);
        }

        return result;
    }
}