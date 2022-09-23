package designpatten.singleton;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/12 14:38
 **/
public class Singleton4InnerClass {
  private Singleton4InnerClass(){}

  public static Singleton4InnerClass obtainInstance(){
    return InnerClass.singletonInstance;
  }


  private static class InnerClass{
    private final static Singleton4InnerClass singletonInstance = new Singleton4InnerClass();
  }

}
