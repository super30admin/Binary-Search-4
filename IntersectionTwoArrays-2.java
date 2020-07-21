
//HashMap Approach
//Time Complexity : O(m + n)
//Space Complexity: O(min(m,n));
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
       
        
        if(nums2.length > nums1.length)
            return intersect(nums2,nums1);
        
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < nums2.length ; i++){
            map.put( nums2[i], map.getOrDefault(nums2[i],0) + 1);
        }
                    
        for(int i = 0 ; i < nums1.length ; i++){
            if(map.containsKey(nums1[i])){        
                list.add(nums1[i]);
                map.put(nums1[i] ,map.get(nums1[i])-1);
                map.remove(nums1[i],0);
        
            }
        }
                    
             int[] output = new int[list.size()];       
         for(int i = 0 ; i < list.size() ;i++){
             output[i] = list.get(i);
         }           
        return output;
    }
}


//Two pointer approach
//Time Complexity : O(mlogm +nlogn) +O(Math.min(m.n))
//Space Complexity: O(1);

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
       
        
        if(nums2.length > nums1.length)
            return intersect(nums2,nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        int j = 0;
       // int k =0 ;
      int i = 0;
        while(i < n1 && j < n2){
            
            if(nums1[i] == nums2[j]){
                  list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        int[] output =  new int[list.size()];
        for( i = 0; i< list.size();i++){
            output[i] = list.get(i);
        }
        return output;
    }
}

//Binary Search approach
//Time Complexity : O(mlogm +nlogn)
//Space Complexity: O(1);
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    
        if(nums2.length > nums1.length)
            return intersect(nums2,nums1); 
      
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        int j = 0;
        
        int k = 0;
        for(int i = 0; i < nums2.length; i++){
             int res = binarySearch(nums2[i], k, nums1.length-1, nums1);
             if(res != -1){
                list.add(nums2[i]);
                k = res+1;
             }
        }
        int[] output =  new int[list.size()];
        for( int i = 0; i < list.size();i++){
            output[i] = list.get(i);
        }
        return output;
    }
    
    
    private int binarySearch(int key , int low , int high,int[] nums1){
        while(low <=  high){
            int mid = low + (high - low)/2;
            if(nums1[mid] == key){
                if(mid == low || nums1[mid-1] != nums1[mid])
                    return mid;
                else 
                    high = mid-1;
            }
            else if(nums1[mid] > key)
                high = mid -1;
            else
                low = mid +1;
        }
        return -1;
    }
}