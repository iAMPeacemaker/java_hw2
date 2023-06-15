/* 
* К калькулятору из предыдущего ДЗ добавить логирование.
*
* Реализовать простой калькулятор (+-/*)
*/

package HomeWorks.hw2;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;
public class Task4 {
    public static void main(String[] args) throws SecurityException, IOException {

        Logger journal = Logger.getLogger(Task4.class.getName());
        FileHandler fh = new FileHandler("Task4_log.txt");
        journal.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        journal.log(Level.INFO, "Application started.\n");
        Scanner input_from_user = new Scanner(System.in);
        boolean was_operation = false;
        double result = 0;
        String operation;
        
        System.out.print("Enter a first number - ");
        double first_num = input_from_user.nextInt();
        journal.log(Level.INFO, String.format("Was entered a first number - %f\n", first_num));

        System.out.print("Enter a second number - ");
        double second_num = input_from_user.nextInt();
        journal.log(Level.INFO, String.format("Was entered a second number - %f\n", second_num));

        while (true) {
            System.out.print("Enter a arithmetic operation - ");
            switch (operation = input_from_user.next()) {
                case "*":
                    result = first_num * second_num;
                    was_operation = true;
                    journal.log(Level.INFO, String.format("Was entered a multiplication operation - %s\n", operation));
                    journal.log(Level.INFO, String.format("Result of operation - %f\n", result));
                    break;
                case "/":
                    result = first_num / second_num;
                    was_operation = true;
                    journal.log(Level.INFO, String.format("Was entered a division operation - %s\n", operation));
                    journal.log(Level.INFO, String.format("Result of operation - %f\n", result));
                    break;
                case "+":
                    result = first_num + second_num;
                    was_operation = true;
                    journal.log(Level.INFO, String.format("Was entered a addition operation - %s\n", operation));
                    journal.log(Level.INFO, String.format("Result of operation - %f\n", result));
                    break;
                case "-":
                    result = first_num - second_num;
                    was_operation = true;
                    journal.log(Level.INFO, String.format("Was entered a subtraction operation - %s\n", operation));
                    journal.log(Level.INFO, String.format("Result of operation - %f\n", result));
                    break;
                case "%":
                    result = first_num % second_num;
                    was_operation = true;
                    journal.log(Level.INFO, String.format("Was entered a division remainder operation - %s\n", operation));
                    journal.log(Level.INFO, String.format("Result of operation - %f\n", result));
                    break;
                default:
                    System.out.println("Mistake!");
                    journal.log(Level.SEVERE, String.format("Was entered wrong operation! \"%s\"\n", operation));
            }
            if (was_operation) break;
        }    
        System.out.printf("%d %s %d = %f", (int)first_num, operation, (int)second_num, result);
        input_from_user.close();
        journal.log(Level.INFO, String.format("End result - %d %s %d = %f\n", (int)first_num, operation, (int)second_num, result));
        journal.log(Level.INFO, "Application ended.");
    }
}
