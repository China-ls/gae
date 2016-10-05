package weixin.popular.bean.card.qrcode.create;


import com.google.gson.annotations.SerializedName;

/**
 * @author Moyq5
 */
public class ActionInfoMultiple {

    @SerializedName("multiple_card")
    private ActionInfoMultipleCard multipleCard;

    public ActionInfoMultipleCard getMultipleCard() {
        return multipleCard;
    }

    public void setMultipleCard(ActionInfoMultipleCard multipleCard) {
        this.multipleCard = multipleCard;
    }
}
