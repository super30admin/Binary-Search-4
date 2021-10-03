// Time Complexity : O(log(m2))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// get the binary search on each value of smallest element of any small array, then store to the result and share it.
// Your code here along with comments explaining your approach

// binary search
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList <Integer> result = new ArrayList<>();
        // null
        if( nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1); Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        if( n1 > n2 ) return intersect(nums2, nums1);
        int low = 0; int high = n2-1;
        for( int i = 0; i < n1; i++){
            int ans = binarySearch( nums2, low, high, nums1[i]);
            if( ans != -1){
                result.add(nums1[i]);
                low = ans + 1;
            }
        }
        int  [] resultArr = new int[result.size()];
        for( int i = 0; i < result.size(); i++){
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }

    private int binarySearch( int[] arr, int low, int high,int k){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == k){
                if( mid == low || arr[mid] > arr[mid-1]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if( arr[mid] > k ){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}


// Time Complexity : O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// if both the array are sorted then move the pointer whose element is smallest and move both if they are having same element
// Your code here along with comments explaining your approach

// two pointer

// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
// ArrayList <Integer> result = new ArrayList<>();
// // null
// if( nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
// Arrays.sort(nums1); Arrays.sort(nums2);
// int n1 = nums1.length;
// int n2 = nums2.length;
// if( n2 > n1 ) return intersect(nums2, nums1);
// int p1 = 0; int p2 = 0;
//      while(p1 < n1 && p2 < n2){
//          if(nums1[p1] == nums2[p2]){
//             result.add(nums1[p1]);
//             p1++; p2++;
//          }else if(nums1[p1] > nums2[p2]){
//              p2++;
//          }else{
//              p1++;
//          }
//      }
// int  [] resultArr = new int[result.size()];
// for( int i = 0; i < result.size(); i++){
//     resultArr[i] = result.get(i);
// }
// return resultArr;
//     }
// }

// Time Complexity : O(n1)
// Space Complexity :O(n1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// create an hashmap of bigger array and check if there are any values left in the small array of the new one, if yes then add it to the result.
// Your code here along with comments explaining your approach

// Using hashmap

// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//          ArrayList <Integer> result = new ArrayList<>();
//         // null
//         if( nums1 == null || nums2  == null || nums1.length == 0 || nums2.length == 0) return new int[0];
//         int n1 = nums1.length;
//         int n2 = nums2.length;
//         if(n1< n2) return intersect(nums2, nums1);
//         HashMap <Integer, Integer> hm = new HashMap<>();
//         for(int i = 0; i < n1; i++){
//             if(hm.containsKey(nums1[i])){
//                 hm.put(nums1[i],hm.get(nums1[i])+1);
//             }else{
//                 hm.put(nums1[i],1);
//             }
//         }
//         for( int i = 0; i < n2; i++){
//             if(hm.containsKey(nums2[i])){
//                 if(hm.get(nums2[i]) > 0){
//                     result.add(nums2[i]);
//                     hm.put(nums2[i],hm.get(nums2[i])-1);
//                 }
//             }
//         }
//         int [] resultArray = new int [result.size()];
//         for( int i = 0; i < result.size(); i++){
//             resultArray[i] = result.get(i);
//         }
//         return resultArray;
//     }
// }