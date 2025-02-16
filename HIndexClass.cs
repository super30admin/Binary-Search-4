// TC ==> O(n)
// SC ==> O(1)

public class Solution
{
    public int HIndex(int[] citations)
    {
        if (citations == null || citations.Length == 0)
        {
            return 0;
        }

        int n = citations.Length;
        for (int i = 0; i < n; i++)
        {
            if (n - i <= citations[i])
            {
                return n - i;
            }
        }
        return 0;
    }
}