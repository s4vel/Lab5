import exeptions.NoSaveFileExeption;
import system.Coll;
import system.FilleOperation;
import system.UserInteraction;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Laba5 {

    public static void main(String[] args)  {
        try {
            if(args.length==0) throw new NoSaveFileExeption();
            String fillname = args[0];
            Coll collection = new Coll();
            collection=FilleOperation.getFromFile(fillname);
            collection.setLastInitTime(LocalDateTime.now());
            Scanner in = new Scanner(System.in);
            UserInteraction.getComand(in, collection, fillname);
        }
        catch (NoSaveFileExeption e)
        {
            System.out.println("Необходимо при запуске програмы в аргументах указать файл для загрузки!");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Загрузочный файл не найден!");
        }
    }

}
