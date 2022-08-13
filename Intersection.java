// Time Complexity : O(m+n)
// Space Complexity : min(O(m+n),O(mlogm + nlogn))
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//2 pointer solution
public int[] intersect(int[] nums1, int[] nums2) {
    if(nums1 == null || nums1.length == 0 || nums2==null || nums2.length==0) return new int[] {};
    
    int n1 = nums1.length;
    int n2 = nums2.length;
    
    //sorting the arrays
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    //initializing the pointers
    int p1=0;
    int p2=0;
    //using list of variable size as we don't know the size of the output
    List<Integer> result = new ArrayList<>();
    
    while(p1 < n1 && p2 < n2){
        if(nums1[p1] == nums2[p2]){ // if they match, then add to the list and increase both the pointer to eliminate duplication
            result.add(nums1[p1]);
            p1++;
            p2++;
        } else if(nums1[p1] < nums2[p2]){
            p1++;
        } else{
            p2++;
        }
    }
    int[] answer = new int[result.size()];
    for(int i=0;i<result.size();i++){
        answer[i] = result.get(i);
    }
    return answer;
}

//Binary Search solution
// Time Complexity : max(O(mlogm + nlogn)/O(mlogn))
// Space Complexity : O(m)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
public int[] intersect(int[] nums1, int[] nums2) {
    if(nums1 == null || nums1.length == 0 || nums2==null || nums2.length==0) return new int[] {};
    
    int n1 = nums1.length;
    int n2 = nums2.length;
    
    if(n2 < n1){
        return intersect(nums2,nums1);
    }
    //sorting the arrays
    Arrays.sort(nums1);
    Arrays.sort(nums2);


    //using list of variable size as we don't know the size of the output
    List<Integer> result = new ArrayList<>();
    
    int low = 0;
    for(int i=0;i<nums1.length;i++){
        int bIndex = binarySearch(nums2,low,n2-1,nums1[i]); // getting the index at which it is matched
        if(bIndex != -1){
            result.add(nums1[i]);
            low=bIndex+1; // searching in the right part of the array 
        }
    }
    
    int[] answer = new int[result.size()];
    for(int i=0;i<result.size();i++){
        answer[i] = result.get(i);
    }
    return answer;
}

private int binarySearch(int[] nums, int low, int high, int target){
    while(low<=high){
        int mid = low + (high-low)/2;
        if(target == nums[mid]){
            if(mid == low || nums[mid-1]<nums[mid]){
                return mid;
            }
            high=mid-1;
        }else if(nums[mid]<target){
            low=mid+1;
        }else{
            high=mid-1;
        }
    }
    
    return -1;
}