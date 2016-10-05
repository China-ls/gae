package weixin.popular.bean.card.code.decrypt;


import com.google.gson.annotations.SerializedName;

/**
 * 卡券核销－Code解码接口－请求参数
 *
 * @author Moyq5
 */
public class CodeDecrypt {

    /**
     * 经过加密的Code码。<br>
     * 必填：是
     */
    @SerializedName("encrypt_code")
    private String encryptCode;

    /**
     * @return 经过加密的Code码
     */
    public String getEncryptCode() {
        return encryptCode;
    }

    /**
     * 经过加密的Code码。<br>
     * 必填：是
     *
     * @param encryptCode 经过加密的Code码
     */
    public void setEncryptCode(String encryptCode) {
        this.encryptCode = encryptCode;
    }

}
