// Time Complexity : 0(n + m)
// Space Complexity : 0(min(n,m))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//using hashmap
class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];

        int n1 = nums1.length;
        int n2 = nums2.length;

        //if nums1 is larger then swap
        if(n1 > n2)
            intersect(nums2, nums1);
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        //create map from smaller array
        for(int i : nums1){
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        //iterate through the bigger array
        for(int num : nums2){
            //if map contains number
            if(map.containsKey(num)){
                map.put(num, map.get(num) - 1); //reduce the count of the number
                map.remove(num,0); //remove element if count is 0
                list.add(num); //add num to list
            }
        }

        //convert list to array and return
        int[] arr = new int[list.size()];

        for (int i =0; i < list.size(); i++)
            arr[i] = list.get(i);

        return arr;
    }
}

// Time Complexity : 0(nlogn + mlogm)
// Space Complexity : 0(min(n,m))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//using binary search

class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];

        int n1 = nums1.length;
        int n2 = nums2.length;

        //if nums1 is larger then swap
        if(n1 > n2)
            intersect(nums2, nums1);
        List<Integer> list = new ArrayList<>();

        //sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //iterate through smaller one & binary search on larger one
        int low = 0;
        for(int i = 0; i < n1; i++){
            //find left most occurence of matching element
            int bsIndex = binarySearch(nums2, nums1[i], low, n2-1);
            if(bsIndex != -1){
                list.add(nums1[i]);
                //shift low to bsIndex+1 as next element to find will always be greater
                low = bsIndex + 1;
            }
        }

        //convert list to array and return
        int[] arr = new int[list.size()];

        for (int i =0; i < list.size(); i++)
            arr[i] = list.get(i);

        return arr;
    }

    private int binarySearch(int[] nums, int target, int low, int high){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                //if mid is 1st element or mid is greater than mid - 1
                if(mid == low || nums[mid] > nums[mid-1])
                    return mid;
                else
                    high = mid - 1; //move to the left part
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return -1;
    }
}