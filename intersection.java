//Time Complexity - O(mlogm + nlogn + Min(m,n)) where m is the length of nums1 and n is the length of nums2
// Space Complexity - O(Min(m,n)) 



class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); 
        Arrays.sort(nums2);
        int ptr1 = 0;   // ptr1 for nums1
        int ptr2 = 0;   // ptr2 for nums2
        List<Integer> li = new ArrayList<>();   
        while(ptr1 < nums1.length && ptr2 < nums2.length)
        {  
            if(nums1[ptr1] == nums2[ptr2]){         //If both the elements in the two arrays are equal add to the list and move ahead both the pointers
                li.add(nums1[ptr1]);
                ptr1++;
                ptr2++;  
            }
            else if(nums1[ptr1] < nums2[ptr2])         
                ptr1++;
            else 
                ptr2++;             
        }
        int[] result = new int[li.size()];      
        for(int i=0;i<li.size();i++){
            result[i] = li.get(i);
        }
        return result;
    }
}