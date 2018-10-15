import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private static Product p;
    private static ArrayList<Integer> list;
    @BeforeAll
     static void initProduct(){
        p=new Product();
        list=new ArrayList<Integer>();
    }
    @BeforeEach
    void clearList(){
        list.clear();
    }

    @Test
    void productOfOnes(){
        for (int i=0;i<10;i++){
            list.add(1);
        }
        assertEquals(1,p.product(list),()->"Failure on the product of zeros");
    }

    @org.junit.jupiter.api.Test
    void product() {
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(3);
        assertEquals(36, p.product(list));
    }
    @org.junit.jupiter.api.Test
    void productEqual() {
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(1);
        assertEquals(27, p.product(list));
    }
    @Test
    void productWithZero(){
        for(int i=-10;i<=0;i++){
            list.add(i);
        }

        assertEquals(0,p.product(list),()->"Failure on the product of zeros");
    }
    @Test
    void product2(){
        for(int i=-10;i<=10;i++){
            list.add(i);
        }

        assertEquals(720,p.product(list),()->"Failure on the list with negative and positive integers");
    }
    @Test
    void negativeProduct(){
        list.add(10);
        list.add(10);
        list.add(-5);
        list.add(-10);
        list.add(-1);
        assertEquals(-100,p.product(list),()->"Negative product fails");
    }

    @Test
    void empty(){
        assertFalse(p.isValid(list), () -> "Empyt list does not return false");
    }

    @Test
    void oneElem(){
        list.add(1);
        assertFalse(p.isValid(list), () -> "List with one element does not return false");
    }
    @Test
    void threeElem(){
        list.add(1);
        list.add(1);
        list.add(1);
        assertTrue(p.isValid(list),()->"List with three elements does not return true");
    }

    @Test
    void manyElem(){
        for(int i=-10;i<=10;i++){
            list.add(i);
        }
        assertTrue(p.isValid(list),()->"List with many elements does not return true");
    }

    @Test
    void runShort(){
        Throwable exception = assertThrows(IllegalArgumentException.class,()->{
            p.run(list);
        },()->"Failed to thrown IllegalArgumentException on list with 0 elements");
        assertEquals("List too short",exception.getMessage());
    }

    @Test
    void runShort1(){
        list.add(1);
        Throwable exception = assertThrows(IllegalArgumentException.class,()->{
            p.run(list);
        },()->"Failed to thrown IllegalArgumentException on list with 1 element");
        assertEquals("List too short",exception.getMessage());
    }
    @Test
    void runShort2(){
        list.add(1);
        list.add(1);
        Throwable exception = assertThrows(IllegalArgumentException.class,()->{
            p.run(list);
        },()->"Failed to thrown IllegalArgumentException on list with 2 elements");
        assertEquals("List too short",exception.getMessage());
    }

    @Test
    void run(){
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(3);
        assertEquals(36, p.run(list));

    }
}