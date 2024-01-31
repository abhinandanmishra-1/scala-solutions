object Solution {
    def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
        var (ind1, ind2, ind3)  = (0, 0, 0);

        var res = Array.ofDim[Int](m+n);

        while(ind1<m && ind2<n) {
            if(nums1(ind1) < nums2(ind2)) {
                res(ind3) = nums1(ind1);
                ind1+=1;
            }else {
                res(ind3) = nums2(ind2);
                ind2+=1;
            }

            ind3+=1;
        }

        while(ind1 < m) {
            res(ind3) = nums1(ind1);
            ind1+=1;
            ind3+=1;
        }

        while(ind2 < n) {
            res(ind3) = nums2(ind2);
            ind2+=1;
            ind3+=1;
        }

        Array.copy(res, 0, nums1, 0, m+n);
    }
}
