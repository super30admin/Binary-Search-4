//we can use hashmap- keep frequency of ele of smaller array, then campare larger array with hash map as we find
// ele in hashmap reduce the frequency by 1, and stor ele in new array.TC- O(m+n) SC- O(min(m,n))
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;
        
//         if(n1 > n2) return intersect(nums2, nums1);

//         HashMap<Integer, Integer> map = new HashMap<>();

//         for(int num : nums1){
//            map.put(num, map.getOrDefault(num, 0) + 1);//adding frequency to map
//         }

//         List<Integer> result = new ArrayList<>();

//         for(int num : nums2){
//             if(map.containsKey(num)){
//                 result.add(num);
//                 map.put(num, map.get(num) - 1);
//                 map.remove(num, 0);
//             }
//         }

//         int[] resultArray = new int[result.size()];
//         for(int i = 0; i < result.size(); i++){
//             resultArray[i] = result.get(i);
//         }

//         return resultArray;

     
//     }
// }



//sorted array- 2 pointer and binary search
//2 pointer approach TC- O(max(m,n))
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;

//         if(n1 > n2) return intersect(nums2, nums1);

//         Arrays.sort(nums1);
//         Arrays.sort(nums2);

//         List<Integer> result = new ArrayList<>();

//         int p1 = 0, p2 = 0;

//         while(p1 < n1 && p2 < n2){
//             if(nums1[p1] == nums2[p2]){
//                 result.add(nums1[p1]);
//                 p1++; p2++;
//             }else if(nums1[p1] < nums2[p2]){
//                 p1++;
//             }else{
//                 p2++;
//             }
//         }

//         int[] resultArray = new int[result.size()];
//         for(int i = 0; i < result.size(); i++){
//             resultArray[i] = result.get(i);
//         }

//         return resultArray;

//     }
// }

//binary search

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int low = 0, high = n2 - 1;

        for(int num : nums1){//TC- O(n1)
            int bsIndex = binarySearch(nums2, low, high, num);//TC- O(logn2)
            if(bsIndex != -1){
                result.add(num);
                low = bsIndex + 1;
            }
        }

        int[] resultArray = new int[result.size()];
        for(int i = 0; i < resultArray.length; i++){
            resultArray[i] = result.get(i);
        }

        return resultArray;

    }

    private int binarySearch( int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                if(mid == low || arr[mid] != arr[mid - 1]){
                    return mid;
                }else{
                     high = mid -1;
                }
            }else if(arr[mid] > target){
               high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;

    }
}

//follow up- we can load chunks of data and do two pointer, we can also do binary search