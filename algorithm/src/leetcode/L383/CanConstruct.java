package leetcode.L383;

import java.util.HashMap;

public class CanConstruct {
  private HashMap<Character, Integer> hashTable = new HashMap<>();

  /**
   * 方法一 ： 使用HashTable
   *
   * @param ransomNote
   * @param magazine
   * @return
   */
  public boolean canConstruct(String ransomNote, String magazine) {
    if (magazine.length() < ransomNote.length()) {
      return false;
    }
    for (char c : magazine.toCharArray()) {
      Integer frequent = hashTable.getOrDefault(c, 0);
      hashTable.put(c, frequent + 1);
    }

    for (char c : ransomNote.toCharArray()) {
      Integer frequent = hashTable.get(c);
      if (frequent == null || frequent == 0) {
        return false;
      }
      hashTable.put(c, frequent - 1);
    }
    return true;
  }

  public boolean canConstruct2(String ransomNote, String magazine) {
    if (magazine.length() < ransomNote.length()) {
      return false;
    }
    int[] chars = new int[26];
    for (char c : magazine.toCharArray()) {
      chars[c - 'a']++;
    }
    for (char c : ransomNote.toCharArray()) {
      if (chars[c - 'a']-- < 0) {
        return false;
      }
    }
    return true;
  }

}
