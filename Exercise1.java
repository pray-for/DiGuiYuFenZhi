package DiGuiYuFenZhi;
/** 【题目要求】
 *  给定一数组a[N]，我们希望构造数组b [N]，其中b[j]=a[0]*a[1]…a[N-1] / a[j]，
 *  要求 在构造过程中，不允许使用除法  O（1）空间复杂度和O（n）的时间复杂度；
 *  除遍历计数器与a[N] b[N]外，不可使用新的变量（包括栈临时变量、堆空间和全局静态变量等）；
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by zhangjiawen on 2017/3/1.
 */
public class Exercise1 {

    public static int[] a;
    public static int[] b;

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入a数组中元素的个数：");
        Integer n = scanner.nextInt();
        a = new int[n];
        b = new int[n];
        //输入一组数字，并存到数组a中
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < a.length; i++){
            System.out.print("输入第" + (i+1) + "个整数：");
            a[i] = Integer.parseInt(buf.readLine());
        }
        System.out.println("数组b的内容如下：");
        problem(a, b, n);

    }

    public static void problem(int[] a, int[] b, int n){
        int i;
        for (i = n-1; i >= 0; i--){
            if (i == n-1){
                b[n-1] = a[n-1];
            }
            else {
                b[i] = a[i] * b[i+1];
//                System.out.print(b[i] + "---");
            }
        }

        for (i = 0; i < n; i++){
            if (i == 0){
                a[0] = a[0];
            }
            else {
                a[i] = a[i] * a[i-1];
            }
        }

        for (i = 0; i < n; i++){
            if (i == 0){
                b[i] = b[1];
                System.out.print(b[i] + " ");
            }
            else if (i == n-1){
                b[i] = a[n-2];
                System.out.print(b[i] + " ");
            }
            else {
                b[i] = a[i-1] * b[i+1];
                System.out.print(b[i] + " ");
            }
        }
//        System.out.print(b[i] + " ");

    }


}
