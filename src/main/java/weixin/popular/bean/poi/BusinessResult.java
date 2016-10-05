package weixin.popular.bean.poi;


import com.google.gson.annotations.SerializedName;

/**
 * 门店信息－响应对象
 *
 * @author Moyq5
 */
public class BusinessResult {

    @SerializedName("base_info")
    private BaseInfoResult baseInfo;

    public BaseInfoResult getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfoResult baseInfo) {
        this.baseInfo = baseInfo;
    }
}
