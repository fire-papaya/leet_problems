package easy;

public class BinaryAdd {
    public String operation(String a, String b) {
        var result = new StringBuilder();

        int addEl = 0;

        int j = b.length() - 1;
        int i = a.length() - 1;
        for ( ; i >=0 || j>=0 || addEl != 0; i--, j-- ) {
            int bitA = i >= 0 ? a.charAt(i) - '0' : 0;
            int bitB = j >= 0 ? b.charAt(j) - '0': 0;


            int sum = (bitA + bitB + addEl);

            result.append(sum % 2);
            addEl = sum / 2;
        }

        return result.reverse().toString();
    }
}
