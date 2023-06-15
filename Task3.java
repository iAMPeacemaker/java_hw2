/* 
* Дана json-строка (можно сохранить в файл и читать из файла)
* [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
* Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
* Пример вывода:
* Студент Иванов получил 5 по предмету Математика.
* Студент Петрова получил 4 по предмету Информатика.
* Студент Краснов получил 5 по предмету Физика.
*/

package HomeWorks.hw2;

public class Task3 {
    public static void main(String[] args) {

        String input_string = "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}";

        String student = "Студент ";
        String score = " получил ";
        String subject = " по предмету ";

        StringBuilder sb_data = new StringBuilder();

        String[] arr_str_data = input_string.replaceAll("[\"{]", "").split("}");

        for (int i = 0; i < arr_str_data.length; i++) {
            String[] arr_stroka = arr_str_data[i].split(",");
            for (int j = 0; j < arr_stroka.length; j++) {
                int strt_attribute = arr_stroka[j].indexOf(":") + 1;
                arr_stroka[j] = arr_stroka[j].replace(",", "").trim();
                switch (arr_stroka[j].substring(0, strt_attribute)) {
                    case "фамилия:":
                        sb_data.append(student);
                        sb_data.append(arr_stroka[j].substring(strt_attribute));
                        break;
                    case "оценка:":
                        sb_data.append(score);
                        sb_data.append(arr_stroka[j].substring(strt_attribute));
                        break;
                    case "предмет:":
                        sb_data.append(subject);
                        sb_data.append(String.format("%s\n",arr_stroka[j].substring(strt_attribute)));
                        break;
                }
            }
        }
        System.out.println(sb_data);
    }
}
