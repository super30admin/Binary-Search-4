// both sorted - o(m log m + n log n + m log n)
// This solution sorts both the arrays. We iterate each element of smaller array and binary search for the element start index and keep adding to list
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList();
        int low = 0;
        int high = nums2.length-1;
        for(int i=0;i<nums1.length;i++) {
            int start = binary(nums2, nums1[i], low, high);
            if(start==-1) continue;
            low=start+1;
            list.add(nums1[i]);
        }
        int[] response = new int[list.size()];
        for(int i=0;i<list.size();i++) { 
            response[i] = list.get(i);
        }
        return response;
    }

    private int binary(int[] nums, int target, int i, int j) {
        while(i<=j) {
            int mid = i+(j-i)/2;
            if(nums[mid]==target) {
                if(mid==i || nums[mid]!=nums[mid-1]) return mid;
                j=mid-1;
            } else if(nums[mid]>target) {
                j=mid-1;
            } else {
                i=mid+1;
            }
        }
        return -1;
    }
}

// o(m)+o(n)+o(min(m,n))
// Map<Integer, Integer> map = new HashMap();
        // for(int i:nums1) { // o(m)
        //     map.put(i, map.getOrDefault(i, 0)+1);
        // }

        // List<Integer> list = new ArrayList();
        // for(int i:nums2) { o(n)
        //     if(map.containsKey(i)) {
        //         int val = map.get(i);
        //         list.add(i);
        //         val--;
        //         if(val==0) map.remove(i);
        //         else {
        //             map.put(i, val);
        //         }
        //     }
        // }

        // int[] response = new int[list.size()];
        // for(int i=0;i<list.size();i++) { // o(min(m,n))
        //     response[i] = list.get(i);
        // }
        // return response;
