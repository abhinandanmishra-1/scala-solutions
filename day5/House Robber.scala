object Solution {
    def rob(nums: Array[Int]): Int = {
        // 0 0 1 2 3 1
        var prev_robbed = 0
        var max_robbed = 0

        for(i <- 0 until nums.length) {
            var curr_robbed = nums(i) + prev_robbed
            prev_robbed = max_robbed;

            if(curr_robbed > max_robbed) {
                max_robbed = curr_robbed
            }
        }

        return max_robbed;
    } 
}
