import java.util.*;
// m being the size of smaller array and n being the size of larger array
// Time Complexity : O(m)+O(n) to form hashmap and then traverse through bigger array to lookup in HashMap
// Space Complexity :O(m) size of the HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result= new ArrayList<>();
        if(nums1.length==0 ||nums2.length==0 || nums1==null||nums2==null)
        { return new int []{};
        }
            
    if(nums1.length>nums2.length)
        return intersect(nums2,nums1);
    
    HashMap<Integer,Integer> map= new HashMap<>();
    for(int num:nums1){
        map.put(num, map.getOrDefault(num,0)+1);
    }
    for(int i=0;i<nums2.length;i++){
        if(map.containsKey(nums2[i])){
            result.add(nums2[i]);
            map.put(nums2[i],map.get(nums2[i])-1);
            map.remove(nums2[i],0);
        }
    }
        int[] res= new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }
        return res;
}

// Time Complexity : O(m)+O(n)+O(mlogm)+ O(nlogn) to move the two pointers and sort two arrays
// Space Complexity :O(1) no extra space
public int[] intersect1(int[] nums1, int[] nums2) {
    List<Integer> result= new ArrayList<>();
    if(nums1.length==0 ||nums2.length==0 || nums1==null||nums2==null)
    { return new int []{};
    }
        
if(nums1.length>nums2.length)
    return intersect(nums2,nums1);

    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int p1=0,p2=0;

    while(p1<nums1.length && p2<nums2.length){
        if(nums1[p1]==nums2[p2]){
            result.add(nums1[p1]);
            p1++;
            p2++;
        }
        else if(nums1[p1]<nums2[p2]){
            p1++;
        }
        else{
            p2++;
        }
    }
    int[] res= new int[result.size()];
    for(int i=0;i<result.size();i++){
        res[i]=result.get(i);
    }
    return res;
}

// Time Complexity : O(mlogn)+O(mlogm)+ O(nlogn) to do do binary search of each leach elemnt of smaller array and sorting two arrays
// Space Complexity :O(1) no extra space
public int[] intersect2(int[] nums1, int[] nums2) {
    List<Integer> result= new ArrayList<>();
    if(nums1.length==0 ||nums2.length==0 || nums1==null||nums2==null){ 
        return new int []{};
    }
        
if(nums1.length>nums2.length)
    return intersect(nums2,nums1);

    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int low=0;
   for(int i=0;i<nums1.length;i++){
       int bidx=bSearch(low,nums2.length-1,nums2,nums1[i]);
       if(bidx!=-1){
           result.add(nums1[i]);
           low=bidx+1;
       }
   }
    int [] res= new int[result.size()];
    for(int i=0;i<result.size();i++){
        res[i]=result.get(i);
    }
    return res;
}
private int bSearch(int low, int high,int[]nums,int target){
    
    while(low<=high){
        int mid= low+(high-low)/2;
        if(nums[mid]==target){
        if(mid==low || nums[mid-1]<nums[mid]){
            return mid;
        }
            else
                high=mid-1;
        }
        
        else if(nums[mid]<target){
            low=mid+1;
        }
        else
            high=mid-1;
    }
    
    return -1;
}
}