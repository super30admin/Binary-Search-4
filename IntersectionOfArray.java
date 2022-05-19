//HashMap Approach
class Solution {

    //Time Complexity: 0(m+n) where m is the length of nums1 and n is the length of nums2
    //Space Complexity: 0(min(m,n)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //Explain your approach in short:

    public int[] intersect(int[] nums1, int[] nums2) {  //checking if nums 1 is the larger array or not and if not, making nums1 the larger array
        if(nums2.length > nums1.length){
            return intersect (nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();// creating a hashmap to store each and every no. and no. of occurences from bigger array
        List <Integer> result = new ArrayList<>(); //to store the intersection
        for(int nums : nums1){  //adding all the no's and their occurences in the hashmap
            map.put(nums, map.getOrDefault(nums, 0) + 1);
        }
        for(int nums : nums2){
            if(map.containsKey(nums)){  //cehcking if nums 2 no's are present in the hashmap or not
                result.add(nums);   //if yes, then adding it to my result and decreasing the count of occurences
                map.put(nums, map.get(nums) -1);
                map.remove(nums, 0);    //if the no. of occurence turns 0, then deleting the number
            }
        }
        int [] answer = new int[result.size()]; //converting the result to array to return
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}

//Two Pointer approach

class Solution {

    //Time Complexity:0(mlogm) + 0(nlogn)
    //Space Complexity: 0(a) where a is the intersection elements
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //Explain your approach in short:

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length > nums1.length){
            return intersect (nums2, nums1);
        }
        List <Integer> result = new ArrayList<>();
        Arrays.sort(nums1); //sorting both the arrays
        Arrays.sort(nums2);
        int p1=0, p2 = 0;   //declaring pointers to keep a track of pointer in both nums1 and nums 2
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){ //if there is an intersection, then adding it to my result and increasing both pointers
                result.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] < nums2[p2]){ //if there is no intersection and element of nums1 is smaller then increasing p1
                p1++;
            }
            else{   //if element of nums 2 is smaller then increasing nums2
                p2++;
            }
        }
        int [] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}

//Binary Search

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length > nums1.length){
            return intersect (nums2, nums1);
        }
        List <Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        int high = nums1.length - 1;    //performing a binary search on the bigger array to optimize on time
        for(int i = 0; i < nums2.length; i++){  //iterating over smaller array so save on time
            int bs = binarysearch(nums1, low, high, nums2[i]);   //calling binary search function
            if(bs != -1){   //if the element is found
                low = bs + 1;   //reducing the search space in the larger array as its a sorted array and the next intersection won't happen before the found element
                result.add(nums2[i]);   //adding the intersected element to the result
            }
        }

        int [] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    public int binarysearch(int [] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid-1]){  //checking for the leftmost occurence of the no. as the elements can be repeated
                    return mid;
                }
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}