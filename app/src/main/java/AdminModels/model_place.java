package AdminModels;

/**
 * Created by Abu-elhassan on 5/11/2017.
 */

public class model_place {
    Integer image;
    String placeName;
    String placeDescription;

    public model_place(Integer image, String placeName, String placeDescription) {
        this.image = image;
        this.placeName = placeName;
        this.placeDescription = placeDescription;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }
}
