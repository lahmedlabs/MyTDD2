package myCart;

public interface PriceManager {
    public int getPrice(String id);
    public boolean isOnePlusOneApplicable(String id);
}
