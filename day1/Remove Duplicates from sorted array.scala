object Solution {
    def removeDuplicates(nums: Array[Int]): Int = {
        var i = 0;
        var j = 0;
        var k = 0;
        while(i < nums.length) {
            while(j < nums.length && nums(j) == nums(i)) {
                j+=1;
            }

            if(j<nums.length && i<nums.length-1) {
                k = i+1;
                nums(i+1) = nums(j);
            }

            i+=1;
        }

        return k+1;
    }
}
