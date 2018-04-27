import main.Rule;
import main.Rule1;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RuleTest {

    protected Rule rule;

    @Before
    public void setUp() {
        // Given
        this.rule = new Rule1(1, "A Test Rule Object", "OH", 3, 2);
    }

    @Test
    public void canGetRuleId() {
        // When Then
        assertThat(rule.getId(), is(1));
    }

    @Test
    public void canSetRuleId() {
        // When
        rule.setId(2);

        // Then
        assertThat(rule.getId(), is(2));
    }

    @Test
    public void canGetRuleName() {
        // When Then
        assertThat(rule.getName(), is("A Test Rule Object"));
    }

    @Test
    public void canSetRuleName() {
        // When
        rule.setName("Another name");

        // Then
        assertThat(rule.getName(), is("Another name"));
    }

    @Test
    public void canGetRuleTourId() {
        // When Then
        assertThat(rule.getTourId(), is("OH"));
    }

    @Test
    public void canSetRuleTourId() {
        // When
        rule.setTourId("ZZ");

        // Then
        assertThat(rule.getTourId(), is("ZZ"));
    }
}
