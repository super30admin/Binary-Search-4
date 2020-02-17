//Time Complexity: O(m+n) -> if array is already sorted
//                  O(m+n(log(m+n))) -> if array is not sorted
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //considering two pointers for 2 arrays
        int ptr1 = 0;
        int ptr2 = 0;
        //sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //resultantList
        List<Integer> li = new ArrayList<>();
        //till elements exists in the arrays
        while(ptr1 < nums1.length && ptr2 < nums2.length){
            //1. if pointers are equal, add to result
            //increment both pointers
            if(nums1[ptr1] == nums2[ptr2])      
            {     
                li.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            }//2. if ptr1 < ptr2; increment ptr1
            else if(nums1[ptr1] < nums2[ptr2]){
                ptr1++;
            }else{//3. if ptr2 < ptr1; increment ptr2
                ptr2++;
            }
        }
        int [] result = new int[li.size()];
        for(int i=0; i<result.length; i++){
            result[i] = li.get(i);
        }
        return result;
        
    }
}