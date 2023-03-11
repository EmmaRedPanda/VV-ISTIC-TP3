package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
  
  @org.junit.jupiter.api.Test
    void monTest(){
        assertTrue(isBalanced(""));
        assertTrue(isBalanced("Hello"));
        assertTrue(isBalanced("This is a [test]!"));
        assertTrue(isBalanced("()"));
        assertTrue(isBalanced("{}"));
        assertTrue(isBalanced("[]"));
        assertFalse(isBalanced("("));
        assertFalse(isBalanced(")"));
        assertFalse(isBalanced("{"));
        assertFalse(isBalanced("}"));
        assertFalse(isBalanced("["));
        assertFalse(isBalanced("]"));
        assertFalse(isBalanced("()("));
        assertFalse(isBalanced("[[[[[["));
        assertFalse(isBalanced("(]"));
        assertFalse(isBalanced("{[}]"));
        assertTrue(isBalanced("{ [ ( ) ] }"));
        assertTrue(isBalanced("[{}](){}"));
    }

}
