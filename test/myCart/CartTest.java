package myCart;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CartTest {
    @Test
    public void testTotalNumOfItemsInCart(){
        Cart ct = new Cart();
        ct.put("1234");
        ct.put("1234");
        ct.put("3456");
        ct.put("3456");
        ct.put("3456");
        ct.put("3456");
        ct.put("7891");

        int totalNum1 = ct.getTotalNumOfItemsInCart("1234");
        assertEquals(2, totalNum1);

        int totalNum2 = ct.getTotalNumOfItemsInCart("3456");
        assertEquals(4, totalNum2);

        int totalNum3 = ct.getTotalNumOfItemsInCart("7891");
        assertEquals(1, totalNum3);
    }

    @Test
    public void testTotalPrice(){
        Cart ct = new Cart();
        PriceManager pm = mock(PriceManager.class);
        when(pm.getPrice("1234")).thenReturn(1000);
        when(pm.getPrice("7896")).thenReturn(800);
        ct.setPriceManager(pm);
        ct.put("1234");
        int total = ct.totalPrice();
        assertEquals(1000, total);
        ct.put("7896");
         total = ct.totalPrice();
        assertEquals(1800, total);
    }
    @Test
    public void testTotalPriceForOnePlusOneItems(){
        Cart ct = new Cart();
        PriceManager pm = mock(PriceManager.class);
        when(pm.getPrice("1234")).thenReturn(1000);
        when(pm.getPrice("3456")).thenReturn(2500);
        when(pm.getPrice("7896")).thenReturn(800);
        when(pm.isOnePlusOneApplicable("1234")).thenReturn(false);
        when(pm.isOnePlusOneApplicable("7896")).thenReturn(false);
        when(pm.isOnePlusOneApplicable("3456")).thenReturn(true);
        ct.setPriceManager(pm);
        ct.put("1234");
        int total = ct.totalPrice();
        assertEquals(1000, total);
        ct.put("7896");
        total = ct.totalPrice();
        assertEquals(1800, total);
        ct.put("3456");
        ct.put("3456");
        total = ct.totalPrice();
        assertEquals(4300, total);
    }
}
