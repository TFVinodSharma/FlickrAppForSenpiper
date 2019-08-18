package flickagram.com.flickagram.network.service;

import flickagram.com.flickagram.modules.model.RecyclerResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FlickGarmService {

@GET("?method=flickr.photos.search&api_key=1ac300f2214f8054bdade048fa5a1137&content_type=1&nojsoncallback=1&is_getty=true&format=json&per_page=5&page=0")
    Call<RecyclerResponse> getinformation();
}
