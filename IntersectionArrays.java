//TC : O(mlongn)
//SC : O(m)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int len = nums2.length-1;
        int loc =0;
        for(int i=0;i<nums1.length;i++){
            loc = binarySearch(nums2,loc,len,nums1[i]);
            if(loc < nums2.length && nums2[loc] == nums1[i]){
                list.add(nums1[i]);
                loc++;
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    public int binarySearch(int[] arr,int i,int j,int n){
        while(i<=j){
            int mid = i +( j-i)/2;
            if(arr[mid] >= n) j=mid-1;
            else i = mid+1;
        }
        return i;
    }
    
    /*public int[] intersect(int[] nums1, int[] nums2) {
      int first = 0, second = 0;
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      List<Integer> list = new LinkedList<>();
      while(first < nums1.length && second < nums2.length) {
          if(nums1[first] == nums2[second]) {
              list.add(nums1[first]);
              first++;
              second++;
          } else if(nums1[first] > nums2[second]) {
              second++;
          } else {
              first++;
          }
      }
      int[] result = new int[list.size()];
      int i = 0;
      for(int r: list) {
          result[i++] = r;
      }
      return result;
  }*/
    
    /*public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums1)
            map.put(i,map.getOrDefault(i,0)+1);
        List<Integer> list = new ArrayList<>();
        for(int i:nums2){
            if(map.containsKey(i)){
                int cnt = map.get(i);
                list.add(i);
                cnt--;
                if(cnt==0)
                    map.remove(i);
                else
                    map.put(i,cnt);
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }*/
}
