import java.util.Random;
import java.util.Scanner;

public class Knapsack {
    static double max(int[] wt, int[] val, int capacity, int value) {
        double[][] ratio = new double[value][2];
        double temp1, temp2;
        int temp3, temp4, sum = 0;
        for (int i = 0; i < value; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / wt[i];
        }
        for (int i = 0; i < value; i++) {
            for (int j = i + 1; j < value; j++) {
                if (ratio[i][1] > ratio[j][1]) {
                    temp1 = ratio[i][1];
                    ratio[i][1] = ratio[j][1];
                    ratio[j][1] = temp1;
                    temp2 = ratio[i][0];
                    ratio[i][0] = ratio[j][0];
                    ratio[j][0] = temp2;
                    temp3 = wt[i];
                    wt[i] = wt[j];
                    wt[j] = temp3;
                    temp4 = val[i];
                    val[i] = val[j];
                    val[j] = temp4;
                }
            }
        }
        for (int i = 0; i < ratio.length; i++) {
            System.out.print(ratio[i][0] + " ");
            System.out.print(ratio[i][1] + " ");
            System.out.print(wt[i] + "  ");
            System.out.print(val[i] + "  \n");
            sum = sum + val[i];
        }
        double totalValue = 0d;
        for (int j = value - 1; j >= 0; j--) {
            int curWt = (int) wt[j];
            int curVal = (int) val[j];
            int wtremain = capacity;
            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue += curVal;
                wtremain = wtremain - curWt;
                System.out.println(j);
            } else if (wtremain < curWt && wtremain > 0) {
                double fraction = ((double) capacity / (double) curWt);
                totalValue += (curVal * fraction);
                capacity = (int) (capacity - (curWt * fraction));
                System.out.println(j);
                System.out.println(fraction);
                break;
            }
        }
        System.out.println("sum = " + sum);
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        System.out.println("enter  number of things you want to enter");
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = ra.nextInt(1000);
            wt[i] = ra.nextInt(100);
            if (wt[i] == 0 || val[i] < 100) {
                i--;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(val[i] + " ");
            System.out.println(wt[i]);
        }
        double maxvalue = max(wt, val, w, n);
        System.out.println("maximum value =" + maxvalue);
    }
}