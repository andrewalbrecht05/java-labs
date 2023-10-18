import java.util.Scanner;
import lab1.*;
import lab3.*;
public class Main {
    public static void main(String[] args) {
        Scanner scmain = new Scanner(System.in);
        System.out.println("1. Lab1");
        System.out.println("2. Lab3");
        System.out.println("-1. Вийти");

        while(true){
            System.out.println("Введіть номер операції: ");

            int num = scmain.nextInt();

            if( num == 1 ) {
                lab1.PrimeIndices.reset();
            }
            else if( num == 2 ) {
                lab3.Execution.operations();
            }
            else if( num == -1 ) {
                break;
            }
            else {
                System.out.println("Такої операції не існує!");
            }
        }

    }
}
