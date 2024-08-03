class Solution {

    // Using HashMap
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     if(nums1 == null && nums2 == null) {
    //         return new int []{};
    //     }
    //     int m = nums1.length;
    //     int n = nums2.length;
    //     if(m < n) {
    //         intersect(nums2, nums1);
    //     }
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for(int i = 0; i < n; i++) {
    //         map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
    //     }
    //     List<Integer> result = new ArrayList<>();
    //     for(int i = 0; i < m; i++) {
    //         if(map.containsKey(nums1[i])) {
    //             result.add(nums1[i]);
    //             int cnt = map.get(nums1[i]);
    //             cnt--;
    //             map.put(nums1[i], cnt);
    //             map.remove(nums1[i], 0); // remove nums1[i] if value is 0
    //         }
    //     }
    //     int[] answer = new int[result.size()];
    //     for(int i = 0; i < result.size(); i++) {
    //         answer[i] = result.get(i);
    //     }
    //     return answer;
    // }

    // Using 2 pointer
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     if(nums1 == null || nums2 == null) {
    //         return new int []{};
    //     }
    //     int m = nums1.length;
    //     int n = nums2.length;
    //     List<Integer> result = new ArrayList<>();
    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);
    //     int p1 = 0;
    //     int p2 = 0;
    //     while(p1 < m && p2 < n) {
    //         if(nums1[p1] == nums2[p2]) {
    //             result.add(nums1[p1]);
    //             p1++;
    //             p2++;
    //         } else if(nums1[p1] > nums2[p2]) {
    //             p2++;
    //         } else {
    //             p1++;
    //         }
    //     }
    //     int[] answer = new int[result.size()];
    //     for(int i = 0; i < result.size(); i++) {
    //         answer[i] = result.get(i);
    //     }
    //     return answer;
    // }

    // Using Binary Search
    public int[] intersect(int[] nums1, int[] nums2) { 
        if(nums1 == null || nums2 == null) {
            return new int[] {};
        }
        int m = nums1.length;
        int n = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(m < n) {
            intersect(nums2, nums1);
        }
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = n - 1;
        for(int i = 0; i < m; i++) {
            int target = nums1[i];
            int bsIndex = binarySearch(nums2, low, high, target);
            if(bsIndex != -1) {
                result.add(nums1[i]);
                low = bsIndex + 1;
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == low || nums[mid - 1] != target) {
                    return mid;
                } 
                high = mid - 1;
            } else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
