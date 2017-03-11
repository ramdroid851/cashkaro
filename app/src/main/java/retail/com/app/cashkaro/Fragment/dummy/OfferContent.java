package retail.com.app.cashkaro.Fragment.dummy;

import java.util.ArrayList;
import java.util.List;

import retail.com.app.cashkaro.R;

/**
 * Helper class for providing sample offerText for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class OfferContent {
    public static int[] logos = {R.drawable.amazon_logo, R.drawable.flipkart_logo_icon, R.drawable.jabong_logo, R.drawable.ebay};
    public static String[] offersString = {"Home Shopping Spree: Upto 60% Off Across Categories. Save Now",
            "On Top All Flipkart Coupons Earn upto 7.5% EXTRA cashback Rewards", "Shop at Jabong Over Rs 700 & Earn Flat Rs 300 Cashback"
            , "Holi Store: Upto 30% OFf  + Upto 5.25% EXTRA Cashback. Shop Now"
    };
    public static String[] availableString = {"26 More Offers Available ", "21 More Offers Available ", "33 More Offers Available ", "16 More Offers Available "};
    /**
     * An array of sample (dummy) items.
     */
    public static final List<OfferItem> ITEMS = new ArrayList<OfferItem>();

    private static final int COUNT = 10;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(OfferItem item) {
        ITEMS.add(item);
    }

    private static OfferItem createDummyItem(int position) {
        return new OfferItem(logos[position % 4], offersString[position % 4], availableString[position % 4]);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore moreOffers information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of offerText.
     */
    public static class OfferItem {
        public final int imageId;
        public final String offerText;
        public final String moreOffers;

        public OfferItem(int id, String content, String details) {
            this.imageId = id;
            this.offerText = content;
            this.moreOffers = details;
        }

        @Override
        public String toString() {
            return offerText;
        }
    }
}
