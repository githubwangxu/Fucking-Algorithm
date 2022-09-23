package leetcode.L468;

/**
 * @description: TODO 类描述
 * @author: Jack
 * @date: 2022/9/7 01:34
 **/
public class Solution {
  public static void main(String[] args) {
    //q1:什么时候使用字符需要转义
    String str = "172.16.254.1";

    //表示字符串的话直接双引号使用即可
    System.out.println(str.contains("."));

    //使用在正则表达式里面的时候需要进行转义，因为这个.符号单独在正则表达式中有其特殊的意义，不转义的话默认会使用其代表的特殊意义
    String[] parts = str.split("\\.");
    System.out.println(parts.length);

    String[] part = str.split(".");
    System.out.println(part.length);

  }

  public String validIPAddress(String queryIP) {
    if (queryIP.isEmpty()) {
      return "Neither";
    }
    if (queryIP.contains(".") && validIPV4(queryIP)) {
      return "IPv4";
    }
    if (queryIP.contains(":") && validIPV6(queryIP)) {
      return "IPv6";
    }
    return "Neither";
  }

  private boolean validIPV4(String IP) {
    char start = IP.charAt(0);
    char end = IP.charAt(IP.length() - 1);
    if (!validIPv4Character(start) || !validIPv4Character(end)) {
      return false;
    }

    String[] ipParts = IP.split("\\.");
    if (ipParts.length != 4) {
      return false;
    }
    for (String ipPart : ipParts) {
      if (ipPart.isEmpty() || ipPart.length() > 3) {
        return false;
      }
      if (ipPart.startsWith("0") && ipPart.length() > 1) {
        return false;
      }
      char[] chars = ipPart.toCharArray();
      for (char ch : chars) {
        if (!validIPv4Character(ch)) {
          return false;
        }
      }
      if (Integer.parseInt(ipPart) > 255) {
        return false;
      }
    }
    return true;
  }

  private boolean validIPv4Character(char ch) {
    // if (ch < 48 || ch > 57) 等价与这个判断
    return Character.isDigit(ch);
  }

  private boolean validIPV6(String IP) {
    char start = IP.charAt(0);
    char end = IP.charAt(IP.length() - 1);
    if (!validIPv6Character(start) || !validIPv6Character(end)) {
      return false;
    }
    String[] ipParts = IP.split(":");
    if (ipParts.length != 8) {
      return false;
    }
    for (String ipPart : ipParts) {
      if (ipPart.isEmpty() || ipPart.length() > 4) {
        return false;
      }
      //判断16进制数字是否合法
      char[] chars = ipPart.toCharArray();
      for (char ch : chars) {
        if (!validIPv6Character(ch)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean validIPv6Character(char ch) {
    //处理字母
    if (Character.isAlphabetic(ch)) {
      ch = Character.toLowerCase(ch);
      return ch >= 97 && ch <= 102;
    }
    //处理非数字的情况
    else return Character.isDigit(ch);
  }
}
