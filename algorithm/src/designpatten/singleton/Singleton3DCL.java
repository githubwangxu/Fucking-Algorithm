package designpatten.singleton;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/12 14:34
 **/
public class Singleton3DCL {
  private Singleton3DCL() {
  }

  private static volatile Singleton3DCL singletonInstance;

  public static Singleton3DCL obtainInstance() {
    if (singletonInstance == null) {
      synchronized (Singleton3DCL.class) {
        if (singletonInstance == null) {
          //new 的操作不是原子操作
          singletonInstance = new Singleton3DCL();
        }
      }
    }
    return singletonInstance;
  }
}
