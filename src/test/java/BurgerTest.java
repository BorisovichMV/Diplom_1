import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient1));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        when(bun.getPrice()).thenReturn(100.0f);
        when(ingredient1.getPrice()).thenReturn(50.0f);
        when(ingredient2.getPrice()).thenReturn(30.0f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float price = burger.getPrice();
        assertEquals(280.0f, price, 0.0f);  // 2*bun + ingredient1 + ingredient2
        Mockito.verify(bun).getPrice();
        Mockito.verify(ingredient1).getPrice();
        Mockito.verify(ingredient2).getPrice();
    }

    @Test
    public void testGetReceipt() {
        when(bun.getName()).thenReturn("Sesame bun");
        when(ingredient1.getName()).thenReturn("Cheese");
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("Ketchup");
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(bun.getPrice()).thenReturn(100.0f);
        when(ingredient1.getPrice()).thenReturn(50.0f);
        when(ingredient2.getPrice()).thenReturn(30.0f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedReceipt = "(==== Sesame bun ====)\r\n" +
                "= filling Cheese =\r\n" +
                "= sauce Ketchup =\r\n" +
                "(==== Sesame bun ====)\r\n" +
                "\r\nPrice: 280,000000\r\n";

        assertEquals(expectedReceipt, burger.getReceipt());

        Mockito.verify(bun, Mockito.times(2)).getName();

        Mockito.verify(ingredient1).getName();
        Mockito.verify(ingredient1).getType();
        Mockito.verify(ingredient1).getPrice();

        Mockito.verify(ingredient2).getName();
        Mockito.verify(ingredient2).getType();
        Mockito.verify(ingredient2).getPrice();
    }
}
