package easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !((Character.toLowerCase(s.charAt(i)) >= 'a' && Character.toLowerCase(s.charAt(i)) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                i++;
            }

            if (i == j) {
                return true;
            }

            while (i < j && !((Character.toLowerCase(s.charAt(j)) >= 'a' && Character.toLowerCase(s.charAt(j)) <= 'z') || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
                j--;
            }

            System.out.println("Compare s[" + i + "]=" + s.charAt(i) + " and s[" + j + "]="+ s.charAt(j));
            if (Character.toLowerCase(s.charAt(j)) != Character.toLowerCase(s.charAt(i))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
