package DecodeWays;

/**
 * 91. Decode Ways
 *
 * A message containing letters from A-Z
 * is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int[] dp = new int[s.length()+1];
        dp[0] = (s.charAt(0) == '0')?0:1;
        dp[1] = (s.charAt(0) == '0')?0:1;
        for(int i=2;i<=s.length();i++) {
            int c = s.charAt(i-1)-'0';
            int p = s.charAt(i-2)-'0';
            if(c == 0) {
                if(dp[i-1] <= 2 && p != 0)
                    dp[i] = dp[i-2];
                else return 0;
            }
            else if(p == 1 || (p == 2 && c < 7)) {
                dp[i] = dp[i-1]+dp[i-2];
            }
            else
                dp[i] = dp[i-1];
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("100"));
    }
}
