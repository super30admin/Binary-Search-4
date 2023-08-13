//TC:o(m + n)
//SC : o(m) // smallest one
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Approach:storing smallest array with length m in hashmap(to reduce space complexity),and then checking if other arrays element is in that hashmap or not
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> nums1FreqMap = new HashMap<Integer, Integer>();
        for(int num : nums1)
        {
            // if(!nums1FreqMap.containsKey(num))
            // {
            //     nums1FreqMap.put(num,0);
            // }
            // nums1FreqMap.put(num,nums1FreqMap.get(num)+1);
            //OR
            nums1FreqMap.put(num, nums1FreqMap.getOrDefault(num,0)+1);

        }

        for(int num2 : nums2)
        {
            if(nums1FreqMap.containsKey(num2))//o(1)
            {
                result.add(num2);
                int newFreq = nums1FreqMap.get(num2)-1;
                if(newFreq == 0){
                    nums1FreqMap.remove(num2);
                }else{
                    nums1FreqMap.put(num2,newFreq);
                }
                //nums1FreqMap.remove(num2,0); // syntax check
            }
        }

        int[] finalResult = new int[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            finalResult[i] = result.get(i);
        }

        return finalResult;


    }
}