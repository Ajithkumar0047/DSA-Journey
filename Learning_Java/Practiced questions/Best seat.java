import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner ak = new Scanner(System.in);

        int n = ak.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = ak.nextInt();
        }

        int min = a[0];
        int max = a[0];

        for(int i = 1; i < n; i++){
            if(a[i] < min){
                min = a[i];
            }

            if(a[i] > max){
                max = a[i];
            }
        }

        int center2 = min + max;

        int answer = a[0];
        int distance = Math.abs(2 * a[0] - center2);

        for(int i = 1; i < n; i++){
            int currentDistance = Math.abs(2 * a[i] - center2);

            if(currentDistance < distance ||
               (currentDistance == distance && a[i] < answer)){
                distance = currentDistance;
                answer = a[i];
            }
        }

        System.out.println(answer);
    }
}