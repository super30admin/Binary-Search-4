// Approach : Using Map and store the freq count of smaller nums and iterate through larger nums and look up in the map
// and find the intersection
// Time : O(m+n) // form map and linear scan
// Space : O(min(m,n))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2){
            return intersect(nums2,nums1);
        }
        // nums2 is smaller Array - save space for hashMap
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums2){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        // Now iterate over the nums1 (larger) array and check
        List<Integer> result = new ArrayList<>();
        for(int num:nums1){
            if(map.containsKey(num)){
                result.add(num);
                map.put(num,map.get(num)-1);
                if(map.get(num)==0){
                    map.remove(num,0);
                }
            }
        }

        int[] re = new int[result.size()];
        for(int i =0;i<result.size();i++){
            re[i]=result.get(i);
        }

        return re;
        
    }
}

// Approach : Use Two pointers. One Pointer on each nums
// Time : O(nlogn) + O(mlogm) + m+n
// Space : O(1))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2=0;
        while(p1<n1 && p2<n2){
            if(nums1[p1]==nums2[p2]){
                result.add(nums1[p1]);
                p1++;
                p2++;
            } else if(nums1[p1]<nums2[p2]){
                p1++;
            } else{
                p2++;
            }
        }
        
        int[] re = new int[result.size()];
        for(int i =0;i<result.size();i++){
            re[i] = result.get(i);
        }

        return re;
    }
}

// Approach : Using nums1 perform Binary Search on nums2 (larger Array).
// Time : O(nlogn) + (mlogm) + (m*logn)
// Space : 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2){
            return intersect(nums2,nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // go through smaller array (nums1) and perform binary search on larger array nums2
        int low = 0;
        int high = n2-1;
        for(int i =0;i<nums1.length;i++){
            int target = nums1[i];
            int bsIdx = binarySearch(nums2,low,high,target);
            if(bsIdx!=-1){
                result.add(target);
                low = bsIdx + 1;
            }
        }

        int[] re = new int[result.size()];
        for(int i =0;i<result.size();i++){
            re[i] = result.get(i);
        }

        return re;
    }
    private int binarySearch(int[] arr,int low , int high , int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                if(mid ==low || arr[mid]!= arr[mid-1]){
                    return mid ; // first occurence
                } else{
                    high = mid-1; // perform Binary Search again because we dont know how many more occurences we have
                }

            } else if(arr[mid]> target){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }

        return -1;
        
    }
}