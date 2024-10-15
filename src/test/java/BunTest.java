import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Bun mockBun;
    Bun realBun = new Bun("Булка", 5);


    @Test
    public void getNameTest() {
        mockBun.getName();
        Mockito.verify(mockBun).getName();
    }

    @Test
    public void bunGetNameForReceipt() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.getReceipt();
        Mockito.verify(mockBun, Mockito.times(2)).getName();
    }

    @Test
    public void bunGetPriceForBurgerPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.getPrice();
        Mockito.verify(mockBun).getPrice();
    }

    @Test
    public void bunGetPriceForReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.getReceipt();
        Mockito.verify(mockBun).getPrice();
    }

    @Test
    public void getRealNameTest() {
        Assert.assertEquals("Булка", realBun.getName());
    }

    @Test
    public void getRealPriceTest() {
        Assert.assertEquals(5, realBun.getPrice(), 0.0);
    }
}
