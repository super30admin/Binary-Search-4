//Time Complexity : O(max(n,m)) n and m are lengths of the 2 Arrays
//Space Complexity : O(1)

class Solution {

    //code 2 : arrays are already sorted, use two pointers

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hm = new HashMap();

        //to ensure always the smaller array is put in hashmap
        if(nums1.length < nums2.length)
            return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> result = new ArrayList();

        int i=0; //pointer on nums1
        int j=0; //pointer on nums2

        while(i < nums1.length && j < nums2.length)
        {
            //if both elements are same, add to result and move both pointers
            if(nums1[i] == nums2[j])
            {
                result.add(nums1[i]);
                i++;
                j++;
            }
            //else move the pointer with smaller number
            else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }

        //convert to int array
        int[] answer = new int[result.size()];
        for(int k=0; k<result.size(); k++)
        {
            answer[k] = result.get(k);
        }

        //return int array
        return answer;
    }
}
