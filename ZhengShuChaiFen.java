package DiGuiYuFenZhi;
/** 【题目要求】
 *  整数的拆分。（ 正整数n的拆分为p(n)=p(n,n) ）
 */

import java.util.Scanner;

/**
 * Created by zhangjiawen on 2017/3/1.
 */
public class ZhengShuChaiFen {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入将要拆分的数：");
        Integer n = scanner.nextInt();
        System.out.println("请输入规定不超过的数：");
        Integer m = scanner.nextInt();
        int sum = problem(n ,m);
        System.out.println("可以拆分的情况总数：" + sum);
    }

    //通过递归调用，实现整数的拆分
    public static int problem(int n , int m){
        if (n ==1 || m == 1){
            return 1;
        }
        if (n < m){
            return problem(n , n);
        }
        if (n == m){
            return problem(n , m-1)+1;
        }
        return (problem(n , m-1) + problem(n-m , m));
    }

}
