package temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class TestNew {
  public static String boy = "a";
  public static String girl = "b";

  public static void main(String[] args) {
    HashMap<String,String> hs = new HashMap<>();
    ArrayList<String> students = new ArrayList<>();
    students.add("b");
    students.add("b");
    students.add("b");
    students.add("a");
    swap(students);
    System.out.println(Arrays.toString(students.toArray()));

    ReentrantLock lock = new ReentrantLock();
    lock.lock();
    lock.unlock();
  }


  public static void swap(ArrayList<String> strs) {
    if (strs.isEmpty()) {
      return;
    }
    int head = 0;
    int tail = strs.size() - 1;

    while (head < tail) {

      while (strs.get(head).equals(boy) && head < tail) {
        head++;
      }
      while (strs.get(tail).equals(girl) && head < tail) {
        tail--;
      }
      if (head >= tail) {
        return;
      }
      strs.set(head, boy);
      strs.set(tail, girl);
      head++;
      tail--;
    }
  }
}
