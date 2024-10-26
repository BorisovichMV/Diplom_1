import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.bun = new Bun(name, price);
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                { "White bun", 100.0f },
                { "Sesame bun", 120.0f }
        };
    }

    @Test
    public void testGetPrice() {
        assertEquals(this.price, bun.getPrice(), 0.0f);
    }

    @Test
    public void testGetName() {
        assertEquals(this.name, bun.getName());
    }
}
