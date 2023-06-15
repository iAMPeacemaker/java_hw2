/* 
 * Реализуйте алгоритм сортировки пузырьком числового массива,
 * результат после каждой итерации запишите в лог-файл.
 */

package HomeWorks.hw2;

import java.util.Arrays;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    public static void main(String[] args) throws SecurityException, IOException {
        Logger journal = Logger.getLogger(Task2.class.getName());
        FileHandler fh = new FileHandler("Task2_log.txt");
        journal.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        int[] num_arr = new int[] {7, 8, 3, 5, 1, 6, 2, 9, 4};
        int size_arr = num_arr.length;
        int count = 0;
        String msg = "";

        for (int current = 0; current < size_arr - 1; current++) {
            for (int i = 0; i < (size_arr - 1 - current); i++) {
                if (num_arr[i] > num_arr[i + 1]){
                    int temp = num_arr[i];
                    num_arr[i] = num_arr[i + 1];
                    num_arr[i + 1] = temp;

                    msg = String.format("%d. Массив стал %s \n", count++, Arrays.toString(num_arr));
                } else { msg = String.format("%d. Массив не изменился с предыдущей итерации \n", count++); }
                
                journal.log(Level.INFO, msg);
            }
        }
        msg = String.format("Было произведено %d операций.\nРезультат сортировки  - %s", --count, Arrays.toString(num_arr));
        journal.log(Level.INFO, msg);
    }
}
