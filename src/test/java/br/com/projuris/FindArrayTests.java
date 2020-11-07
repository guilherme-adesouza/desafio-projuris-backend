package br.com.projuris;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FindArrayTests {
    @Test
    void emptyArrays() {
        MyFindArray finder = new MyFindArray();
        assertThat(finder.findArray(new int[] {}, new int[] {8,9,10})).isEqualTo(-1);
        assertThat(finder.findArray(new int[] {8,9,10}, new int[] {})).isEqualTo(-1);
    }

    @Test
    void withoutMatches() {
        MyFindArray finder = new MyFindArray();
        assertThat(finder.findArray(new int[] {7,8,9}, new int[] {8,9,10})).isEqualTo(-1);
    }

    @Test
    void withMatch() {
        MyFindArray finder = new MyFindArray();
        assertThat(finder.findArray(new int[] {4,9,3,7,8}, new int[] {3,7})).isEqualTo(2);
        assertThat(finder.findArray(new int[] {1,3,5}, new int[] {1})).isEqualTo(0);
    }

    @Test
    void withMutipleMatches() {
        MyFindArray finder = new MyFindArray();
        assertThat(finder.findArray(new int[] {4,9,3,7,8,3,7,1}, new int[] {3,7})).isEqualTo(5);
    }
}
