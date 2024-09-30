// Задача 2. Создание CSV-строки из массива объектов
// Дан массив объектов, где каждый объект представляет собой строку данных, и
// массив заголовков. Создайте строку CSV, где строки данных разделяются новой
// строкой, а значения в строках разделяются запятыми.
// Пример:
// String[] headers = {"Name", "Age", "City"};
// String[][] data = {
// {"John", "30", "New York"},
// {"Alice", "25", "Los Angeles"},
// {"Bob", "35", "Chicago"}
// };
// Результат:
// Name,Age,City
// John,30,New York
// Alice,25,Los Angeles
// Bob,35,Chicago
class CSVGenerator {
    public String generateCSV(String[] headers, String[][] data) {
        StringBuilder sb = new StringBuilder();
        sb.append(headers[0]);
        for (int i = 1; i < headers.length; i++) {
            sb.append(",");
            sb.append(headers[i]);            
        }        
        for (int i = 0; i < data.length; i++) {
            sb.append("\n");
            sb.append(data[i][0]);
            for (int j = 1; j < data[i].length; j++) {
                sb.append(",");
                sb.append(data[i][j]); 
            }
        }
        return sb.toString();
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        String[] headers = {};
        String[][] data = {};
        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            headers = new String[] { "Name", "Age", "City" };
            data = new String[][] {
                    { "John", "30", "New York" },
                    { "Alice", "25", "Los Angeles" },
                    { "Bob", "35", "Chicago" }
            };
        } else {
            // Преобразование строковых параметров в массивы
            // Пример обработки данных можно дополнить в зависимости от формата args
        }
        CSVGenerator ans = new CSVGenerator();
        System.out.println(ans.generateCSV(headers, data));
    }
}
