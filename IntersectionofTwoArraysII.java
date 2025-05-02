import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//hashmap 
/*
class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
      int m=nums1.length;
      int n=nums2.length;
      if(m>n){
          return intersect(nums2,nums1);
      }
      Map<Integer,Integer> map=new HashMap<>();
      for(int num:nums1){
          map.put(num, map.getOrDefault(num,0)+1);
      }
      List<Integer> res=new ArrayList<>();
      for(int num:nums2){
          if(map.containsKey(num)){
              res.add(num);
              map.put(num,map.get(num)-1);
              map.remove(num,0);
          }
      }
      int[] re=new int[res.size()];
      for(int i=0;i<res.size();i++){
          re[i]=res.get(i);
      }
      return re;
  }
}
*/

/*

//2 pointer
class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
      int m=nums1.length;
      int n=nums2.length;
      if(m>n){
          return intersect(nums2,nums1);
      }
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      List<Integer> res=new ArrayList<>();
      int p1=0;
      int p2=0;
      while(p1<m && p2<n){
          if(nums1[p1]==nums2[p2]){
              res.add(nums1[p1]);
              p1++;
              p2++;
          }else if(nums1[p1]>nums2[p2]){
              p2++;
          }else{
              p1++;
          }
      }
      int[] re=new int[res.size()];
      for(int i=0;i<res.size();i++){
          re[i]=res.get(i);
      }
      return re;
  }
}

*/

//binary search
//Ans to 3

//TC:O( mlogn)
//SC: O(1)
class IntersectionofTwoArraysII {
  public int[] intersect(int[] nums1, int[] nums2) {
      int m=nums1.length;
      int n=nums2.length;
      if(m>n){
          return intersect(nums2,nums1);
      }
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      int l=0;
      int r=n-1;
      List<Integer> res=new ArrayList<>();
      for(int i=0;i<m;i++){
          int ind=binarysearch(nums2,nums1[i],l,r);
          if(ind!=-1){
              res.add(nums1[i]);
              l=ind+1;
          }
      }
      int[] re=new int[res.size()];
      for(int i=0;i<res.size();i++){
          re[i]=res.get(i);
      }
      return re;
  }

  private int binarysearch(int[] arr, int target, int low, int high){
      while(low<=high){
          int mid=low+(high-low)/2;
          if(arr[mid]==target){
              //check if it is left most
              if(mid==low || arr[mid]>arr[mid-1]){
                  return mid;
              }else{
                  high=mid-1;
              }
          }else if(arr[mid]>target){
              high=mid-1;
          }else{
              low=mid+1;
          }
      }
      return -1;
  }
}
