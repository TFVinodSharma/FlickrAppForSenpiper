package flickagram.com.flickagram.modules.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import flickagram.com.flickagram.base.BaseResponse;

public class RecyclerResponse extends BaseResponse implements Serializable {

    @SerializedName("photo")
    private ArrayList<Details> details;

    public ArrayList getinformation() {
        return details;
    }

    public void setInformation(ArrayList getinformationRequest) {
        this.details = getinformationRequest;
    }


}
