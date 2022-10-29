// Time Complexity: O(mlogm + nlogn + nlogm) // Binary serach based approach
// Space Complexity: O(k), where k = the size of matching elemnts for resutls arraylist
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length ==0) return new int[] {};

        int n1 = nums1.length;
        int n2 = nums2.length;


        if (n2 < n1) {
            return intersect(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();

//         //HashMap based solution
//         HashMap<Integer, Integer> map = new HashMap<>();


//         //iterate and store the longer array in hashMap
//         for (int i=0; i <n1; i++) {
//             map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
//         }

//         // search for the existance of nums2[i] in the hashmap
//         for (int i =0; i < n2; i++) {
//             if (map.containsKey(nums2[i])) {
//                 result.add(nums2[i]);
//                 int cnt = map.get(nums2[i]);
//                 cnt--;
//                 if (cnt == 0) {
//                     map.remove(nums2[i]);
//                 } else {
//                     map.put(nums2[i], cnt);
//                 }
//             }
//         }
//         //two pointer based solution
//         // sort num1 and num2
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         int p1 = 0;
//         int p2 = 0;

//         while (p1 < n1 && p2 < n2) {
//             if(nums1[p1] == nums2[p2]) {
//                 result.add(nums1[p1]);
//                 p1++;
//                 p2++;
//             } else if (nums1[p1] < nums2[p2]) {
//                 p1++;
//             } else {
//                 p2++;
//             }
//         }

        // Binary Search Based Solution

        // Sort the larger array, nums2 here
        Arrays.sort(nums2);
        Arrays.sort(nums1);
        int low = 0;
        for (int i=0; i<n1; i++) {
            // perform binary search
            int index = binarySearch(nums2, low, n2-1, nums1[i]);
            if (index != -1) {
                low = index + 1;
                result.add(nums1[i]);
            }
        }

        // final result to return and convert to integer array
        int[] answer = new int[result.size()];

        for (int j=0; j<answer.length; j++) {
            answer[j] = result.get(j);
        }

        return answer;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                if (mid == low || nums[mid-1] < nums[mid]) {
                    return mid;
                }
                high = mid -1;
            } else if (target < nums[mid]) {
                high = mid -1 ;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
