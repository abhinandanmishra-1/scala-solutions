object Solution {
    def searchInsert(nums: Array[Int], target: Int): Int = {
       @annotation.tailrec
       def binarySearch(low: Int, high: Int) : Int = {
           if(low>high) {
               low
           }else {
               var mid = low + (high - low)/2;

               nums(mid) match {
                   case elem if elem == target => mid
                   case elem if elem < target => binarySearch(mid+1, high)
                   case _ => binarySearch(low, mid-1);
               }
           }
       }

       binarySearch(0, nums.length - 1)
    }
}
