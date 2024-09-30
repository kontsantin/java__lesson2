/*(Задача 4. Логирование операций с массивом во время поиска
минимального и максимального элементов
Реализуйте метод поиска минимального и максимального элементов массива.
После нахождения каждого элемента (минимального и максимального),
сделайте запись в лог-файл log.txt в формате год-месяц-день
час:минуты {минимальный элемент}, {максимальный элемент}.
*/
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;

class ArrayOperations {
    private File log;
    private FileWriter fileWriter;

    public ArrayOperations(String path) {
        try {
            this.fileWriter = new FileWriter(path);
        } catch (IOException ex) {}
    }

    public void findMinMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max<arr[i]) {
                max = arr[i];
            }
            if (min>arr[i]) {
                min = arr[i];
            }
            this.logStep(min, max);
        }
        try {
            this.fileWriter.close();
        } catch (IOException ex) {}
       
    }

    private void logStep(int min, int max) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            this.fileWriter.append(sdf.format(new Date()) + "     current min: " + min + ", max: " + max + "\n");
        } catch (IOException ex) {}
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        int[] arr = {};
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        if (args.length == 0) {
            arr = new int[] { 9, 4, 8, 3, 1 };
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        ArrayOperations ans = new ArrayOperations("log.txt");
        ans.findMinMax(arr);
        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}