package lab3;

import java.util.Scanner;

public class Execution {
    static void printInfo()
    {
        System.out.println("Можливі операції: ");
        System.out.println("0 - Довідка");
        System.out.println("1 - Задати розмір стеку");
        System.out.println("2 - Додати елемент до стеку");
        System.out.println("3 - Отримати елемент зі стеку");
        System.out.println("-1 - Завершити роботу програми");
    }
    public static void operations() {
        System.out.println("Виберіть необхідну операцію (введіть 0 для довідки)");

        Scanner scan = new Scanner(System.in);
        boolean size_set = false;
        Stack st = new Stack(100);
        int x;


        while(true)
            System.out.println();
        {
            System.out.println("Введіть номер операції: ");
            x = scan.nextInt();
            if( x == -1 )
                break;
            else if( x == 0 )
                printInfo();
            else if( x == 1 )
            {
                if( size_set )
                {
                    System.out.println("Ви вже задали розмір стеку!");
                    continue;
                }


                System.out.println("Введіть розмір стеку:" );
                int size = scan.nextInt();

                if( size <= 0 )
                {
                    System.out.println("Введіть розмір масиву більше 0!");
                    return;
                }
                st = new Stack(size);
                size_set = true;
            }
            else if( x == 2 )
            {
                if( !size_set )
                {
                    System.out.println("Ви ще не задали розмір стеку!");
                    continue;
                }
                System.out.println("Введіть елемент, який ви хочете додати до стеку: ");
                int item = scan.nextInt();

                if( st.isFull() )
                {
                    System.out.println("Стек переповнений!");
                    continue;
                }
                st.push(item);
            }
            else if( x == 3 )
            {
                if( !size_set )
                {
                    System.out.println("Ви ще не задали розмір стеку!");
                    continue;
                }
                if( st.isEmpty() )
                {
                    System.out.println("Стек порожній.");
                    continue;
                }
                System.out.print("Отриманий елемент: ");
                System.out.println(st.pop());
            }
            else
            {
                System.out.println("Такої операції не існує!");
            }
        }
    }
}
