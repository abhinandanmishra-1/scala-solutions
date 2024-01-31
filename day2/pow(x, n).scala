object Solution {
    def myPow(x: Double, n: Int): Double = {
        var a = x;
        var b = n.toLong;
        if(b<0) {
            b= -1*b;
            a= 1.0/a;
        }

        var res = 1.0;
        while(b>0) {
            if(b%2 != 0) {
                res*= a;
                b-=1;
            }else {
                a*= a;
                b/=2;
            }
        }

        res
    }
}
