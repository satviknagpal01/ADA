import java.util.Scanner;

public class length {
    static int lengthm(String m){
        int i=m.length();
        return i;
    }
    static void same(int len , String[] n , String m){
        int j=0;
        int count=0;
        String[] nn = new String[999];
        for (int i = 0; i < n.length; i++) {
            if(n[i].length()==len){
                nn[j]=n[i];
                j++;
                
            }
        }
        int[] comp = new int[j];
        for (int i = 0; i < j; i++) {
            comp[i]=0;
            for (int k = 0; k < len; k++) {
                if(nn[i].charAt(k)==m.charAt(k))
                    comp[i]++;
            }
            if (comp[i] == (len)) {
                count++;
            }
            if (comp[i] == (len -1)) {
                System.out.println(nn[i]);
            }
        }
        
        System.out.println("number of times "+m+" exists : "+count);
    }
    public static void main(String[] args) {
        String n,m;
        int len;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the String you want to enter");
        n=sc.nextLine();
        String[] arr = n.split(" ");
        System.out.println("enter the word you want to search");
        m= sc.next();
        len =lengthm(m);
        System.out.println( " the length of the word is : "+ len);
        same(len, arr, m);
    }    
}