package weixin.popular.bean.card.qrcode.create;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Moyq5
 */
public class ActionInfoMultipleCard {

    @SerializedName("card_list")
    List<ActionInfoMultipleCardItem> cardList;

    public List<ActionInfoMultipleCardItem> getCardList() {
        return cardList;
    }

    public void setCardList(List<ActionInfoMultipleCardItem> cardList) {
        this.cardList = cardList;
    }
}
