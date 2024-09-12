//TC: O(n+m)
//SC: O(n), where n is the length of the smaller array
//Using HashMap
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> list = new ArrayList();
        for(int num : nums2){
            if(map.containsKey(num)){
                list.add(num);
                map.put(num, map.get(num)-1);
                if(map.get(num) == 0) map.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}

//Using Two Pointers
//TC: O(n log(n)), if sorting is considered,  O(m+n), if arrays are already sorted
//SC: O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        
        int i = 0; int j = 0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++; j++;
            }
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        
        int[] res = new int[list.size()];
        for(int k = 0; k < list.size(); k++){
            res[k] = list.get(k);
        }
        return res;
    }
}

//Using Binary Search
//TC: O(n * log(m)), if arrays are already sorted, n is the length of smaller array
//SC: O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList();
        int index = 0;
        for(int i = 0; i < nums1.length; i++){
            int bsIndex = binarySearch(nums2, index, nums2.length-1, nums1[i]);
            if(bsIndex != -1){
                list.add(nums1[i]);
                index = bsIndex + 1;
            }
        }
        
        int[] res = new int[list.size()];
        for(int k = 0; k < list.size(); k++){
            res[k] = list.get(k);
        }
        return res;
    }
    
    private int binarySearch(int[] arr, int low, int high, int num){
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(arr[mid] == num) {
                if(mid == low || arr[mid-1] < arr[mid]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if(arr[mid] > num){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
