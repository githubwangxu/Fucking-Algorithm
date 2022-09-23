package thread;

import java.util.concurrent.*;

public class ThreadTest {
  public void threadPoolTest() {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(
        5,
        10,
        100L,
        TimeUnit.MINUTES,
        new LinkedBlockingDeque<>(100)
    );
    executor.execute(()->{
      System.out.println("haha");
    });

    Future future =  executor.submit(()->{});


    Executors.newFixedThreadPool(2);
  }
}
