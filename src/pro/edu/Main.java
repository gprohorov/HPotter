package pro.edu;

import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        String myString = new String(Files.readAllBytes(Paths.get("/home/george/Desktop/h2.txt")));

        String myString2 = myString
                .toLowerCase()
/*                .replaceAll(",", "")
                .replaceAll("!", "")
                .replaceAll("\\?", "")
                .replaceAll("\\.", "")
                .replaceAll("\"", "")*/
                .replaceAll("[^A-Za-z ]", "")
                ;

      //  String myStr2=Mystr.replaceAll("[^A-Za-zА-Яа-я0-9 ]", "");
      //  String myString3 = myString2.replaceAll(".", "");


        final String[] array = myString2.split(" ");
        System.out.println(array.length);


        //  создаем коллекцию для хранения уникальных слов  тип SET
        Set<String> set = new LinkedHashSet<>();

        //  наполняем, если слово уже есть в коллекции , оно более не добавлятся - свойство SET
        for (int i = 0; i <array.length ; i++) {
            set.add(array[i]);
        }

        // та же операция, только с помощью стримов
      //  Arrays.stream(array).forEach(el -> { set.add(el); });

        //  перегоням SET  в Array
        final Object[] uniqueWords = set.toArray();


        // выводим первые 10 слов из коллекции
        for (int i = 0; i < 10; i++) {
            System.out.println(uniqueWords[i].toString());
        }

        // создаем ещё один массив - частота встречаний слов
        int [] counts = new int [uniqueWords.length];

        // берем каждое слово из списка уникальных
        for (int i = 0; i < uniqueWords.length ; i++) {

           //  берем каждое слово из ОБЩЕГО списка слов, там есть повторения
            for (int j = 0; j < array.length ; j++) {
                //если совпадает count  этого слова увеличивыаем на 1
                if (uniqueWords[i].equals(array[j])){
                    counts[i]++;
                }
            }

        }

        for (int i = 0; i < 10 ; i++) {
            System.out.println(uniqueWords[i] + "  " + counts[i]);
        }

        List<GlossaryItem> words = new ArrayList<>();

        for (int i = 0; i <uniqueWords.length ; i++) {
            words.add(new GlossaryItem(uniqueWords[i].toString(), counts[i]));
        }

        List<GlossaryItem>  sorted = words.stream()
                .sorted(Comparator.comparing(GlossaryItem::getCount).reversed())
                .collect(Collectors.toList());





    }


}
