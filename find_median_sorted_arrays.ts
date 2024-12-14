import { number } from "yargs";

function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
  let m = nums1.length; // Shortest array
  let n = nums2.length;

  if (m > n) return findMedianSortedArrays(nums2, nums1);

  function getPartitionOnY(partX: number) {
    return (m + n) / 2 - partX;
  }

  function getValuesAtPartition(
    partX: number,
    partY: number
  ): [number, number, number, number] {
    let l1 =
      partX == 0 
        ? Number.MIN_SAFE_INTEGER
        : nums1[partX - 1]
    let r1 =
      partX == nums1.length
        ? Number.MAX_SAFE_INTEGER
        : nums1[partX]

    let l2 =
      partY == 0 
        ? Number.MIN_SAFE_INTEGER
        : nums2[partY - 1]
    let r2 =
      partY == nums2.length
        ? Number.MAX_SAFE_INTEGER
        : nums2[partY]

    return [l1, l2, r1, r2];
  }

  // Binary Search On Shortest Array
  let left = 0;
  let right = m;
  while (left <= right) {
    let mid = Math.floor(left + (right - left) / 2);
    let partitionAtY = Math.floor(getPartitionOnY(mid));
    let valuesAtPartition = getValuesAtPartition(mid, partitionAtY);
    let l1 = valuesAtPartition[0];
    let l2 = valuesAtPartition[1];
    let r1 = valuesAtPartition[2];
    let r2 = valuesAtPartition[3];

    if (l1 <= r2 && l2 <= r1) {
      // We are at the correct partition
      let isEven = (m + n) % 2 == 0;
      if (isEven) {
        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
      } else {
        return Math.min(r2, r1);
      }
    } else {
      if (l2 > r1) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
  }
  return 0;
}

describe("4. Median of Two Sorted Arrays", () => {
  it("Happy Path - 01", () => {
    expect(findMedianSortedArrays([1, 3], [2])).toEqual(2);
  });
  it("Happy Path - 02", () => {
    expect(findMedianSortedArrays([1, 5, 9, 10, 15], [2, 3, 6, 7, 11])).toEqual(
      6.5
    );
  });
  it("Happy Path - 03", () => {
    expect(findMedianSortedArrays([1, 2], [3, 4])).toEqual(2.5);
  });
  it("Negative", () => {
    expect(findMedianSortedArrays([], [1])).toEqual(1);
  });
});
