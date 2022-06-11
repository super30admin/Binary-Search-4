//TC:O(m+n)- m,n are lengths of two input arrays.
//SC:O(min(m,n))
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach/**
//stored all the numbers of smaller array in a map and start traversal of the larger array .
//search the nums of it in the map and if it is present
//in map then add that to result list and resuce the freq of the num by 1;




class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       
        int m=nums1.length,n=nums2.length;
        if(n>m) return intersect(nums2,nums1);
       List<Integer>li = new ArrayList<>();
        HashMap<Integer,Integer>map =new HashMap<>();
        for(int i=0;i<n;i++){//TC:o(n),SC:O(n)
            if(map.containsKey(nums2[i])){
                map.put(nums2[i],map.get(nums2[i])+1);
            }
            else{
                map.put(nums2[i],1);
            }
        }
        
        for(int j=0;j<m;j++){
            if(map.containsKey(nums1[j]) && map.get(nums1[j])!=0){
                li.add(nums1[j]);
                map.put(nums1[j],map.get(nums1[j])-1);
            }
            
        }
        int [] arr = new int [li.size()];
        int k=0;
        for(int i=0;i<li.size();i++){
            arr[k]=li.get(i);
            k++;
        }
        return arr;
        
    }
}