package DiGuiYuFenZhi;
/** 【题目要求】
 *  实现数字或者字符的全排列
 *  本程序中只写了关于数字的全排列
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by zhangjiawen on 2017/3/1.
 */
public class Perm {

    public static int[] arr;
    public static int sum;
    public static Set set = new HashSet();

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入进行全排列的数字个数：");
        int n = scanner.nextInt();
        arr = new int[n];
        System.out.println("请依次输入需要全排列的数字----->");
        //输入一组数字，并存到数组arr中
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++){
            System.out.print("输入第" + (i+1) + "个数：");
            arr[i] = Integer.parseInt(buf.readLine());
        }
        sort(0 , arr.length);
        System.out.println("全排列的情况一共有 " + sum + " 种");

    }

    public static void sort(int index , int length){
        set.add(Arrays.toString(arr));

        if (index == length-1){
            for (int i = 0; i < length; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            sum++;
        }
        for (int i = index; i < length; i++){
            swap(index , i);
            sort(index+1 , length);
            swap(index , i);
        }

    }

    public static void swap(int index , int i){
        int temp;
        temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }

}
