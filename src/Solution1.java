import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: huanglin
 * Date: 2019/8/22
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[][] position = new int[26][2];
        for (int i = 0; i < position.length; i++) {
            position[i][0] = -1;
            position[i][1] = s.lastIndexOf('A' + i);
        }
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (position[s.charAt(i)-'A'][0] == -1) position[s.charAt(i)-'A'][0] = i;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < 26; i++) {
            if (position[i][0] != -1) map.put(position[i][0], position[i][1]);
        }
        List<Integer> ans = new ArrayList<>();
        Integer curLeft = -1;
        Integer curRight = -1;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (curLeft == -1) {
                curLeft = entry.getKey();
                curRight = entry.getValue();
                continue;
            }
            if (curRight < entry.getKey()) {
                ans.add(curRight - curLeft + 1);
                curLeft = entry.getKey();
                curRight = entry.getValue();
            }else if (curRight > entry.getKey() && curRight < entry.getValue()) {
                curRight = entry.getValue();
            }
        }
        ans.add(curRight-curLeft+1);

        for (int i = 0; i < ans.size(); i++) {
            System.out.printf(String.valueOf(ans.get(i)));
            if (i != ans.size()-1) System.out.printf(" ");
        }
        
        /*
        *  a: 0~10 b:2~8
        *
        * */
    }
}
