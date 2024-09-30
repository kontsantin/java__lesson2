/* 
Задача 3. Удаление пустых строк из текста
Дана строка с несколькими строками текста, разделенными переводами строки.
Напишите метод, который удаляет все пустые строки из текста.
Пример:

line1

line2

line3

Результат:
line1
line2
line3
*/
class TextCleaner {
    public  String removeEmptyLines(String text) {
        String[] lines = text.split("\n");
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(line);
            }
        }
        return sb.toString();
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static  void main(String[] args) {
        String text = "";
        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            text = "line1\n\nline2\n\nline3";
        } else {
            text = args[0];
        }

        TextCleaner ans = new TextCleaner();
        System.out.println(ans.removeEmptyLines(text));
    }
}
