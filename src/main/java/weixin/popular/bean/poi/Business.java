package weixin.popular.bean.poi;

import com.google.gson.annotations.SerializedName;

/**
 * 门店信息－提交对象
 *
 * @author Moyq5
 */
public class Business {

    @SerializedName("base_info")
    private BaseInfo baseInfo;

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }
}
