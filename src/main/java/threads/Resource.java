package threads;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Resource {
    private String fileName="out.txt";
    volatile int n=0;

    public Resource(int n){
        this.n=n;
    }

    public void createFile (){
          try {
            FileWriter nFile = new FileWriter(fileName, false);
            nFile.write("0");
            nFile.close();
          }
          catch (Exception ex) {
            System.out.println("Не удалось создать файл");
          }
    }

    synchronized public boolean writeIn(String nameThread){
        try {
            FileReader fr = new FileReader(fileName);
            Scanner scan = new Scanner(fr);
            String text = scan.nextLine();
            int number=Integer.parseInt(text);
            if (number==n) return false;
            int newNumber=number+1;
            fr.close();
            System.out.println("Старое значение "+number+ " Новое значение "+newNumber+" "+ nameThread);
            FileWriter nFile = new FileWriter(fileName, false);
            nFile.write(Integer.toString(newNumber));
            nFile.close();
        }
        catch(Exception ex){
            System.out.println("Проблемы при чтении файла");
        }
        return true;
    }

    public void readFile(){
        try {
            FileReader fr = new FileReader(fileName);
            Scanner scan = new Scanner(fr);
            String text = scan.nextLine();
            int number=Integer.parseInt(text);
            fr.close();
            System.out.println("Содержимое файла "+number);
        }
        catch(Exception ex){
            System.out.println("Проблемы при чтении файла");
        }
    }
}
