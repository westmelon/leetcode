import java.util.Arrays;
import com.neo.leetcode.daily.q260.Solution;

/**
 * @author linyi 2020-09-21
 */
public class App {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        System.out.println(Arrays.toString(ints));
    }

}
