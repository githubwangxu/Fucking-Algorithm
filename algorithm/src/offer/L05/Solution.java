package offer.L05;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/16 21:51
 **/
public class Solution {
  //最简单的实际的方法
  public String replaceSpace(String s) {
    return s.replace(" ", "%20");
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().replaceSpace("We are happy."));
  }
}

class Solution2{
  public String replaceSpace(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    for (char ch : s.toCharArray()){
      if (ch == ' '){
        stringBuilder.append("%20");
      }else {
        stringBuilder.append(ch);
      }
    }
    return stringBuilder.toString();
  }
}
