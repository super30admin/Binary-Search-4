// Time Complexity : O(NLogN + MLogM)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : after class solution


// Your code here along with comments explaining your approach
//We sort the arrays at first.
//Then we iterate in single while loop over both the arrays.
	//a) If match found, then we add the matched result to the solution and increment counter for both the arrays.
	//b) Else, if nums1 is less then we increment the counter of nums1 (array with lower value)
	//c) ELse, nums2's counter is incremented

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        //sort both the arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        //counters for both the arrays
        int i=0, j = 0;
        
        List<Integer> solution = new ArrayList<>();
        
        //iterate over both the arrays
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){ // match found
                System.out.println(i);
               solution.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){ // nums2 having lower value, so increment it's counter
                j++;
            }else{ // else, increment nums1's counter
                i++;
            }
                
        }
        
        int[] result = new int[solution.size()];
        
        for(i=0; i<solution.size(); i++){
            result[i] = solution.get(i);
        }
        return result;
    }

    //=============================================================================

// Time Complexity : O(m+n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : after class solution


// Your code here along with comments explaining your approach

//We use hashmap to store the smaller array and it's count of occurances of each element.
//Then we iterate over the larger array to find if there is match in element.
//If yes, then we add it to the solution list and decrement the count of the element in the hashmap.    

    class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        ///base check
        if(nums1 == null || nums2 == null) return new int[0];
        
        int n = nums1.length;
        int m = nums2.length;
        
        if(n > m){
           return intersect(nums2, nums1); 
        }
        
        //initialize a hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> solution = new ArrayList<>();
                
        for(int i: nums1){
            if(!map.containsKey(i)){
                    map.put(i, 1);
                }else{
                    map.put(i, map.get(i) + 1);
                }
            }
        
        for(int i: nums2){
            System.out.println(i + "===");
            if(map.containsKey(i) && map.get(i) > 0){
                //System.out.println(i);
                solution.add(i);
                System.out.println(solution);
                map.put(i, map.get(i)-1);
            }
        }
        
        int[] result = new int[solution.size()];
        int j = 0;
        for(int i: solution){
            result[j] = i;
            j++;
        }
        
        return result;
    }
}
}