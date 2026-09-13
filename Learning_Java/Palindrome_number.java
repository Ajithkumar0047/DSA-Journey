class Solution {
    public boolean isPalindrome(int x) {
        String b = Integer.toString(x);
        int a = b.length();
        boolean p = true;
        if (a % 2 == 0) {
            for (int i = 0; i < a; i++) {
                if (b.charAt(i) != b.charAt(a - i - 1)) {
                    p = false;
                }
            }
        } else {
            for (int j = 0; j < a; j++) {
                if (j != (j / 2)) {
                    if (b.charAt(j) != b.charAt(a - j - 1)) {
                        p = false;
                    }
                }
            }
        }
        return p;
    }
}