//Accepted on LT
//Time would be O(m+n) idea is to use a hashmap
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        if(m>n){
            for(int i=0;i<n;i++){
                if(hm.containsKey(nums2[i])){
                    hm.put(nums2[i],hm.get(nums2[i])+1);
                }
                else{
                    hm.put(nums2[i],1);
                }
            }
           List<Integer> l1 = new ArrayList<>();
            for(int j=0;j<m;j++){
                if(hm.containsKey(nums1[j])){
                    if(hm.get(nums1[j])>0){
                        l1.add(nums1[j]);
                        hm.put(nums1[j],hm.get(nums1[j])-1);
                    }
                    
                }
            }
            int[] r = new int[l1.size()];
            for(int k=0;k<l1.size();k++){
                r[k] = l1.get(k);
            }
            return r;
        }
        else{
            for(int i=0;i<m;i++){
                if(hm.containsKey(nums1[i])){
                    hm.put(nums1[i],hm.get(nums1[i])+1);
                }
                else{
                    hm.put(nums1[i],1);
                }
            }
            List<Integer> l2 = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(hm.containsKey(nums2[j])){
                    if(hm.get(nums2[j])>0){
                        l2.add(nums2[j]);
                        hm.put(nums2[j],hm.get(nums2[j])-1);
                    }
                    
                }
            }
            int[] r = new int[l2.size()];
            for(int k=0;k<l2.size();k++){
                r[k] = l2.get(k);
            }
            return r;
        }


        
    }
}