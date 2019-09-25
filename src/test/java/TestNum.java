/**
 * @author wk
 * @date 2019/9/24  9:13
 */
public class TestNum {

    public static void main(String[] args) {
        test();
    }

    /**
     * 获取数值
     */
    private static void test(){
        for (int i = 100; i <999 ; i++) {
            //判断是否是4的倍数
            if (i%4!=0){
                continue;
            }
            //判断是否能开平方
            double a = Math.sqrt(i);
            boolean flag = (int)a-a==0;
            if (!flag){
                continue;
            }

            //判断是否有两位数相同
            String str = new Integer(i).toString();
            String str1 = str.substring(0,1);
            String str2 = str.substring(1,2);
            String str3 = str.substring(2,3);
            if (str1.equals(str2) || str2.equals(str3) || str1.equals(str3)){
                System.out.println(i);
            }
        }
    }
}
