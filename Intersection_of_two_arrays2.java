//Hashmap solution
//TC:  O(n+m) where n is length of nums1 , m is length of nums2
//SC:O(min(n,m)) + O(li)  ,where li is arraylist used for storing elements 
//   hashmap space + list space

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //null
        if(nums1.length ==0 || nums2.length ==0) return new int[0];
        if(nums1.length <nums2.length) return intersect(nums2,nums1);   //considering first array to be bigger one
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums2){
            map.put(num , map.getOrDefault(num,0)+1);   //creating a hashmap of smaller array
        }
        
        List<Integer> li = new ArrayList<>();
        for(int num :nums1){     //checking if ele from nums1 exists in map
            if(map.containsKey(num)){
                li.add(num);   //if it exists then add it to list
                map.put(num,map.get(num)-1);  //decraese count of that ele in map
                map.remove(num,0);   //if value becomes 0 ,then remove it from map
            }
        }
        int[] result = new int[li.size()];
        for(int i=0;i<result.length;i++){
            result[i]=li.get(i);
        }
        return result;
    }
}

//Two pointer
//TC: O(m+n) ~ O(max(m,n))  where n is length of nums1 , m is length of nums2
//SC: O(li) -> arraylist space


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //null
        if(nums1.length ==0 || nums2.length ==0) return new int[0];
        if(nums1.length <nums2.length) return intersect(nums2,nums1);  //considering first array to be bigger one
       int n= nums1.length;
        int m = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> li = new ArrayList<>();
        int  i=0,j=0;
        while(i<n && j<m){      
            if(nums1[i] == nums2[j]){   //if ele at both the ptr matched add it to list amd move ptrs
                li.add(nums1[i]);
                i++;j++;
            }else if(nums1[i]<nums2[j]){  //move the ptr with the smaller ele value
                i++;
            }else{
                j++;
            }
        }
        
        int[] result = new int[li.size()];
        for(int k=0;k<result.length;k++){
            result[k]=li.get(k);
        }
        return result;
    }
}

//Binary search
//TC: O(nlogm) where m is the length of bigger array
//SC: O(li) ;arraylist space

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //null
        if(nums1.length ==0 || nums2.length ==0) return new int[0];
        if(nums1.length <nums2.length) return intersect(nums2,nums1);
       int n= nums1.length;
        int m = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low =0;
        int high = n-1;
        
        List<Integer> li = new ArrayList<>();
        
        for(int i=0;i<m;i++){
            int bIndex = binarySearch(nums1,low , high , nums2[i]);  //search for the ele in the smaller array using binary search in bigger array
            if(bIndex != -1){
                low = bIndex+1;  //once an ele is found , move the low ptr
                li.add(nums2[i]);
            }
        }
       
        
        int[] result = new int[li.size()];
        for(int k=0;k<result.length;k++){
            result[k]=li.get(k);
        }
        return result;
    }
    
    private int binarySearch(int[] nums1 , int low , int high , int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums1[mid]==target){
                //leftmost ele
                if(mid ==low|| nums1[mid-1]<nums1[mid] ){
                    return mid;
                }else{
                    high=mid-1;
                }
            }else if(nums1[mid]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}