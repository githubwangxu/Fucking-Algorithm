package leetcode.L20;

import java.util.HashMap;
import java.util.Stack;

public class IsValid {
  private Stack<Character> charStack = new Stack<>();
  public static HashMap<Character, Character> charMap = new HashMap<>();

  static {
    charMap.put('(', ')');
    charMap.put('[', ']');
    charMap.put('{', '}');

  }

  public boolean isValid(String s) {
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (charMap.containsKey(ch)) {
        charStack.push(ch);
      } else {
        if (charStack.isEmpty()) {
          return false;
        }
        char pairCh = charStack.pop();
        if (ch != charMap.get(pairCh)) {
          return false;
        }
      }

    }
    return charStack.isEmpty();
  }
}
