package GeneralType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lptree
 * @Date: Created in 2018/9/20 6:14
 */
public class TestExtendSuper {

    public static void main(String[] args) {
    }

    private void testExtend() {

        // Number "extends" Number (in this context)
        List<? extends Number> foo3 = new ArrayList<Number>();

// Integer extends Number
        List<? extends Number> foo4 = new ArrayList<Integer>();

// Double extends Number
        List<? extends Number> foo5 = new ArrayList<Double>();
    }

    private void testSuper() {
        // Integer is a "superclass" of Integer (in this context)
        List<? super Integer> foo3 = new ArrayList<Integer>();

// Number is a superclass of Integer
        List<? super Integer> foo4 = new ArrayList<Number>();

// Object is a superclass of Integer
        List<? super Integer> foo5 = new ArrayList<Object>();
    }
}



