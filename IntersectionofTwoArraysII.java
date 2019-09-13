class intersectionofTwoArraysII {
    
    // Approach 1 - Using Binary search
    // Time Complexity - O(nlogn) + O(mlogm)
    // Space complexity - O(1)
    // Tested in leetcode
    
    public int[] intersect1(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
            return new int[0];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        int index = 0;
        
        // iterate over the sorted version of first array
        // search each element of this array into the sorted version of secongd array
        for(int i=0; i<nums1.length; i++){
            int temp = search(nums2,index,nums1[i]);
            if(temp < nums2.length && nums1[i] == nums2[temp]){
                result.add(nums1[i]);
                index = temp +1;
            }
        }
  
        // Convert list into array
        int[] res = new int[result.size()];
        int p =0;
        for(Integer i : result){
            res[p++] = i;
        }
        return res;
 }
    
    // Helper method of approach 1
    public int search(int[] nums, int index, int target){
        int left = index, right= nums.length-1;
        
        // loop till leftmost index of target is found, or return left index
        while(left <= right){
            int mid = left +(right-left)/2;
            if(nums[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }
    
    
    // Approach 2 - Using HashMap
    // Time Complexity - O(n)
    // Space complexity - O(n)
    // Tested in leetcode
    
    public int[] intersect2(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
            return new int[0];
    
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int index = 0;
        
        // store elements of first array into a hashmap
        for(int element : nums1){
           map.put(element,map.getOrDefault(element,0)+1);
        }
  
        // search each element of second array from the hashmap and if found reduce count of the element into the hashmap
        // add element into the result array
        for(int toFind : nums2){
            if(map.containsKey(toFind) && map.get(toFind) > 0){
                result.add(toFind);
                map.put(toFind, map.get(toFind) -1);
            }
        }
        // Convert list into array
        int[] res = new int[result.size()];
        int p =0;
        for(Integer i : result){
            res[p++] = i;
        }
        return res;
    }
    
    
    // Approach 3 - Using two pointers
    // Time Complexity - O(nlogn) + O(mlogm)
    // Space complexity - O(1)
    // Tested in leetcode
    
    public int[] intersect3(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
            return new int[0];
        
        // Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        int index = 0;
        
        int ptr1 = 0, ptr2 = 0;
        
        while(ptr1 < nums1.length && ptr2 < nums2.length){
            // if both pointer points to elements having same value, save into result and increase both pointer.
            if(nums1[ptr1] == nums2[ptr2]){
                result.add(nums1[ptr1++]);
                ptr2++;
            }
            // increase ptr1 if pointing to an element having value lesser than the element pointed by ptr2
            else if(nums1[ptr1] < nums2[ptr2]){
                ptr1++;
            }
            else{
                ptr2++;
            }
        }
        
        // Convert list into array
        int[] res = new int[result.size()];
        int p =0;
        for(Integer i : result){
            res[p++] = i;
        }
        return res;
    }
    

}