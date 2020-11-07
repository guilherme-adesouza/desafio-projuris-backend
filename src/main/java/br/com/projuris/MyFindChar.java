package br.com.projuris;

public class MyFindChar implements FindChar {
    @Override
    public char findChar(String word) {
        for (Character ch : word.toCharArray()) {
            if (word.indexOf(ch) == word.lastIndexOf(ch)) {
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }
}
