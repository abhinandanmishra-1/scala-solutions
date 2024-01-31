object Solution {
    def climbStairs(num: Int): Int = {
        var (prev, curr, next) = (0, 1, 1);
        var n = num;

        while(n > 0) {
            next = prev + curr;
            prev = curr;
            curr = next;

            n -= 1;
        }

        return curr;
    }
}
