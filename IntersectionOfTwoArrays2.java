import java.util.*;
public class IntersectionOfTwoArrays2{

    /**
     * Using HashMap
     * Time Complexity : O(m+n) where n and m are size of arrays
     * Space Complexity : (n) where n = size of shorter array
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0)
            return new int[0];
        if(nums1==null || nums1.length==0) return nums2;
        if(nums2==null || nums2.length==0) return nums1;
        if(nums1.length==1 && nums2.length==1 && nums1[0]==nums2[0] ) 
            return new int[]{nums1[0]};
        int n1 = nums1.length; int n2 = nums2.length;
        if(n1>n2) return intersect(nums2,nums1);
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        List<Integer> li = new ArrayList<>();
        for(int num:nums2){
            if(map.containsKey(num)){
                map.put(num,map.get(num)-1);
                map.remove(num,0);
                li.add(num);
            }
        }
        int result[] = new int[li.size()];
        for(int i=0;i<li.size();i++){
            result[i] = li.get(i);
        }
        return result;
    }

    /**
     * Using Two Pointers
     * Time Complexity : O(nlogn+mlogn+m+n) where n and m are size of arrays
     * Space Complexity : O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0)
            return new int[0];
        if(nums1==null || nums1.length==0) return nums2;
        if(nums2==null || nums2.length==0) return nums1;
        if(nums1.length==1 && nums2.length==1 && nums1[0]==nums2[0] ) 
            return new int[]{nums1[0]};
        int n1 = nums1.length; int n2 = nums2.length;
        if(n1>n2) return intersect(nums2,nums1);
        Arrays.sort(nums1); Arrays.sort(nums2);
        int p1 = 0; int p2 = 0;
        List<Integer> li = new ArrayList<>();
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]==nums2[p2]){
                li.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1]>nums2[p2]){
                p2++;
            }
            else p1++;
        }
        
        int result[] = new int[li.size()];
        for(int i=0;i<li.size();i++){
            result[i] = li.get(i);
        }
        return result;
    }

    /**
     * Using Binary Search
     * Time Complexity :  O(mlogm + nlogn + mlogn)  where m is the size of shorter array and n is the size of bigger array
     * Space Complexity : O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect3(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0)
            return new int[0];
        if(nums1==null || nums1.length==0) return nums2;
        if(nums2==null || nums2.length==0) return nums1;
        if(nums1.length==1 && nums2.length==1 && nums1[0]==nums2[0] ) 
            return new int[]{nums1[0]};
        int n1 = nums1.length; int n2 = nums2.length;
        if(n1>n2) return intersect(nums2,nums1);
        Arrays.sort(nums1); Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        int index=0;
        for(int num:nums1){
            int bsIdx = binarySearch(nums2,num,index,nums2.length-1);
                if(bsIdx != -1){
                    li.add(num);
                    index = bsIdx+1;
                }        
        }
      
       
        int result[] = new int[li.size()];
        for(int i=0;i<li.size();i++){
            result[i] = li.get(i);
        }
        return result;
    }
    
    private int binarySearch(int[] nums,int target,int low,int high){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid]>nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else low = mid+1;
        }
        return -1;
    }

}