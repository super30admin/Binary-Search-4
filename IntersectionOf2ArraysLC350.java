class Solution {

    //Binary Search Approarch, if arrays are sorted
    //Time Complexity: O(m*log(n)), m = length of nums1, n = length of nums2
    //Space Complexity: O(1)

    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length) return intersect(nums2, nums1);                     //check if the nums1 is greater than nums2, if so, then call the function again as nums1=nums2 and nums2 = nums1

        Arrays.sort(nums1);                                         //sort both arrays
        Arrays.sort(nums2);

        int low = 0;                                                //low pointer
        int high = nums2.length-1;                                  //high pointer

        List<Integer> list = new ArrayList<>(); // < O(m) Space         //to store results

        for(int i=0; i<nums1.length; i++){                                  //iterate through nums1 array

            int bsIndex = binarySearch(nums2, low, high, nums1[i]);         //call the binarysearch function on nums2 array with target nums1[i]

            if(bsIndex != -1){                                              //check if bsIndex is not -1, means we find the nums1 element into nums2 array
                list.add(nums1[i]);                                         //add element into list
                low = bsIndex + 1;                                          //update the low pointer to bsIndex+1, as we sorted both arrays, and if we find element, then next element would be from next index
            }
        }

        int[] result = new int[list.size()];                                //create result array

        for(int i=0; i<result.length; i++){                                 //iterate through list and add element into array
            result[i] = list.get(i);
        }
        return result;                                                      //return the result
    }


    private int binarySearch(int[] nums, int low, int high, int target){

        while(low <= high){                                             //iterate till low<=high

            int mid = low + (high -low)/2;                              //get the mid index

            if(nums[mid] == target){                                    //check if the mid index element is equal to target or not

                if(mid == low || nums[mid] != nums[mid-1]){             //if it's target then, check if mid==low or check if the nums[mid-1]!=nums[mid] (as we have to return the first index of that number)
                    return mid;                                         //return mid
                }
                else{
                    high = mid - 1;                                     //otherwise, update = mid-1
                }
            }
            else if(nums[mid] > target){                                //if nums[mid]>target, means we overshoot
                high = mid -1;                                          //update high
            }
            else{                                                       //means we undershoot
                low = mid + 1;                                          //update low
            }
        }
        return -1;                                                      //means we couldn't find that element, so return -1
    }






    //Two Pointer Approach, if array is sorted
    //Time Complexity: O(m+n), m = length of nums1, n = length of nums2
    //Space Complexity: O(1)

//     public int[] intersect(int[] nums1, int[] nums2) {

//         Arrays.sort(nums1); //can't consider in time complexity, as it given in the follow up question
//         Arrays.sort(nums2);

//         int p1 = 0;
//         int p2 = 0;

//         List<Integer> list = new ArrayList<>(); // < O(m) Space

//         while(p1 < nums1.length && p2 < nums2.length){

//             if(nums1[p1] == nums2[p2]){
//                 list.add(nums1[p1]);
//                 p1++;
//                 p2++;
//             }
//             else if(nums1[p1] < nums2[p2]){
//                 p1++;
//             }
//             else{
//                 p2++;
//             }
//         }

//         int[] result = new int[list.size()];

//         for(int i=0; i<result.length; i++){
//             result[i] = list.get(i);
//         }
//         return result;
//     }




    //HashMap Approach, if array is not sorted
    //Time Complexity: O(m+n), m = length of nums1, n = length of nums2
    //Space Complexity: O(min(m, n))

//     public int[] intersect(int[] nums1, int[] nums2) {

//         if(nums1.length > nums2.length) return intersect(nums2, nums1);

//         Map<Integer,Integer> map=new HashMap<>();

//         for(int i=0;i<nums1.length;i++){

//             map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
//         }

//        List<Integer> list=new ArrayList<>();

//         for(int num: nums2){

//             if(map.containsKey(num)){

//                 list.add(num);
//                 map.put(num, map.get(num) - 1);
//                 map.remove(num, 0);
//             }
//         }

//         int[] result = new int[list.size()];

//         for(int i=0;i<result.length;i++){
//             result[i] = list.get(i);
//         }
//         return result;
//     }
}


public class IntersectionOf2ArraysLC350 {
}
