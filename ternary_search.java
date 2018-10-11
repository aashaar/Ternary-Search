/*
******************************************************************************
* Title: Tertiary Search
* Author : Aashaar Panchalan
* Date : 28-Jan-2018
* Description :
*   - Like a binary search divides a list into 2 parts,a tertiary search the list is divided into 3 parts with 2 midpoints.
*   - List sorted in descending order.
*   - So mid11 will be greater than or equal to mid2.
******************************************************************************  */

import java.util.Scanner;
public class ternary_search
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int [] A = {98,94,85,81,80,72,67,66,55,52,47,41,38,35,25,21,19,11,9,1};
        int h = A.length - 1;
        //System.out.println("Size of array = " + A.length);
        int l = 0;
        //int val = 14; // value to be searched
        System.out.println("The array of numbers is: ");
        for(int i=0;i<A.length;i++)
        {
            System.out.println(A[i]);
        }
        System.out.println("------------");
        while(true)
        {
            System.out.println("Enter the number to be searched");
            int val = scanner.nextInt();
            int result = ternarySearch(A, val, h, l);
            if (result == -1) {
                System.out.println("Value not found");
            }
            /*else if (result == 0)
            {
                System.out.println("*****ZERO returned");
            }*/
            else {
                System.out.println("Success ! Value found at location ---> " + (result + 1) + " <--- in the list");
            }

            System.out.println("*********** Execution completed ************");
        }
    }


    /*
    ******************************************************************************
    * Function ternarySearch :
    * Input parameters :
        - Array A - array of values
        - int val - value to be searched
        - int h - highest index of the array
        - int l - smallest index of the array
    * Output parameter :
        - int result - index no. of the value if it is found, else -1.
    ******************************************************************************     */
    static int ternarySearch(int[] A, int val, int h, int l)
    {
        int mid1,mid2;
        mid1 = l + ((h-l)/3);
        mid2 = mid1 + ((h-l)/3);
        //System.out.println("mid1 = " +mid1);
        //System.out.println("mid2 = " +mid2);
        if (l>h)
        {
            return -1;
        }
        else if (A[mid1] == val)
        {
            return mid1;
        }
        else if (A[mid2] == val)
        {
            return mid2;
        }
        else if (A[mid1] > val && A[mid2] < val) // cond1 - check if value is between mid1 & mid2
        {
            h = mid2 - 1;
            l = mid1 + 1;
            return ternarySearch (A,val,h,l);
        }
        else if (A[mid1] < val) // cond2
        {
            h = mid1 - 1;
            return ternarySearch (A,val,h,l);
        }
        else if (A[mid1] > val) // cond 3 : val is smaller than mid1 but not greater than mid2 (from 'cond1')
        {
            l = mid2 + 1;
            return ternarySearch (A,val,h,l);
        }
        else
        {
            return -1;
        }
    }
}
