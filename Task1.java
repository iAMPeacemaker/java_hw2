/* 
 * Дана строка sql-запроса "select * from students where ".
 * Сформируйте часть WHERE этого запроса, используя StringBuilder.
 * Данные для фильтрации приведены ниже в виде json-строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * 
 * Параметры для фильтрации:
 * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 * Пример вывода: "select * from students WHERE name = Ivanov AND country = Russia.....".
 */

package HomeWorks.hw2;

public class Task1 {
    public static void main(String[] args) {
        String request_str = "select * from students where ";
        String my_request = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"null\", \"age\":\"18\"}";
        StringBuilder request_sb = new StringBuilder(request_str);
        String[] requests = my_request.replaceAll("[\"{}]", "").split(",");

        for (int i = 0; i < requests.length; i++) {
            int strt_attribute = requests[i].indexOf(":") + 1;
            if (!requests[i].substring(strt_attribute).equalsIgnoreCase("null")) {
                request_sb.append(requests[i].replace(":", " = ").trim());
                if (i != (requests.length - 1)) { request_sb.append(" AND "); } 
            }
        }

        if (request_sb.toString().endsWith(" AND ")) {
            System.out.println(request_sb.toString().substring(0, request_sb.toString().lastIndexOf(" AND ")));
        } else if (request_sb.toString().endsWith(" where ")) {
            System.out.println(request_sb.toString().substring(0, request_sb.toString().lastIndexOf(" where ")));
        } else { System.out.println(request_sb); }
    }
}
