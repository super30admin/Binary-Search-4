// 350.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //List<Integer> result = hashing(nums1, nums2);
        List<Integer> result = twoPointers(nums1, nums2);
        int[] answer = new int[result.size()];
        int index = 0;
        for(Integer num : result)
        {
            answer[index++] = num;
        }
        return answer;
    }
    
    //time - O(m + n)
    //space - O(min(m, n)) m, n are lengths of 2 input arrays
    private List<Integer> hashing(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> counts = new HashMap<>(); //counts of each number in either of ip array
        for(int num : nums1)
        {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        //iterate through other array, check if it exists in map, then update count and add to result
        for(int num : nums2)
        {
            if(counts.containsKey(num))
            {
                counts.put(num, counts.get(num) - 1);
                counts.remove(num, 0); //remove entry when count becomes 0
                result.add(num);
            }
        }
        return result;
    }
    
    //Assumption - input arrays are sorted and not counting the sorting in runtime
    //time - O(n + m)
    //space - constant
    private List<Integer> twoPointers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int cursor1 = 0;
        int cursor2 = 0;
        List<Integer> result = new ArrayList<>();
        while(cursor1 < nums1.length && cursor2 < nums2.length)
        {
            //both pointers within bounds
            if(nums1[cursor1] == nums2[cursor2]) //same element in both arrays
            {
                result.add(nums1[cursor1]); //add one copy of element to result and increase pointers
                cursor1++;
                cursor2++;
            }
            //else increment the pointer of smaller element
            else if(nums1[cursor1] < nums2[cursor2])
            {
                cursor1++; //nums1[cursor1] can never be present in nums2 because the array is sorted
            }
            else //nums2[cursor1] < nums1[cursor2]
            {
                cursor2++;
            }
        }
        return result;
    }
    
    //approach 3 - input arrays are sorted
    //for each element in nums1 check if that element is in nums2 by binary search to get O(nlogm) time
}
