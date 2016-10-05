package weixin.popular.bean.card;


import com.google.gson.annotations.SerializedName;

/**
 * 优惠券
 *
 * @author Moyq5
 */
public class GeneralCoupon extends AbstractInfo {

    /**
     * 填写优惠详情。<br>
     * 添加必填，不支持修改
     */
    @SerializedName("default_detail")
    private String defaultDetail;

    /**
     * 填写优惠详情。
     */
    public String getDefaultDetail() {
        return defaultDetail;
    }

    /**
     * 填写优惠详情。<br>
     * 添加必填，不支持修改
     */
    public void setDefaultDetail(String defaultDetail) {
        this.defaultDetail = defaultDetail;
    }

}
