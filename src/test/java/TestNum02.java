import java.util.ArrayList;
import java.util.List;

/**
 * @author wk
 * @date 2019/9/25  9:34
 */
public class TestNum02 {
    public static void main(String[] args) {
        for (int i = 1; i < 100_000_000_0; i++) {
            if (i == pre(i) && test(i) ){
                System.out.println(i);
            }
        }

    }

    /**
     * 判断是否是素数
     * @param n
     * @return
     */
    public static boolean test(int n){
        if (n<2){
            return false;
        }
        int z = (int)Math.sqrt(n);
        for (int i = 2; i <= z; i++) {
            if (n%i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否是回文数
     * @param n
     * @return
     */
    public static Integer pre(int n){
        int temp=0;
        while (n>0){
            temp = temp*10+(n%10);
            n=n/10;
        }
        return temp;
    }


}
