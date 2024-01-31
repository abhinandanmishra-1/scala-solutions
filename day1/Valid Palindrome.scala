object Solution {
    def isPalindrome(s: String): Boolean = {
        var str = s.filter(ch => ch.isDigit || ch.isLetter).toLowerCase;

        return str == str.reverse;
    }
}
