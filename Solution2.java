//TC is :m(log(n)) ->m : smaller array and n is larger array
//intersection-of-two-arrays-ii
class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> li=new ArrayList<>();
        int m=nums1.length;
        int n=nums2.length;
        //We want to use binary search...so arrays should be sorted for that
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //Apply Binary search on 2nd array and target will be from 1 at array
    int low=0;
    int high=n-1;//second array index fro high
     for(int i=0;i<m;i++)
     {
         int bsIndex=BinarySearch(nums2,low,high,nums1[i]);
        if(bsIndex!=-1)
        {
            //element found in second array so add it
            li.add(nums1[i]);
            //modfify BS since we dont have to revisit already found element
            low=bsIndex+1;

        }
     }   
     int[] result=new int[li.size()];
     for(int i=0;i<li.size();i++)
     {
         result[i]=li.get(i);
     }
     return result;
}
    private int BinarySearch(int[] arr,int low,int high,int target)
{
    while(low<=high)
    {
        int mid=low+(high-low)/2;
        if(arr[mid]==target)
        {
            //check for first occurance of element then only return it saying that its found
            if(mid==low || arr[mid]>arr[mid-1])
            {
                return mid;
            }
            else
            {
                //go to right side since we have to find first occurance
                high=mid-1;
            }
        }
        else if(arr[mid]<target)
        {
            low=mid+1;
        }
        else
        {
            high=mid-1;
        }
    }
    return -1; //element not found in second array
}
}