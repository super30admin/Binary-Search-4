class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
        return intersect(nums2, nums1);
    }
    HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ll = new ArrayList<>();
    for (int n : nums1) {
        map.put(n, map.getOrDefault(n, 0) + 1);
    }
    int k = 0;
    for (int n : nums2) {
        int el= n;
        if(map.containsKey(el)){
            ll.add(el);
            map.put(el,map.get(el)-1);
            map.remove(el,0);
        }
    }
        int [] result = new int[ll.size()];
        for(int i=0; i<result.length ; i++){
            result[i]= ll.get(i);
        }
        return result;
}
}
//Time complexity-  O(n+m)
//space complexity- O(m) // m is the smaller array

//Two pointers

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
        return intersect(nums2, nums1);
    }
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int p1=0; int p2=0;
        List<Integer> ll = new ArrayList<>();
        while(p1<nums1.length && p2< nums2.length){
            if(nums1[p1] == nums2[p2]){
                ll.add(nums1[p1]);
                p1++; p2++;
            }
            else if(nums1[p1]< nums2[p2]) p1++;
            else p2++;
        }
        
        int [] result = new int[ll.size()];
        for(int i=0; i<result.length ; i++){
            result[i]= ll.get(i);
        }
        return result;
    }
}

//Time complexity- O(n log m)  
//space complexity- O(n +m) 

//binary Search

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
        return intersect(nums2, nums1);
    }
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int low=0; int high = nums2.length-1;
        List<Integer> ll = new ArrayList<>();
        for(int i=0; i< nums1.length; i++){
            int targ = nums1[i];
            int bIndex= binarySearch(nums2, low, nums2.length-1, targ);
            if(bIndex != -1){
                ll.add(targ);
                low=bIndex+1;
            }
        }
        int [] result = new int[ll.size()];
        for(int i=0; i<result.length ; i++){
            result[i]= ll.get(i);
        }
        return result;
    }
    private int binarySearch(int [] arr, int low, int high, int target){
        while(low <= high){
            int mid = low+ (high-low)/2;
            if(arr[mid]==target){
                if(mid ==low || arr[mid] != arr[mid-1]){
                    return mid ;
                }    
                else high= mid-1;
            }
            else if(arr[mid] > target) high= mid-1;
            else low= mid+1;
        }
        return -1;
    }
}

//Time complexity- O(n log m)  
//space complexity- O(n +m) 

 