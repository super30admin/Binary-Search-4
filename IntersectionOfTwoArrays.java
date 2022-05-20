//TC = O(nlogn +mlogm)
//SC = O(n+m)

import java.util.*;
public class IntersectionOfTwoArrays
{
    public static int[] intersect(int arr1[],int arr2[])
    {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0,j=0,n=arr1.length,m=arr2.length;
        ArrayList<Integer> list = new ArrayList<>();
        while(i<n && j<m)
        {
            if(arr1[i]>arr2[j])
            {
                i++;
            }
            else if(arr1[i]<arr2[j])
            {
                j++;
            }
            else
            {
                list.add(arr1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[list.size()];
        for(int k=0;k<list.size();k++)
        {
            result[k]=list.get(k);
        }

        return result;
    }


    public static void main(String args[])
    {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {1,2,3,4,4};

        int[] ans = intersect(arr1, arr2);

        for(int i:ans)
        {
            System.out.print(i+" ");
        }
    }
}