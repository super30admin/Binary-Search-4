/*Approach1 : if array is unsorted - using hashmap
TC: O(m+n)                                                                                   
SC: O(min(m,n))
Create a hashmap for smaller array. Iterate on bigger array. If found: append to result and decrease freq in map
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
         Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        if(n>m) intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> li = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num, map.get(num)-1);
                map.remove(num,0);
            }
        }
        int[] result = new int[li.size()];
         for(int i = 0; i<li.size(); i++){                     
            result[i] = li.get(i);                                                  
         }
        return result;
    }
}

/*Approach2 : if array is sorted
TC: O(m+n)                                                                                   
SC: O(1)
We take two pointers on each array, if the values are equal move both pointers by one, else move the pointer with smaller value by 1
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        if(n>m) intersect(nums2, nums1); // to make sure nums1 is always smaller
        int i = 0;
        int j =0;
        List<Integer> li = new ArrayList<>();
        while(i<n && j<m){
            if(nums1[i] == nums2[j]){
                li.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }                                            
        }
         int[] result = new int[li.size()];
         for(i = 0; i<li.size(); i++){                     
            result[i] = li.get(i);                                                  
         }
        return result;
    }                        
}  

/*Approach2 : if array is sorted
TC: O(mlog(n)) n is the bigger array                                                                                  
SC: O(1)
Traverse the smaller array and do binary search on the bigger array
if element is fiund during binary search, find it's first occurence and it it to the output
and then start the binary search from next element of this occurence
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        if(n>m) intersect(nums2, nums1); // to make sure nums1 is always smaller
        int low = 0;
        int high = m-1;
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i< n; i++){
            int bsIdx = binarySearch(nums2, low, high, nums1[i]);
            if(bsIdx != -1){
                li.add(nums1[i]);
                low = bsIdx + 1;
            }
        }
         int[] result = new int[li.size()];
         for(int i = 0; i<li.size(); i++){                     
            result[i] = li.get(i);                                                  
         }
        return result;
    }    
    private int binarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid]> nums[mid-1]){
                    return mid;
                }else{
                    high = mid -1;
                }
            }else if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return -1;
    }                    
} 
