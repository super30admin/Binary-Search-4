/* Problem Statement:

https://leetcode.com/discuss/interview-question/373202

Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.

Example 1:

Input:
a = [[1, 2], [2, 4], [3, 6]]
b = [[1, 2]]
target = 7

Output: [[2, 1]]

Explanation:
There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.

Example 2:

Input:
a = [[1, 3], [2, 5], [3, 7], [4, 10]]
b = [[1, 2], [2, 3], [3, 4], [4, 5]]
target = 10

Output: [[2, 4], [3, 2]]

Explanation:
There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].

Example 3:

Input:
a = [[1, 8], [2, 7], [3, 14]]
b = [[1, 5], [2, 10], [3, 14]]
target = 20

Output: [[3, 1]]

Example 4:

Input:
a = [[1, 8], [2, 15], [3, 9]]
b = [[1, 8], [2, 11], [3, 12]]
target = 20

Output: [[1, 3], [3, 2]]


 *
 * Time Complexity : O(loga) + O(logb) + O(alogb) = O(alogb) where a is size of 1st array, b is size of 2nd array 
 * Space complexity : O(1) excluding result vector 
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector< pair<int,int> > get_valid_pairs(vector< pair<int,int> >& arr1, vector< pair<int,int> >& arr2, int target) {
        int idx = 0;
        int missing_target = 0;
        int found_target_num = 0;
        vector< pair<int,int> > result_arr;

        /* Sort the input */
        sort(arr1.begin(), arr1.end());
        sort(arr2.begin(), arr2.end());

        /* Get the value for each pair in the first array, and after subtracting the desired target, search the 
            second part in the second array values . We are trying to do nearest binary search here . */
        vector< pair<int,int> >::iterator itr1;
        for (itr1 = arr1.begin(); itr1 != arr1.end(); itr1++) {

            /* get missing target */
            missing_target = target - itr1->second;
            cout << "target: " << target << "missing: " << missing_target <<endl;

            if (missing_target != 0) {
                /* get the closest one if exact match not possible */
                found_target_num = do_binary_search(arr2,  0, arr2.size() - 1, missing_target);
                cout << "FOUND : " << found_target_num << endl;
                /* Push the result :) */
                result_arr.push_back(make_pair(itr1->first,arr2[found_target_num].first));
            }
        }
        return result_arr;
    }

    int do_binary_search(vector< pair<int,int> >& arr, int low, int high, int target) {
        int mid = 0;

        if (low <= high) {
            mid = (low + high)/2;
            if (arr[mid].second == target) {
                return mid;
            } else if (arr[mid].second > target){
                return do_binary_search(arr, low, mid - 1, target);
            } else {
                return do_binary_search(arr,  mid+1, high, target);
            }
        }
        return low;
    }

};

int main(void) {
    /* create inputs */
    int idx = 0;
    int target = 20;

    vector< pair<int,int> > vect1;
    vector< pair<int,int> > vect2;
    vector< pair<int,int> > output;
    int arr1_key[] = {3,2,1};
    int arr1_values[] = {9,15,8};

    int arr2_key[] = {3,2,1};
    int arr2_values[] = {12,11,8};

    int size = sizeof(arr2_key)/sizeof(arr2_key[0]);

    /* prepare input 1 and 2 */
    for (idx = 0; idx < size; idx++) {
        vect1.push_back(make_pair(arr1_key[idx], arr1_values[idx]));
        vect2.push_back(make_pair(arr2_key[idx], arr2_values[idx]));
    }
    /* instantiate object */
    Solution *obj = new Solution();
    /* Call for data */
    output = obj->get_valid_pairs(vect1, vect2,target);
    for (idx = 0; idx < output.size(); idx++) {
        cout << idx << " : " << output[idx].first << " " << output[idx].second << endl;
    }
    delete obj;
    return 0;
}
/* Execute on leetcode platform */


