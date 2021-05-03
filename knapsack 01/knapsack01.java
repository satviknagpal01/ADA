class Knapsack01{
     
 
    static int max(int a, int b) 
    {
       return (a > b) ? a : b;
    }
 
    static void printknapSack(int W, int wt[], 
                             int val[], int n)
    {
       int i, w;
       int K[][] = new int[n + 1][W + 1];
    
       
       for (i = 0; i <= n; i++) {
          for (w = 0; w <= W; w++) {
             if (i == 0 || w == 0)
                K[i][w] = 0;
             else if (wt[i - 1] <= w)
                K[i][w] = Math.max(val[i - 1] + 
                         K[i - 1][w - wt[i - 1]], K[i - 1][w]);
             else
                K[i][w] = K[i - 1][w];
          }
       }
 
       int res = K[n][W];
       System.out.println(res);
    
       w = W;
       for (i = n; i > 0 && res > 0; i--) {
      
          if (res == K[i - 1][w])
             continue;
          else {
          
             System.out.println("Include items with weight -> "+ wt[i - 1] + " and value " + val[i-1]);
          
             
             res = res - val[i - 1];
             w = w - wt[i - 1];
          }
       }
    }
  
   
    public static void main(String arg[])
    {
       int val[] = { 6, 10, 12 };
       int wt[] = { 1, 2, 3 };
       int W = 5;
       int n = val.length;
    
       printknapSack(W, wt, val, n);
    }
    }
 
 
 