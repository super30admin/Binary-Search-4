// hashmap
public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(nums1==null || nums2==null || m<0 || n<0) return null;
        if(m<n) intersect(nums2,nums1);
        HashMap<Integer,Integer> map = new HashMap<>();
        // make map of smaller array
        for(int num:nums2){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        List<Integer> li = new ArrayList<>();
        for(int num :nums1){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num, map.get(num)-1);
                map.remove(num,0);
            }
        }

        int[] result = new int[li.size()];
        for(int i=0;i<result.length;i++){
            result[i] = li.get(i);
        }
        return result;
    }
}

//TC: O(m+n)
//SC: O(n)
//n is the length of smaller array
//m is the length of larger array 

// two pointer
public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(nums1==null || nums2==null || m<0 || n<0) return null;
        if(m<n) intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        int i = 0, j = 0;
        while(i<m&&j<n){
            if(nums1[i]==nums2[j]){
                li.add(nums1[i]);
                i++;
                j++;
            }else{
                if(nums1[i]<nums2[j]) i++;
                else j++;
            }
        }        

        int[] result = new int[li.size()];
        for(int k=0;k<result.length;k++){
            result[k] = li.get(k);
        }
        return result;
    }
}

//TC: O(m+n)
//SC: O(1)
//n is the length of smaller array
//m is the length of larger array

// binary search
public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(nums1==null || nums2==null || m<0 || n<0) return null;
        if(m<n) intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        int low = 0, high = m-1;

        for(int i=0;i<n;i++){
            int bIndex = binarySearch(nums1,low,high,nums2[i]);
            if(bIndex!=-1){
                low = bIndex+1;
                li.add(nums2[i]);
            }
        }     

        int[] result = new int[li.size()];
        for(int k=0;k<result.length;k++){
            result[k] = li.get(k);
        }
        return result;
    }
    private int binarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                // search for left most occurence of that numeber
                if(mid == low || nums[mid-1]<nums[mid]){
                    return mid;
                }else{ // if its not the first occurence
                    high = mid-1; // searching towards the left for the first occurence
                }

            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}

//TC: O(n log m) where m>n
//SC: O(1)
//n is the length of smaller array
//m is the length of larger array