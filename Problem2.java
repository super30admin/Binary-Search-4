class Solution {
    /*
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        if (nums1.length > nums2.length)
            intersect(nums2,nums1);
        for (int num: nums1) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
            
    
    List<Integer> output = new ArrayList<>(); 
    for (int num: nums2) {
        if(map.containsKey(num)) {
            if(map.get(num) - 1 >= 0) {
                map.put(num,map.get(num)-1);
                output.add(num);
            }
            
        }
    }
    
    int[] out = new int[output.size()];
    for(int i = 0 ;i < output.size();i++)
        out[i] = output.get(i);
    return out;
}
    */
    //Time Complexity: O(mlogm + nlogn)
    //Space Complexity: O(min(m,n)) m - length of arr1 n - length of arr 2
    
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length) return intersect(nums2,nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> output = new ArrayList<>(); 
        int index = 0;
        int high = nums2.length - 1;
        int count = 0;
        for(int num: nums1) {
            int idx = bSearch(nums2,index,high,num);
            count++;
            if(idx!= -1) {
                //System.out.print(num+"\t"+idx+"\t" + count);
                index = idx + 1;
                output.add(num);
                }
            //System.out.println();
        }
        int[] out = new int[output.size()];
        for(int i = 0 ;i < output.size();i++)
            out[i] = output.get(i);
        
        return out;
    }
    
    private int bSearch(int[] arr,int low,int high, int num) {
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(arr[mid] == num) {
                if(mid == low || arr[mid -1] != num) {
                    
                    return mid;
                }
                else
                    high = mid - 1;
            }
            else if (arr[mid] < num)
                low = mid +1;
            else
                high = mid - 1;
        }
        
        return -1;
    }
}

