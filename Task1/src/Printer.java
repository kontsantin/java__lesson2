// Задание 1. Формирование URL с параметрами
// Дана строка базового URL:
// https://example.com/search?
// Сформируйте полный URL, добавив к нему параметры для поиска. Параметры
// передаются в виде строки, где ключи и значения разделены =, а пары
// ключ-значение разделены &. Если значение null, то параметр не должен
// попадать в URL.
// Пример:
// params = "query=java&sort=desc&filter=null"
// Результат:
// https://example.com/search?query=java&sort=desc

class URLBuilder {
    public static String buildURL(String baseURL, String params) {
        StringBuilder sb = new StringBuilder(baseURL);
        String[] array = params.split("&");
        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            String[] pair = str.split("=");
            if(!pair[1].equals("null")) {
                if (i > 0) {
                    sb.append("&");
                }
                sb.append(str);
            }
            
        }
        return sb.toString();

    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        String baseURL = "";
        String params = "";
        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            baseURL = "https://example.com/search?";
            params = "query=java&sort=desc&filter=null";
        } else {
            baseURL = args[0];
            params = args[1];
        }
        URLBuilder ans = new URLBuilder();
        System.out.println(ans.buildURL(baseURL, params));
    }
}
