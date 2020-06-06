//time o(nlogn) if the arrays are not sorted, o(max(m,n) if the arrays are sorted, m, n are nums1 and nums2 lengths.
//space o(1)
//Two Pointer approach
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length ==0 || nums2 == null || nums2.length == 0)
            return new int[0];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < nums1.length && ptr2 < nums2.length) {
            if(nums1[ptr1] == nums2[ptr2]) {
                res.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            }
            else if(nums1[ptr1] < nums2[ptr2]) {
                ptr1++;
            }
            else
                ptr2++;
        }
        int[] result = new int[res.size()];
        int idx = 0;
        for(int num: res) {
            result[idx++] = num;
        }
        return result;
    }
}

///time o(m) + o(n), m, n are sizes of i/p arrays 
//space o(max(m,n))
//Two Pointer approach
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length ==0 || nums2 == null || nums2.length == 0)
            return new int[0];
        List<Integer> res = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        for(int num : nums2) {
            if(map.containsKey(num))
            {
                res.add(num);
                map.put(num, map.get(num)-1);
                map.remove(num,0);
            }
        }
        int[] result = new int[res.size()];
        int idx = 0;
        for(int num: res) {
            result[idx++] = num;
        }
        return result;
    }
}


//time o(nlogm) m, n are sizes of i/p arrays 
//space o(k) if k elements are common in both arrays
//Binary Search
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length ==0 || nums2 == null || nums2.length == 0)
            return new int[0];
        List<Integer> res = new ArrayList<>();
        
        //sorting the arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        for(int i=0;i<nums1.length;i++) {
            int Bidx = binarySearch(nums2, index, nums1[i]);
            if(Bidx != -1) {
                res.add(nums1[i]);
                index = Bidx + 1;
            }
        }
        
        
        int[] result = new int[res.size()];
        int idx = 0;
        for(int num: res) {
            result[idx++] = num;
        }
        return result;
    }
    
    private int binarySearch(int[] nums, int idx, int targ) {
        int low = idx, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == targ) {
                if(mid == idx || nums[mid-1]< nums[mid]) {
                    return mid;
                }
                else {
                    high = mid-1;
                }
            }
            else if(nums[mid]>targ) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}