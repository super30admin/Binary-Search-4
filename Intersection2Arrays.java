// Time Complexity - O(m+n) m=length of longer array; n = shorter array len
// Space Complexity - O(n)  n = shorter array len
// All approaches xecuted on leetcode
// Approach - Using HashMap
// Add all the elements in the shorter array to hashmap with key as element and value as its count
// Now traverse on the longer array check if the hashmap contains element, if yes, then decrement the count
// and add to resultant list. Remove the element if the count of the element is 0
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2) return intersect(nums2,nums1);
        List<Integer> li = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums1) {
            map.put(num,map.getOrDefault(num,0)+1);
        } 
        for(int num: nums2) {
            if(map.containsKey(num)) {
                map.put(num,map.get(num)-1);
                map.remove(num,0);
                li.add(num);
            }
        }
        int[] res = new int[li.size()];
        for(int i=0;i<res.length;i++) {
            res[i] = li.get(i);
        }
        return res;
    }
}

// Approach2 - Two Pointers
// Time Complexity - O(nlogn + mlogm + m + n)
// Space Complexity - O(1)


// Sort both the arrays. Now each element comes into its sorted positions. Hence, we traverse
// through both the arrays simultaneously and if the elements are same then add to list and increment both pointers.
// Otherwise increment pointers accordingly based on the values 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2) return intersect(nums2,nums1);
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] == nums2[p2]) {
                li.add(nums1[p1]);
                p1++;
                p2++;
            } else if(nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        int[] res = new int[li.size()];
        for(int i=0;i<res.length;i++) {
            res[i] = li.get(i);
        }
        return res;
    }
}

// Approach3 - Binary Search - Going over the shorter array and for each element in shorter array do binary search in the longer array from the index position till the end.
// Time Complexity - O(mlogm + nlogn + mlogn) ; m is the length of shorter array and n is length of longer array
// Space Complexity - O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2) return intersect(nums2,nums1);
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        for(int num:nums1) {
            int bsIndex = binarySearch(nums2, num, index, nums2.length-1);
            if(bsIndex!=-1) {
                li.add(num);
                index = bsIndex + 1;
            }
        }
        int[] res = new int[li.size()];
        for(int i=0;i<res.length;i++) {
            res[i] = li.get(i);
        }
        return res;
    }
    
    private int binarySearch(int[] nums,int target,int low, int high) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                if(mid == low || nums[mid] > nums[mid-1]) {
                    return mid;
                } else {
                    high = mid-1;
                }
            } else if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
    
}
