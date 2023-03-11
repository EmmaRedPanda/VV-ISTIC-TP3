package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
  
    @org.junit.jupiter.api.Test
    void isEmpty(){
        assertTrue(isBalanced(""));
    }

    @org.junit.jupiter.api.Test
    void nestedBalanced(){
        assertTrue(isBalanced("[{}](){}"));
    }

    @org.junit.jupiter.api.Test
    void openingUnbalanced(){
        assertFalse(isBalanced("{"));
    }
    @org.junit.jupiter.api.Test
    void closingUnbalanced(){
        assertFalse(isBalanced("}"));
    }
    @org.junit.jupiter.api.Test
    void nestedUnbalanced(){
        assertFalse(isBalanced("{[}]"));
    }

}
