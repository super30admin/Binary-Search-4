//Time Complexity    : O(n log n + m log m)  - m ,n length of arrays
//Space Compexity    : O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int ptr1 = 0,ptr2 = 0;
        
        List<Integer> li = new ArrayList<>();
        
        while(ptr1<nums1.length && ptr2<nums2.length){
            //Add to arraylist if intersecting
            if(nums1[ptr1] == nums2[ptr2]) {
                li.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
                       
            }
            //Move ptr1 ahead as it is lesser
            else if(nums1[ptr1] < nums2[ptr2]) {
                ptr1++;
            }
            else{
                ptr2++;
            }
               
        }
        
        //Convert arraylist to array
        
        int[] result = new int[li.size()]; int index = 0;
        
        for(Integer i : li){
            //System.out.println(i);
            result[index] = i;
            index++;
        }
        
        return result;
        
    }
}