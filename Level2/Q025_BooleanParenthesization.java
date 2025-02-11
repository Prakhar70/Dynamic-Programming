package Level2;

public class Q025_BooleanParenthesization {
    static int countWays(String s) {
        int i = 0;
        int j = s.length() - 1;
        return countWays(s, i, j);
    }

    private static int countWays(String s, int i, int j) {
        if(i==j){
            return s.charAt(i)=='T'
        }
    }
}
