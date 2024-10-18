import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {

    Ingredient ingredient;
    IngredientType ingredientType;
    String name;
    Float price;

    public IngredientTest(IngredientType type, String name, Float price) {
        this.ingredient = new Ingredient(type, name, price);
        this.ingredientType = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                { IngredientType.SAUCE, "Ketchup", 50.0f },
                { IngredientType.FILLING, "Cheese", 30.0f },
                { IngredientType.SAUCE, "Mayo", 20.0f },
        };
    }

    @Test
    public void testGetPrice() {
        assertEquals(this.price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void testGetName() {
        assertEquals(this.name, ingredient.getName());
    }

    @Test
    public void testGetType() {
        assertEquals(this.ingredientType, ingredient.getType());
    }
}
