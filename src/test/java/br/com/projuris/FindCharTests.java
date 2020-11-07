package br.com.projuris;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FindCharTests {

    @Test
    void withoutMatches() {
        MyFindChar finder = new MyFindChar();
        assertThat(finder.findChar("osso")).isEqualTo(Character.MIN_VALUE);
    }

    @Test
    void withMatch() {
        MyFindChar finder = new MyFindChar();
        assertThat(finder.findChar("stress")).isEqualTo('t');
    }

    @Test
    void withMultipleMatches() {
        MyFindChar finder = new MyFindChar();
        assertThat(finder.findChar("reembolsar")).isEqualTo('m');
    }
}
