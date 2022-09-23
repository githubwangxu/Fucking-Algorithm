package thread;

import java.util.HashMap;
import java.util.Scanner;

public class InterruptTest {
  public static void main(String[] args) {
    HashMap map = new HashMap();

    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()){
      System.out.println(scanner.next());
    }

    Thread thread = new Thread(() -> {
      System.out.println("thread before");
      try {
        Thread.sleep(3000);
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("thread after");
    });

    thread.start();

    //main 相关的输出是空线程控制
    System.out.println("main begin！");

//    thread.join();

    System.out.println("main end！");
  }
}
