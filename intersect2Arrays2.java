// Time Complexity: O(mlog k) where k is Max(nums1.length,nums2.length) and m is Min(nums1.length,nums2.length)
//Space Complexity: O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length; int n2 = nums2.length;
        
        if(n1 > n2) return intersect(nums2, nums1);
        Arrays.sort(nums1);Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        int low=0; int high = n2-1;
        for(int i=0; i<n1; i++){
            int curr = nums1[i];
            int index = binarySearch(nums2, low,high,curr);
            if(index != -1){
                result.add(curr);
                low = index + 1;
            }
        }
        
        int[] temp = new int[result.size()];
        for(int i=0; i< temp.length; i++){
            temp[i] = result.get(i);
        }
        
        return temp;
    }
    
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                if(low == mid || arr[mid] > arr[mid - 1]){
                    return mid;
                } else {
                    high = mid -1;
                }
            } else if(arr[mid] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return -1;
    }
}

// Time Complexity: O(m+n)
//Space Complexity: O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length; int n2 = nums2.length;
        
        if(n1 > n2) return intersect(nums2, nums1);
        Arrays.sort(nums1);Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        
        int p1=0;int p2=0;
        
        while(p1 < n1 && p2 < n2){
            if(nums1[p1] == nums2[p2]){
                result.add(nums1[p1]);
                p1++;p2++;
            } else if(nums1[p1] < nums2[p2]){
                p1++;
            } else{
                p2++;
            }
        }
        
        int[] temp = new int[result.size()];
        for(int i=0; i< temp.length; i++){
            temp[i] = result.get(i);
        }
        
        return temp;
    }
}

// Time Complexity: O(m+n)
//Space Complexity: O(k) where k is Min(nums1.length,nums2.length)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length; int n2 = nums2.length;
        
        if(n1 > n2) return intersect(nums2, nums1);
        
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums1){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        
        for(int num: nums2){
            if(map.containsKey(num)){
                result.add(num);
                map.put(num,map.get(num) - 1);
                map.remove(num,0);
            }
        }
        
        int[] temp = new int[result.size()];
        for(int i=0; i< temp.length; i++){
            temp[i] = result.get(i);
        }
        
        return temp;
    }
}