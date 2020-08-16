package org.jessica.me.algo.stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 类Solution的实现描述：
 *
 * @author duyaoguang 2020/8/16 9:44 上午
 */
public class Solution {


    public static void main(String[] args) {
        String str = "{}{[]}()";
        System.out.println("1 " +check(str));
        str = "(((((())))))]]";
        System.out.println("2 "+ check(str));
        str = "()[]";
        System.out.println("3 "+check(str));
        str = "([)]";
        System.out.println("4 "+ check(str));
        str = "((([[))";
        System.out.println("5 "+check(str));
        str = "]][[";
        System.out.println("6 "+check(str));
    }

    public static boolean check(String str) {
        Stack<Character> s = new Stack<Character>();

        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {  //左括号,push到stack
                s.push(c);
            }
            if (map.containsValue(c)) { //右括号
                if (s.isEmpty()) {//从stack中pop对应的左括号,stack为空则校验失败
                    System.out.println("failed check with " + c);
                    return false;
                }

                Character o = s.pop();
                if (map.get(o).charValue() != c) {   //从stack中pop出左括号,进行对比
                    System.out.println("failed check with " + c);
                    return false;
                }
            }
        }

        return true;

    }

}
