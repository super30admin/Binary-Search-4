// Time Complexity :O(n log m)
// Space Complexity : O(1)
//n is the length of smaller array
//m is the length of larger array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Method 3
//Binary Search Solution
//TC: O(n log m) where m>n
//SC: O(1)
//n is the length of smaller array
//m is the length of larger array

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        //null check
        if(nums1 == null || nums2 == null)
            return new int[0];

        //nums2 is always smaller array
        if(nums2.length < nums1.length){
            return intersect(nums2,nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> li = new ArrayList<>();
        int low = 0;
        int high = m-1; //nums1 is larger array always

        for(int i = 0 ; i < n ; i++){
            int bIndex = binarySearch(nums1,low,high,nums2[i]);
            if(bIndex != -1){
                low = bIndex+1;
                li.add(nums2[i]);
            }
        }

        int[] result = new int[li.size()];
        for(int k = 0 ; k < result.length ; k++){
            result[k] = li.get(k);
        }
        return result;
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                //Search for the left most occurence
                if(mid == low || nums[mid-1] < nums[mid]){
                    return mid;
                }
                else{
                    high = mid -1;
                }
            }

            else if(nums[mid] < target){
                low = mid +1;
            }

            else{
                high = mid -1;
            }
        }
        return -1;
    }
}

//Method 2
//Two Pointer Solution
//TC: O(m+n)
//SC: O(1)
//n is the length of smaller array
//m is the length of larger array

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        //null check
        if(nums1 == null || nums2 == null)
            return new int[0];

        //nums2 is always smaller array
        if(nums2.length < nums1.length){
            return intersect(nums2,nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> li = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < m && j < n){
            if(nums1[i] == nums2[j]){
                li.add(nums1[i]);
                i++;
                j++;
            }
            else{
                if(nums1[i] < nums2[j]){
                    i++;
                }
                else j++;
            }
        }

        int[] result = new int[li.size()];
        for(int k = 0 ; k < result.length ; k++){
            result[k] = li.get(k);
        }
        return result;
    }
}


//Method 1
//Hashmap Solution
//TC: O(m+n)
//SC: O(n)
//n is the length of smaller array
//m is the length of larger array
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        //null check
        if(nums1 == null || nums2 == null)
            return new int[0];

        //nums2 is always smaller array
        if(nums2.length < nums1.length){
            return intersect(nums2,nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums2){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer> li = new ArrayList<>();

        for(int num : nums1){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num,map.get(num)-1);
                map.remove(num,0);
            }
        }

        int[] result = new int[li.size()];
        for(int k = 0 ; k < result.length ; k++){
            result[k] = li.get(k);
        }
        return result;
    }
}