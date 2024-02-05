import scala.collection.mutable._

object Solution {
    def isNumber(str: String) : Boolean = {
        str forall Character.isDigit
    }

    def decodeString(s: String): String = {
        var st = new Stack[Char]

        for(ch <- s) {
            if(ch != ']') {
                st.push(ch)
            }else {
                var str = "";
                while(st.top != '[') {
                    str += st.top
                    st.pop()
                }
                st.pop()
                
                var numS = ""
                while(st.size>0 && st.top.isDigit) {
                    numS += st.top
                    st.pop()
                }

                var num = numS.reverse.toInt
                str = (str*num).reverse
                for(c <- str) st.push(c)
            }
        }

        var res = ""

        while(st.size>0) {
            res += st.top
            st.pop()
        }

        res.reverse
    }
}
