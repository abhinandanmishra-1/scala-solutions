object Solution {
    def bs(nums: Array[Int], target: Int, start: Int, end: Int): Int = {
        var (lo, hi) = (start, end)

        while(lo < hi) {
            var mid = lo + (hi - lo)/2

            if(nums(mid) >= target) hi = mid
            else lo = mid + 1;
        }

        if(lo<nums.length && nums(lo) == target) return lo

        -1
    }

    def search(nums: Array[Int], target: Int): Int = {
        var n = nums.length
        var (lo, hi) = (0, n-1)

        while(lo < hi) {
            var mid = lo + (hi - lo )/2;

            if(nums(mid) < nums(0)) {
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        var pivot = lo;

        if(target >= nums(0)) {
            bs(nums, target, 0, pivot)
        }else {
            bs(nums, target, pivot, n)
        }
    }
}
