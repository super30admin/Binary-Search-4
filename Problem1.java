// Time Complexity : O(log(min(m,n)) , where m and n are the length of the array 1 and array2 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution {
    // Brute Force Solution
    /*
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map = new HashMap<>(); // element to count map
        List<Integer> list = new ArrayList<>();
        int[] result= new int[0];

        // assuming nums 1 is smaller
        for(int i=0;i<nums1.length;i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i] , 0);
            }
            map.put(nums1[i] , map.get(nums1[i]) + 1);
        }

        for(int m=0;m< nums2.length; m++){
            if(map.containsKey(nums2[m])){
                if(map.get(nums2[m]) > 0 ){
                    list.add(nums2[m]);
                    //reduce the count
                    map.put(nums2[m] , map.get(nums2[m]) - 1);
                }
            }
        }
        
        if(list.size() > 0 ){
            result = new int[list.size()];
            int i=0;
            for(Integer item : list){
                result[i++] = item;
            }
        }

        return result;
    }
    */

    // arrays sorted solution
    /*
    Follow up, when arrays already sorted

    Ignoring the complexity of sorted array
    Time : O(m+n) // if adding the sorting complexity then mlog+nlogn+(m+n) 
    Space: O(1)
        public int[] intersect(int[] nums1, int[] nums2) {
            // Assuming arrays are sorted
            // so sorting arrays
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            List<Integer> result = new ArrayList<>();
            int[] resArr= new int[0];
            
            int p1 = 0, p2=0;

            while(p1<nums1.length && p2 < nums2.length){
                if(nums1[p1] == nums2[p2]){
                    result.add(nums1[p1]);
                    p1++;
                    p2++;
                }
                else if(nums1[p1] < nums2[p2]){
                    p1++;
                }
                else{
                    p2++;
                }

            }

            if(result.size() > 0){
                resArr = new int[result.size()];
                int i=0;
                for(Integer item : result){
                    resArr[i++] = item;
                }
            }

            return resArr;
    }
    */
    // when both arrays are sorted and one's length is larger than other'
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

         int[] largeArr= new int[0];
         int[] smallArr= new int[0];

         if(nums1.length > nums2.length){
             largeArr = nums1;
             smallArr = nums2;
         }
         else{
             largeArr = nums2;
             smallArr = nums1;
         }

         int globalLow= 0;
         List<Integer> list = new ArrayList<>();
         int[] result = new int[0];
         int lPtr = 0;

         while(lPtr<smallArr.length){
             int idx = binarySearch(largeArr , smallArr[lPtr] , globalLow , largeArr.length - 1);
             if(idx == -1){
                 // it means that its not found
                 lPtr++;
             }
             else{
                 list.add(smallArr[lPtr]);
                 lPtr++;
                 globalLow = idx + 1;
             }             
         }

        if(list.size() > 0){
                result = new int[list.size()];
                int i=0;
                for(Integer item : list){
                    result[i++] = item;
                }
            }

            return result;
    }

    private int binarySearch(int[] arr , int x , int low , int high){
        int mid = low;
        while(low<=high){
            mid = low + (high -low)/2;
            if(arr[mid] == x){
                // check for the first occurance
                if(mid>0 && mid-1 >=low &&  arr[mid-1] == arr[mid]){ // If there is another occurance on the left side, then we will move on left but if have already found the occurance previlusly thant mid-1<low then we will not move left again (edge case)
                    high = mid-1; // go on the left to find the first occurance
                }
                else{
                return mid;
                }
            }
            else if (arr[mid] < x){
                low = mid+1;
            }
            else{
                high = mid - 1;
            }
        }

        return -1;
    }

}