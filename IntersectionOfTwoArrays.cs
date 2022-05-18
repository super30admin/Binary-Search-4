
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach




//O(m+n) - Hasmap solution
public int[] Intersect(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums1.Length == 0 || nums2 == null || nums2.Length == 0)
            return new int[0];
        
        var result = new List<int>();
        
        if(nums2.Length < nums1.Length)
            return Intersect(nums2, nums1);
        Dictionary<int, int> dict = new Dictionary<int, int>();
        
        foreach(int num1 in nums1)
        {
            if(dict.ContainsKey(num1))                
                dict[num1] = dict[num1] + 1;
            else
                dict[num1] = 1;
        }
        
        foreach(int num2 in nums2)
        {
            if(dict.ContainsKey(num2))
            {
                result.Add(num2);
                dict[num2] = dict[num2] - 1;
                if(dict[num2] == 0)
                    dict.Remove(num2);
            }
        }
        
        return result.ToArray();
    }    



//O(nlogn) sorting both arrays and comparing both one by one
public int[] Intersect(int[] nums1, int[] nums2) {

        if(nums1 == null || nums1.Length == 0 || nums2 == null || nums2.Length == 0)
            return new int[0];

        var result = new List<int>();

        if(nums2.Length < nums1.Length)
            return Intersect(nums2, nums1);
       
        Array.Sort(nums1);
        Array.Sort(nums2);
        int n1 = 0, n2 = 0;

        while(n1 < nums1.Length && n2.nums.Length)
        {
            if(nums1[n1] == nums2[n2]){
                result.Add(nums[n1]);
                n1++;
                n2++;                
            }
            else if(nums1[n1] < nums[n2])
                n1++;
            else
                n2++;
        }
    }