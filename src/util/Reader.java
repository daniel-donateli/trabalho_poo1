package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Daniel Tadeu Donateli
 */
public class Reader {
    /**
     * @param fileName nome do arquivo a ser lido.
     * @return retorna uma lista de Strings onde cada elemento é uma 
     * linha do arquivo de texto.
     */
    public static List<String> readFile(String fileName) {
        try {
            ArrayList<String> list = new ArrayList();
            File arq = new File(fileName);
            Scanner reader = new Scanner(arq, "UTF-8");
            while(reader.hasNextLine()) {
                list.add(reader.nextLine());
            }
            return Collections.unmodifiableList(list);
        } catch(FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
        return null;
    }
}
