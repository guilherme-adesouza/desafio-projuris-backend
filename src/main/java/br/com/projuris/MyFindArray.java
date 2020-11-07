package br.com.projuris;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyFindArray implements FindArray {

    @Override
    public int findArray(int[] array, int[] subArray) {
        if (subArray.length == 0 || array.length == 0) return -1;
        return Collections.lastIndexOfSubList(arrayToList(array), arrayToList(subArray));
    }

    private List<Integer> arrayToList(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
    }
}
