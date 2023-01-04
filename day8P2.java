import java.io.*;
import java.util.*;
public class day8P2{  
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f = new Scanner(new File("trees.txt"));
        String s = f.nextLine();
        int[][] a = new int[99][s.length()];
        int[][] b = new int[99][s.length()];
        for(int c = 0; c < s.length(); c++){
            a[0][c] = Integer.parseInt(s.charAt(c)+"");
        }
        for(int r = 1; r < 99; r++){
        	s = f.nextLine();
        	for(int c = 0; c < s.length(); c++){
        		int n = Integer.parseInt(s.charAt(c)+"");
        		a[r][c] = n;
        	}
        }
        for(int r = 0; r < a.length; r++){
        	for(int c = 0; c < a[0].length; c++){
        		search(a, b, r, c);
        	}
        }
        int max = 0;
        for(int r = 0; r < a.length; r++){
        	for(int c = 0; c < a[0].length; c++){
        		if(b[r][c]>max){
        			max = b[r][c];
        		}
        	}
        }
        System.out.print(max+"");
    }


    private static void search(int[][] a, int[][] b, int r, int c){
    	if(r==0||c==0||r==a.length-1||c==a[0].length-1){
    		b[r][c] = 0;
    	}else{
    		int n = a[r][c];
    		int s1 = 0;
    		int s2 = 0;
    		int s3 = 0;
    		int s4 = 0;
    		for(int c2 = c-1; c2 >= 0; c2--){  
    		    s1++;
        		if(n<=a[r][c2]){
        		    break;
        		}
    		}
    		for(int c2 = c+1; c2 < a[0].length; c2++){  
    		    s2++;
        		if(n<=a[r][c2]){
                    break;
        		}
    		}
    		for(int r2 = r-1; r2 >=0; r2--){  
    		    s3++;
        		if(n<=a[r2][c]){
        			break;
        		}
    		}
    		for(int r2 = r+1; r2 < a.length; r2++){ 
    		    s4++;
        		if(n<=a[r2][c]){
        			break;
        		}
    		}
    		b[r][c]=s1*s2*s3*s4;
    	}
    }
}
