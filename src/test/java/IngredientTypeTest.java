import org.junit.Test;
import static org.junit.Assert.*;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues() {
        IngredientType[] expectedValues = {IngredientType.SAUCE, IngredientType.FILLING};
        assertArrayEquals(expectedValues, IngredientType.values());
    }

    @Test
    public void testIngredientTypeValueOf() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIngredientTypeValueOfInvalid() {
        IngredientType.valueOf("INVALID");
    }
}
