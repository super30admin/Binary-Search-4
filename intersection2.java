/*
Time Complexity: O(N)
Space Complexity: O(N)
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        
        for(int i:nums1){
            if(hm.containsKey(i)){
                hm.put(i,hm.get(i)+1);
            }
            else{
            hm.put(i,1);
            }
        }
        //System.out.println(hm);
        
        for(int i:nums2){
            if(hm.containsKey(i) && hm.get(i)>0){
                hm.put(i,hm.get(i)-1);
                list.add(i);
            }
        }
        //System.out.println(hm);
        int[] ans=new int[list.size()];
        int j=0;
        for(Integer i:list){
            ans[j]=i;
            j++;
        }
        
        return ans; 
        
    }
}