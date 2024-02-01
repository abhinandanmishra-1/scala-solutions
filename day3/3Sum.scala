object Solution {
    def threeSum(nums: Array[Int]): List[List[Int]] = {
        nums.sortInPlace()

        var triplets = List[List[Int]]();
        var i = 0;
        while(i< nums.length) {
            while(i>0 && i<nums.length && nums(i) == nums(i-1)) i+=1;
            if(i >= nums.length) return triplets;
            var target = -nums(i);
            var start = i+1;
            var end = nums.length-1;

            while(start<end) {
                var sum = nums(start) + nums(end);
                if(sum == target) {
                    var triplet = List[Int](nums(i), nums(start), nums(end))
                    triplets = triplets ::: List(triplet)
                    start+=1;
                    while(start<end && nums(start) == nums(start-1)) start+=1;
                    end-=1;
                    while(end>start && nums(end) == nums(end+1)) end-=1;
                }else if(sum>target) {
                    end-=1;
                }else {
                    start+=1;
                }
            }

            i+=1;
        }

        triplets
    }
}
