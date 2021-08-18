// Time Complexity : O(n^2)
// Space Complexity : O(result.size)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Brute Force
//TC : O(n^2)
//SC : O(result.size) 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();
        //for each element in 1st array check if its present in 2nd array
        //if present add to a temp list
        //and make the element MIN to avoid adding it again
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    temp.add(nums2[j]);
                    nums2[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        } 
        //convert list to array
        int[] result = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}



/////////////////////////////
// Time Complexity : O(n1 + n2)
// Space Complexity : O(n1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//HashMap
//TC : O(n1 + n2)
//SC : O(n1) 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //add shorter array to hashmap
        if(n1 > n2) return intersect(nums2, nums1);
        //create temp list to add result elements
        List<Integer> temp = new ArrayList<>();   
        //number, count
        HashMap<Integer, Integer> map = new HashMap<>();
        //add shorter array to map, with count 
        for(int i = 0 ; i < n1; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }
        
        //iterate the second array and check if its present in map
        //decrese the value, if count = 0, remove
        //add to temp list
        for(int i = 0; i < n2; i++) {
            if(map.containsKey(nums2[i])) {
                temp.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
                map.remove(nums2[i], 0);
            }
        }
        
         //convert list to array and return result
        int[] result = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}



/////////////////////////////
// Time Complexity : O(n1+n2)  
// Space Complexity : O(result size) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//2 pointers : for sorted array
//TC : O(n1+n2)  
//SC : O(result size) 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //2 pointers one for each array
        int firstP = 0;
        int secondP = 0;
        //temp list for result
        List<Integer> temp = new ArrayList<>();
        while(firstP < n1 && secondP < n2) {
            //nums1[firstP] = nums2[secondP], add to temp list
            //and inc both pointers
            if(nums1[firstP] == nums2[secondP]){
                temp.add(nums1[firstP]);
                firstP++;
                secondP++;
            }
            //else inc the pointer pointer to smaller number
            else if(nums1[firstP] < nums2[secondP]){
                firstP++;
            }
            else {
               secondP++; 
            }
        }
        //convert list to array and return result
        int[] result = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;       
    }
}


/////////////////////////////
// Time Complexity : O(n1log(n2)) 
// Space Complexity : O(result size) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Binary Search : for sorted array
//TC : O(n1log(n2))  (if already sorted)
//SC : O(result size) 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //Binary search on longer array
        if(n1 > n2) return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //temp list for result
        List<Integer> temp = new ArrayList<>();
        //low in binarysearch
        int firstA = 0; 
        for(int i = 0; i < n1; i++) {
            //for each element in nums1
            int x = nums1[i];
            //call binarysearch with parameters
            //nums2 array, value x to search, and firstA (low position)
            Integer secondPos = binarySearch(nums2, x, firstA);
            //if value(position in nums2) returned is not null
            //add it to temp list and increment firstA (low) 
            //will be equal to position returned+1 (sorted array)
            if(secondPos != null) {
                temp.add(nums2[secondPos]);
                firstA = secondPos + 1;
            }         
        }       
        //convert list to array and return result
        int[] result = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;       
    }
    
    private Integer binarySearch(int[] nums2, int x, int firstA) {
        //binary search with given low value and high = length-1
        int low = firstA;
        int high = nums2.length-1;
        //check if element present
        while(low <= high) {
            int mid = low + (high-low)/2;
            //if = mid, check if prev value != mid value (repeated values)
            //if not equal return mid position
            if(nums2[mid] == x) {
                //mid should not be equal to low (while checking this condition)
                if(mid == firstA || nums2[mid] > nums2[mid-1]) return mid;
                else {high = mid-1;}
            }
            //if mid value > x, element may be present in the left side
            else if(nums2[mid] > x) {
                high = mid-1;
            }
            //else may be present in the right side
            else {
                low = mid+1;
            }
        } return null; //if element not found return null
    }
}