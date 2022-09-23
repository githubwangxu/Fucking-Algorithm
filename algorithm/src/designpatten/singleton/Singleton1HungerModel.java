package designpatten.singleton;

import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 * @description: 饿汉式的单例模式
 * @author: Jack
 * @date: 2022/9/12 14:19
 **/
public class Singleton1HungerModel {

  //私有构造器防止别的类创建该类对象
  private Singleton1HungerModel() {
  }

  private final static Singleton1HungerModel singletonInstance = new Singleton1HungerModel();

  public static Singleton1HungerModel obtainInstance() {
    return singletonInstance;
  }
}
