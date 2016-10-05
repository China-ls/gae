package weixin.popular.bean.card.get;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.card.AbstractCard;

/**
 * @param <T>可以是CreateCash、CreateDiscount、CreateGeneralCoupon、CreateGift、CreateGroupon
 * @author Moyq5
 */
public class GetResult<T extends AbstractCard> extends BaseResult {

    private T card;

    public T getCard() {
        return card;
    }

    public void setCard(T card) {
        this.card = card;
    }
}