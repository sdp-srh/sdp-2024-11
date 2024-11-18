package datatypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArraysExample {
	
   public static void main(String[] args) throws NumberFormatException, IOException {
        String[] strArr = {"One", "Two", "Three"};
        String[] strArr1 = new String[3];
        strArr1[0] = "1";
        strArr1[1] = "two";
        strArr1[2] = "3";
        String[] strArr2 = null;
        System.out.println("Array elements are:");
        // Iterate over array
        for (int i=0;i<strArr.length;i++)
        {
            System.out.println(strArr[i]);
        }
        System.out.println("");

        for (int i=0;i<strArr1.length;i++)
        {
            System.out.println(strArr1[i]);
        }
        
        for (String s : strArr1) {
        	System.out.println(s);
        }
    }

}
