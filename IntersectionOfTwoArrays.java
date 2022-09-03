
//#Technique1
//TC = O(m+n) Traversing the first array to add in HashMap and check the values in second array that exists or not in HashMap
//Space = O(1) we are not using any extra space here
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //if(n1>n2) return intersect(int[] nums2, int[] nums1);
        
        // Array.sort(nums1);
        // Array.sort(nums2);
        if(n1>n2) return intersect(nums2, nums1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<n1; i++){         
                 map.put(nums1[i], map.getOrDefault(nums1[i], 0) +1);  // add frequency to the HashMap
        }
        
        for(int j=0; j < n2; j++){
            if(map.containsKey(nums2[j])){
                if(map.get(nums2[j]) >0){
                    result.add(nums2[j]); 
                map.put(nums2[j], map.get(nums2[j])-1); // update frequency to the HashMap
        }
                }
                
                
            }
        }
        int [] arrayResult = new int[result.size()];
        for(int k=0; k<result.size(); k++){
            arrayResult[k] = result.get(k);
        }
        return arrayResult;
    }

}
