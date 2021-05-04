//HashMap - to store the snmallest array
//then iterate over the largest array and check if there are any common values present
// Time Complexity - O(N+M) - N - length of nums1, M - length of nums2
// Space Complexity - O(Min(N,M))

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {

    if(nums1 == null || nums2 == null){
      return new int[]{0};
    }

    int n1 = nums1.length;
    int n2 = nums2.length;

    if(n2 < n1){
      return intersect(nums2, nums1);
    }

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    for(int num: nums1){
      map.put(num, map.getOrDefault(num, 0)+1);
    }
    for(int num: nums2){
      if(map.containsKey(num)){
        map.put(num, map.get(num)-1);
        result.add(num);
        map.remove(num, 0);
      }
    }

    int[] resultArr = new int[result.size()];
    for(int i=0; i<result.size(); i++){
      resultArr[i] = result.get(i);
    }

    return resultArr;
  }
}

//---------------------

//HashMap - to store the snmallest array
//then iterate over the largest array and check if there are any common values present
// Time Complexity - O(NlogN+MlogM) - N - length of nums1, M - length of nums2
// Space Complexity - O(R) - R - rest list size

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {

    if(nums1 == null || nums2 == null){
      return new int[]{0};
    }

    int n1 = nums1.length;
    int n2 = nums2.length;

    if(n2 < n1){
      return intersect(nums2, nums1);
    }

    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int index1=0, index2=0;
    List<Integer> result = new ArrayList<>();

    while(index1< n1 && index2< n2){
      if(nums1[index1] == nums2[index2]){
        result.add(nums1[index1]);
        index1++;
        index2++;
      }
      else if(nums1[index1] < nums2[index2]){
        index1++;
      }
      else{
        index2++;
      }
    }

    int[] resultArr = new int[result.size()];
    for(int i=0; i<result.size(); i++){
      resultArr[i] = result.get(i);
    }

    return resultArr;
  }
}
