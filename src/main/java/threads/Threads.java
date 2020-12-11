package threads;

import java.util.Scanner;

public class Threads {

    public static void main(String[] args) {
        System.out.println("Введите целое число кратное 2");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n;
        try {
            n = Integer.parseInt(str);
            if(n%2!=0 || n==0) throw new NumberFormatException();
            Resource res=new Resource(n);
            res.createFile();
            NewThread thread1=new NewThread("Поток 1", res);
            NewThread thread2=new NewThread("Поток 2",res);
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            res.readFile();
        }
        catch (NumberFormatException e) {
            System.out.println("Неверный формат");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
