//https://leetcode.com/problems/intersection-of-two-arrays-ii/
// Time Complexity : O(mlogn) m<n
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int[] intersect(int[] num1, int[] num2) {
        
        if(num1==null && num2==null) return new int[]{};
        if(num1==null) return num2;
        if(num2==null) return num1;
        if(num2.length<num1.length) return intersect(num2,num1);
        return map_sol(num1,num2);
        
    }
    private int[] map_sol(int[] num1,int[] num2)
    {
        ArrayList<Integer> output=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<num1.length;i++) //traversing the least length array and create frequency map
        {
            if(!map.containsKey(num1[i]))
                map.put(num1[i],0);
            map.put(num1[i],map.get(num1[i])+1);
        }
        for(int i=0;i<num2.length;i++)
        {
            if(map.containsKey(num2[i]))
            {
                output.add(num2[i]);
                map.put(num2[i],map.get(num2[i])-1); //once the element is found reduce the frequency when frequency becomes zero remove it from the map
                if(map.get(num2[i])==0)
                    map.remove(num2[i]);
            }
        }
        int[] arr = new int[output.size()];
  
        // ArrayList to Array Conversion
        for (int i = 0; i < output.size(); i++)
            arr[i] = output.get(i);
        return arr;
    }
}