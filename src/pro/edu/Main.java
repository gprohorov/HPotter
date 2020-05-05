package pro.edu;

import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        String myString = new String(Files.readAllBytes(Paths.get("/home/george/Desktop/harry.txt")));

        String myString2 = myString
                .toLowerCase()
/*                .replaceAll(",", "")
                .replaceAll("!", "")
                .replaceAll("\\?", "")
                .replaceAll("\\.", "")
                .replaceAll("\"", "")*/
                .replaceAll("[^A-Za-z0-9 ]", "")
                ;

      //  String myStr2=Mystr.replaceAll("[^A-Za-zА-Яа-я0-9 ]", "");
      //  String myString3 = myString2.replaceAll(".", "");


        final String[] array = myString2.split(" ");

        // массив уникальных слов
        String[]   arrayDistinct =  null;



    }


}
