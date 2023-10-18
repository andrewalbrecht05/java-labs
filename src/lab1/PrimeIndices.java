package lab1;

import java.util.Scanner;

public class PrimeIndices {
    public static boolean isPrime( int x )
    {
        for( int i = 2; i * i <= x; i++ )
        {
            if( x % i == 0 )
            {
                return false;
            }
        }
        return true;
    }
    public static void reset() {
        System.out.println("Введіть розмір массиву: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        if( size <= 0 )
        {
            System.out.println("Введіть розмір масиву більше 0!");
            return;
        }
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Введіть елемент №: " + (i + 1));
            int elem = sc.nextInt();
            arr[i] = elem;
        }
        System.out.println("Масив після обнулення елементів на індексах, які є простими числами:");
        for( int i = 0; i < arr.length; i++ )
        {
            if( isPrime(i) )
            {
                arr[i] = 0;
            }
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
