from typing import List

class Solution:

    def longestOnes(self, nums: List[int], k: int) -> int:
        l, mx = 0, 0

        for r, n in enumerate(nums):
            print("r %d " % r)
            k -= (1-n)
            if k < 0:
                k += (1-nums[l])
                l += 1
            mx = max(mx, r-l+1)
        
        return mx
    
p1 = Solution()

val = p1.longestOnes([1,1,1,0,0,0,1,1,1,1,0], 2)

print(val)