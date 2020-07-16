
/*---------------------------BRUTE FORCE---------------------------------------*/
/* Time complexity:O(mn) Space Complexity:O(1) */


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result=new ArrayList();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    nums2[j]*=-1;
                    result.add(nums1[i]);
                    break;
                }
            }
        }
        int[] res=new int[result.size()];
        for(int i=0;i<res.length;i++){
            res[i]=result.get(i);
        }
        return res;
    }
}

/*------------------------------HASHMAP-------------------------------------*/
/*Time complexity:O(m+n) Space complexity:O(m)  m->smaller array */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result=new ArrayList();
        HashMap<Integer,Integer> map=new HashMap();
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        for(int i:nums1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:nums2){
            if(map.containsKey(i)){
                result.add(i);
                map.put(i,map.get(i)-1);
                map.remove(i,0);
            }
        }
        
        int[] res=new int[result.size()];
        for(int i=0;i<res.length;i++){
            res[i]=result.get(i);
        }
        return res;
    }
}

/*-------------------------------------------------------------FOLLOW-UP :IF ALREADY SORTED-----------------------------------------------------------------------------------------------*/

/*---------------------------------------------TWO-POINTERS-----------------------------------------------------------*/
/* Time Complexity:O(m+n) Space complexity:O(1) */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result=new ArrayList();
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int first=0;
        int second=0;
        while(first<nums1.length && second<nums2.length){
            if(nums1[first]==nums2[second]){
                result.add(nums1[first]);
                first++;second++;
            }
            else if(nums1[first]<nums2[second]){
                first++;
            }
            else{
                second++;
            }
        }
        int[] res=new int[result.size()];
        for(int i=0;i<res.length;i++){
            res[i]=result.get(i);
        }
        return res;
    }
}

/*-------------------------------------------------------Binary-Search-------------------------------------------------------*/
/* Time complexity:O(mlogn) Space complexity:O(1) */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result=new ArrayList();
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index=0;
        for(int i:nums1){
            int idx=binarysearch(nums2,i,index,nums2.length-1);
            if(idx!=-1){
                index=idx+1;
                result.add(i);
            }
        }
        int[] res=new int[result.size()];
        for(int i=0;i<res.length;i++){
            res[i]=result.get(i);
        }
        return res;
    }
    private int binarysearch(int[] nums, int target,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==low || nums[mid]>nums[mid-1]){
                    return mid;
                }
                else{
                    high=mid-1;
                }
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}