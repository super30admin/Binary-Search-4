//Time Complexity:- m+ logn
//Space Complexity: o(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        //binarySearch
         List<Integer> li = new ArrayList<>();
         if(nums1.length> nums2.length) return intersect(nums2, nums1);  
         Arrays.sort(nums2);
         Arrays.sort(nums1);
        int low = 0;
        int high = nums2.length-1;
        for(int i = 0;i < nums1.length;i++){
            int res = binarySeach(nums2,low,high,nums1[i]);
            if(res != -1){
                li.add(nums2[res]);
                low = res+1;
            }
            
            
        }
        int[] result = new int[li.size()];
        for(int i  = 0;i< li.size();i++){
            result[i] = li.get(i);
        }
        
     return result;   
    }

    
    private int binarySeach(int[] nums2, int low, int high, int target)
    {
         while(low<= high)
             {
                 int mid = low+ (high - low)/2;
                 if(target == nums2[mid])
                 {
                     if(mid != low && nums2[mid] == nums2[mid -1])
                     {
                        high = mid -1;
                     }
                     else
                     {
                        return mid;
                     }
                     
                 }
                 else if(target < nums2[mid])
                 {
                     high = mid-1;
                 }
                 else{
                     low = mid + 1;
                 }
                 
             }
        
        return -1;
        
    }
    
    
}



//         List<Integer> li = new ArrayList<>();
//         if(nums1.length> nums2.length) return intersect(nums2, nums1);
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i = 0;i< nums1.length;i++)
//         {
//             map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
//         }
//         for(int i =0;i<nums2.length;i++)
//         {
//             if(map.containsKey(nums2[i]))
//             {
//                 li.add(nums2[i]); 
//                 map.put(nums2[i], map.get(nums2[i])-1);
//                 map.remove(nums2[i],0);
                
//             }
//         }
        
//         int[] arr = new int[li.size()];
        
//         for(int j = 0;j<li.size();j++)
//         {
//            arr[j] = li.get(j); 
//         }
//         return arr;