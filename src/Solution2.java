/**
 * Created with IntelliJ IDEA.
 * User: huanglin
 * Date: 2019/8/22
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
public class Solution2 {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++)
            if (input[i].length() > maxLen) maxLen = input[i].length();

        StringBuilder ans = new StringBuilder();
        int curIndex = 0;
        for(;;){
                for (String s : input) {
                    if (curIndex < s.length() && !helper(ans.toString(), s.charAt(curIndex))) {
                        ans.append(s.charAt(curIndex));
                    }
            }
            curIndex++;
                if (curIndex > maxLen)
                    break;
        }
        System.out.println(ans.toString());
    }
    private static boolean helper(String s, char c) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c) return true;

        return false;
    }
}