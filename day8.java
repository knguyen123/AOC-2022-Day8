import java.io.*;
import java.util.*;
public class day8{  
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f = new Scanner(new File("trees.txt"));
        String s = f.nextLine();
        int[][] a = new int[99][s.length()];
        boolean [][] b = new boolean[99][s.length()];
        for(int c = 0; c < s.length(); c++){
            a[0][c] = Integer.parseInt(s.charAt(c)+"");
        }
        for(int r = 1; r < 99; r++){
        	s = f.nextLine();
        	for(int c = 0; c < s.length(); c++){
        		int n = Integer.parseInt(s.charAt(c)+"");
        		a[r][c] = n;
        		b[r][c] = false;
        	}
        }
        for(int r = 0; r < a.length; r++){
        	for(int c = 0; c < a[0].length; c++){
        		search(a, b, r, c);
        	}
        }
        int n = 0;
        for(int r = 0; r < a.length; r++){
        	for(int c = 0; c < a[0].length; c++){
        		if(b[r][c]){
        			n++;
        		}
        	}
        }
        System.out.print(n+"");
    }


    private static void search(int[][] a, boolean[][] b, int r, int c){
    	if(r==0||c==0||r==a.length-1||c==a[0].length-1){
    		b[r][c] = true;
    	}else{
    		int n = a[r][c];
    		boolean b1 = true;
    		boolean b2 = true;
    		boolean b3 = true;
    		boolean b4 = true;
    		for(int c2 = c-1; c2 >= 0; c2--){  
        		if(n<=a[r][c2]){
        		    b1=false;
        		    break;
        		}
    		}
    		for(int c2 = c+1; c2 < a[0].length; c2++){  
        		if(n<=a[r][c2]){
        			b2=false;
                    break;
        		}
    		}
    		for(int r2 = r-1; r2 >=0; r2--){  
        		if(n<=a[r2][c]){
        			b3=false;
        			break;
        		}
    		}
    		for(int r2 = r+1; r2 < a.length; r2++){  
        		if(n<=a[r2][c]){
        			b4=false;
        			break;
        		}
    		}
    		if(b1||b2||b3||b4){
    		    b[r][c] = true;
    		}else{
    		    b[r][c] = false;
    		}
    	}
    }
}
