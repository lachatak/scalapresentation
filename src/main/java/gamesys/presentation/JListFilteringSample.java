package gamesys.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JListFilteringSample {

    public static void main(String[] args) {

        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5);

        //work starts
        List<Integer> filteredElements = new ArrayList<Integer>();
        for (Integer element : elements) {
            if (element < 4) {
                filteredElements.add(element);
            }
        }
        //work ends

        System.out.println("filteredElements:" + filteredElements);

    }
}
