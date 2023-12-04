// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class IntersectionOfArrays {
    public int[] intersectByHashMap(int[] nums1, int[] nums2) {
        List<Integer> resultList = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap();
        for(int element : nums1) //O(n)
        {
            map.put(element, map.getOrDefault(element, 0)+1);
        }
        for(int element : nums2) //O(n)
        {
            if(map.containsKey(element))
            {
                resultList.add(element);
                if(map.get(element) == 1)
                    map.remove(element);
                else
                    map.put(element, map.get(element)-1);
            }
        }

        // Convert the list to an array
        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) //O(n)
        {
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }
    public int[] intersectByTwoPointers(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        List<Integer> resultList = new ArrayList();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] == nums2[j])
            {
                resultList.add(nums1[i]);
                i++; j++;
            }
            else if(nums1[i] > nums2[j])
                j++;
            else
                i++;
        }

        // Convert the list to an array
        int[] resultArr = new int[resultList.size()];
        for (int k = 0; k < resultList.size(); k++) //O(n)
        {
            resultArr[k] = resultList.get(k);
        }

        return resultArr;
    }
}
