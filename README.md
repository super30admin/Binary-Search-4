# Binary-Search-4



## Problem1 
TC : O(mlogm + nlogn)
SC : O(1)
Approach :-
1. Using a 2 pointer approach
2. I will check for the same element and if found I will add that element to the list
3. If the element in arr1 is less than arr2 then I will increase the pointer value by 1 of srr1 and vice versa

Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Always use smaller array to reduce space
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;

                while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j]){
                    list.add(nums1[i]);
                    i++;
                    j++;
                }
            }

            else if(nums1[i] < nums2[j]){
                i++;
            }

            else{
                j++;
            }
        }

        int [] res = new int[list.size()];

        for(int k = 0; k < list.size(); k++){
            res[k] = list.get(k);
        }

        return res;
    }
}


## Problem2
TC : O(log (m+n))
SC : O(1)
Approach :-
1. We will divide the array in 2 partitions and if the partition is correct we will check for the length of the array as even or odd
2. If in the left partititon the array from 1st array is less then we will do low = high+1
3. If the elements in the left half from the arr1 are more then we will do high = partX-1

Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2){ 
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0, high = n1;

        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = ((n1+n2+1)/2) - partX;

            int L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            int R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            int R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            //if the partition is correct
            if( L1 <= R2 && L2 <= R1){
                //if the length is even 
                if((n1 + n2) % 2 == 0){
                    return (Math.max(L1, L2)+Math.min(R1, R2))/2.0;
                }
                //if the length is odd
                else{
                    return Math.max(L1, L2);
                }

            }
            // we need more elements from the first half of the array
            else if(L2 > R1){
                low = partX + 1;
            }
            //we need more elements form the second half of the array
            else{
                high = partX - 1;
            }
        }

        return -1;

    }
}
