//TC:O(logn)log(n)
//sc:
class Solution {
    
    public static int floor(int[] a,int k)
    {
       int low = 0;
       int high = a.length-1;
        int temp=a.length;
       while(low<=high)
       {
          int mid=(low+(high-low)/2); 
          if(a[mid]>=k)
          {
             high=mid-1; 
             temp=mid; 
          }
          else if(a[mid]<k) 
          {
             low=mid+1; 
          }  
       }
      return (a.length-temp);  
    }
    
  
    public int hIndex(int[] citations)
    {
      if(citations==null||citations.length==0)   return 0;
      
        int n = citations.length;
       
        int low = 0;
        int high = n;
        int temp=0;
        while(low<=high)
        {
         int mid = low+(high-low)/2;
         int val = floor(citations,mid);
         if(val>=mid)
         {
           temp=mid;
           low=mid+1;
           //System.out.println(mid);
         }
         else
         {
          high=mid-1;    
         }      
        }
          
    return temp;    
    }
}