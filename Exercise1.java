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

        int bi = problem(a, b, n);
        System.out.println("\n" + "最终的计算结果为：" + bi);
    }


    public static int problem(int[] a, int[] b, int n){
        int i;
        b[0] = 1;
        for (i = 1; i < n; i++){//先求出前半段的乘积
            b[i] = b[i-1] *a[i-1];
            System.out.print("循环1---" + b[i] + " ");
        }
        b[0] = a[n-1];
        for (i = n-2; i >= 1; i--){//求出后半段的乘积，从数组尾部向前循环
            b[i] = b[0] * b[i];
            b[0] = b[0] * a[i];
            System.out.print("循环2---" + b[i] + " ");
        }
        return b[i];
    }


}
