import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner ak=new Scanner(System.in);
        int t=ak.nextInt();
        while(t-->0){
            String a=ak.next();
            int r=a.length()-1;
            for(int i=0;i<a.length()-1;i++){
                if(a.charAt(i)>a.charAt(i+1)){
                    r=i;
                    break;
                }
            }
            String s=a.substring(0,r)+a.substring(r+1);
            System.out.println(Long.parseLong(s));
        } 
	}
}
