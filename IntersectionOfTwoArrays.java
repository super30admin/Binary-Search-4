

//Unsorted Array: Solutions -
// n < m

// Brute Force - TC: O(m*n), sc = O(min(m,n)) to maintain hashset of the visited indexes
// Hashing - 

// Time Complexity : O(m+n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : create a frequency map of the smaller array and check if each element from bigger array exist in map


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return intersect(nums2,nums1);

        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int n : nums1){
            freq.put(n, freq.getOrDefault(n,0)+1);
        }
        List<Integer> li = new ArrayList<>();

        for(int i = 0 ; i < n2 ; i++){
            if(freq.containsKey(nums2[i])){
                freq.put(nums2[i],freq.get(nums2[i])-1);
                li.add(nums2[i]);
                if( freq.get(nums2[i]) == 0){  
                    freq.remove(nums2[i]);
                }
            }
        }
        int[] result = new int[li.size()];
        
        for(int i = 0 ; i < li.size() ; i++){
            result[i] = li.get(i);
        }
        return result;
    }
}

//Sorted Array: n < m
// Two pointer - TC: O(m+n), SC = O(1) -  In worst case(m and n very large) this optimized
// Binary Search - 

// Time Complexity : O(nlogm)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : search the left most occurence of each number in smaller array using binary search in bigger array. Keep reducing the range size
// with each iteration of Binary Search

class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return intersect(nums2,nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        int lo = 0; int hi = n2-1;

        for(int i = 0 ; i < n1 ; i++){
            int target = nums1[i];
            int bsIdx = binarySearch(nums2, lo, hi, target);
            if(bsIdx != -1){
                li.add(target);
                lo = bsIdx+1;
            }
        }

        int[] result = new int[li.size()];
        
        for(int i = 0 ; i < li.size() ; i++){
            result[i] = li.get(i);
        }
        return result;
    }

    private int binarySearch(int[] arr , int lo, int hi, int target){
        while( lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(arr[mid] == target){
                //leftmost occurence
                if(mid == lo || arr[mid] > arr[mid-1]){
                    return mid;
                }
                else{
                    //keep moving left
                    hi = mid-1;
                }
            }
            else if(arr[mid] > target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return -1;
    }
}