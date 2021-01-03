public class Solution {
    public int[] Intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.Length==0||nums2.Length==0)
        {
            return new int[] {};
        }
        
        int n1 = nums1.Length;
        int n2 = nums2.Length;
        
        Array.Sort(nums1);
        Array.Sort(nums2);
        if(n1>n2)
        {
           return Intersect(nums2,nums1);
        }
        
        List<int> list = new List<int>();
        int low =0;
        foreach(int i in nums1)
        {
            int position = binarysearch(nums2,low,n2-1,i);
            if(position!=-1)
            {
                list.Add(i);
                low = position+1;
            }
        }
        
        int[] result = list.ToArray();
        return result;
    }
    
    private int binarysearch(int[] nums2,int low,int high,int target)
    {
        while(low <=high)
        {
        int mid = low + (high-low)/2;
        
        if(nums2[mid] == target)
        {
            if(low==mid || nums2[mid-1]< nums2[mid] )
            {
