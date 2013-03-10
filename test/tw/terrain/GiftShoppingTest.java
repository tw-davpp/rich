package tw.terrain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GiftShoppingTest {
    @Test
    public void test_choose_gift() {
        GiftShopping shop = new GiftShopping();
        assertThat(shop.chooseGift(1), is(ChooseAward.class));
        assertThat(shop.chooseGift(2), is(ChooseCredit.class));
        assertThat(shop.chooseGift(3), is(ChooseMascot.class));
    }
}
