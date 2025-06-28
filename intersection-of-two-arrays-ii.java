// //hashing
// //TC = O(m+n)
// //SC = O(min(m,n))
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;
//         if(n1>n2){ //keep smaller array on left
//             return intersect(nums2,nums1);
//         }
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int i = 0; i<n1; i++){
//             map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
//         }
//         List<Integer> result = new LinkedList<>();
//         for(int i=0;i<n2;i++){
//             int curr = nums2[i];
//             if(map.containsKey(curr)){
//                 result.add(curr);
//                 map.put(curr, map.get(curr)-1);
//                 map.remove(curr, 0);
//             }
//         }
//       int[] resultArray = new int[result.size()];
//       for (int k = 0; k<result.size();k++){
//         resultArray[k] = result.get(k);
//       }
//       return resultArray;
//     }
// }

// //Two pointers
// //TC = O(m+n), if arrays are alreday sorted
// //SC = 
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;
//         int i = 0, j = 0;
//         // sort both arrays
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         List<Integer> result = new LinkedList<>();
//         while(i < n1 && j < n2) {
//           // same values, add to result
//             if(nums1[i] == nums2[j]) {
//                 result.add(nums1[i]);
//                 i++;
//                 j++;
//             } else if (nums1[i] > nums2[j]) {
//                 j++;
//             } else {
//                 i++;
//           }
//       }
//       int[] resultArray = new int[result.size()];
//       for (int k = 0; k<result.size();k++){
//         resultArray[k] = result.get(k);
//       }
//       return resultArray;
//     }
// }

//Binary Search
//TC = O(mlogn), if arrays are alreday sorted
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(n1>n2){ //keep smaller array on left
            return intersect(nums2,nums1);
        }
        int low = 0;
        int high = n2-1;
        List<Integer> result = new LinkedList<>();
        for(int i=0;i<n1;i++){
            int target = nums1[i];
            int bsIndex = binarySearch(nums2, low, high, target);
            if(bsIndex != -1){
                result.add(target);
                low = bsIndex+1;
            }
        }
      int[] resultArray = new int[result.size()];
      for (int k = 0; k<result.size();k++){
        resultArray[k] = result.get(k);
      }
      return resultArray;
    }
    private int binarySearch(int []arr,int low,int high,int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                if(mid==low || arr[mid]>arr[mid-1]){
                    return mid;
                } else {
                    high = mid-1;
                }
            } else if (arr[mid]>target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}