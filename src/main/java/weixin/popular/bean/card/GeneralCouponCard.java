package weixin.popular.bean.card;


import com.google.gson.annotations.SerializedName;

/**
 * 优惠券
 *
 * @author Moyq5
 */
public class GeneralCouponCard extends AbstractCard {

    @SerializedName("general_coupon")
    private GeneralCoupon generalCoupon;

    public GeneralCouponCard() {
        super("GENERAL_COUPON");
    }

    public GeneralCoupon getGeneralCoupon() {
        return generalCoupon;
    }

    public void setGeneralCoupon(GeneralCoupon generalCoupon) {
        this.generalCoupon = generalCoupon;
    }

}
