import java.util.*;
import java.util.Arrays;

public class Greedy {
    static class Item {
        int value, weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static void fractionalknapsack(int W, Item ar[], int n) {
        double[][] a = new double[n][3];
        double w = W;
        for (int i = 0; i < n; i++) {
            a[i][0] = ar[i].weight;
            a[i][1] = ar[i].value;
            a[i][2] = ar[i].value / ar[i].weight;
        }
        Arrays.sort(a, Comparator.comparingDouble(o -> o[2]));
        double profit = 0.0;
        for (int i = n - 1; i >= 0; i--) {
            if (w >= a[i][0]) {
                profit += a[i][1];
                w -= a[i][0];
            } else {
                profit += (a[i][1] / a[i][0]) * w;
                break;
            }
        }
        System.out.print(profit);
    }

    static void knapscak() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int w = s.nextInt();
        Item[] ar = new Item[n];
        for (int i = 0; i < n; i++) {
            ar[i] = new Item(s.nextInt(), s.nextInt());
        }
        fractionalknapsack(w, ar, n);
    }

    static class Job {
        int job, deadline, profit;

        Job(int job, int deadline, int profit) {
            this.job = job;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    static void JobScheduling(Job arr[], int n) {
        int[][] a = new int[n][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i][0] = arr[i].deadline;
            a[i][1] = arr[i].profit;
            max = Math.max(max, a[i][0]);
        }
        int[] size = new int[max];
        int[] ans = new int[2];
        Arrays.sort(a, Comparator.comparingDouble(o -> o[1]));
        for (int i = n - 1; i >= 0; i--) {
            int ind = a[i][0] - 1;
            int profit = a[i][1];
            if (size[ind] == 0) {
                size[ind] = -1;
                ans[0] += 1;
                ans[1] += profit;
            } else {
                while (ind >= 0) {
                    if (size[ind] == 0) {
                        size[ind] = -1;
                        ans[0] += 1;
                        ans[1] += profit;
                        break;
                    }
                    ind--;
                }
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }

    static void jobmain() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Job[] arr = new Job[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Job(s.nextInt(), s.nextInt(), s.nextInt());
        }
        JobScheduling(arr, n);
    }
    public static void minimumCostOfBreaking(int[] x, int[] y) {
        Arrays.sort(x);
        Arrays.sort(y);
        int xp = x.length - 1, yp = y.length - 1, hc = 1, vc = 1, ans = 0;
        while (xp > -1 && yp > -1) {
            if (y[yp] > x[xp]) {
                ans += (hc * y[yp]);
                vc++;
                yp--;
            } else {
                ans += (vc * x[xp]);
                hc++;
                xp--;
            }
        }
        while (yp > -1) {
            ans += (y[yp] * hc);
            vc++;
            yp--;
        }
        while (xp > -1) {
            ans += (x[xp] * vc);
            xp--;
        }
        System.out.println(ans);
    }
    static void minimumCostToCutmain(){
        Scanner s=new Scanner(System.in);
        int m=s.nextInt(),n=s.nextInt();
        int[] x=new int[m];
        int[] y=new int[n];
        for(int i=0;i<m;i++){
            x[i]=s.nextInt();
        }
        for(int i=0;i<n;i++){
            y[i]=s.nextInt();
        }
    }
    public static void main(String args[]) {
        jobmain();
    }
}
