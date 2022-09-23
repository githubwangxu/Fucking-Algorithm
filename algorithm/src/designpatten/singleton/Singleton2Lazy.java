package designpatten.singleton;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/12 14:30
 **/
public class Singleton2Lazy {
  private static Singleton2Lazy singletonLazy;

  private Singleton2Lazy() {

  }

  //线程不安全
  public static Singleton2Lazy obtainInstanceNoSafe() {
    if (singletonLazy == null) {
      singletonLazy = new Singleton2Lazy();
    }
    return singletonLazy;
  }

  //线程安全
  public static synchronized Singleton2Lazy obtainInstanceSafe() {
    if (singletonLazy == null) {
      singletonLazy = new Singleton2Lazy();
    }
    return singletonLazy;
  }
}
