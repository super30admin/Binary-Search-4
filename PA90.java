//Leetcode 350. Intersection of Two Arrays II
//Time Complexity: O(m+n) //  m is length of nums1 and nums2 is length of nums2
//Space Complexity: O(m+n) // Size of the list and hashmap in worst case 

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int n: nums1){
            hm.put(n, hm.getOrDefault(n,0)+1);
        }
        
        List<Integer> res= new ArrayList<>();
        for(int n: nums2){
            if(hm.containsKey(n) && hm.get(n)>0){       
                
                    res.add(n);         
                    hm.put(n,hm.get(n)-1);
                
            }
        }
        int[] result = new int[res.size()];
        for(int i=0; i<res.size();i++){
            result[i]= res.get(i);
        }
        return result;
    }
}
//-------------------------------------------------------------------------

Followup solution: if both the arrays are sorted
Time Complexity: O(m+n) //  m is length of nums1 and nums2 is length of nums2
Space Complexity: O(m+n) // Size of the list in worst case 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       Arrays.sort(nums1);
       Arrays.sort(nums2);
        List<Integer> res= new ArrayList<>();
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] ==nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
                
            }
            else if(nums1[i]<nums2[j]) i++;
            else j++;
        }
        int[] result = new int[res.size()];
        for(int n=0;n<res.size();n++){
            result[n] = res.get(n);
        }
        return result;
    }
}