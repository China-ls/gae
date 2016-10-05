package weixin.popular.bean.poi;

import com.google.gson.annotations.SerializedName;

/**
 * 门店图片信息
 *
 * @author Moyq5
 */
public class Photo {

    @SerializedName("photo_url")
    private String photoUrl;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
