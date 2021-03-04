package myCart;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;



public class CartTestWithMock {
    @Mock
    PriceManager pm;
    @InjectMocks
    Cart ct;
    @Test
    public void testTotalPriceForOnePlusOneItemsWithMock(){
//        Cart ct = new Cart();
//        PriceManager pm = mock(PriceManager.class);
        MockitoAnnotations.initMocks(this);
        when(pm.getPrice("1234")).thenReturn(1000);
        when(pm.getPrice("3456")).thenReturn(2500);
        when(pm.getPrice("7896")).thenReturn(800);
        when(pm.isOnePlusOneApplicable("1234")).thenReturn(false);
        when(pm.isOnePlusOneApplicable("7896")).thenReturn(false);
        when(pm.isOnePlusOneApplicable("3456")).thenReturn(true);
//        ct.setPriceManager(pm);
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
