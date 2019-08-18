package flickagram.com.flickagram.modules.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import flickagram.com.flickagram.modules.model.RecyclerResponse;
import flickagram.com.flickagram.network.manager.FlickGramRetrofitManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewModel  extends ViewModel {

    private MutableLiveData<RecyclerResponse> recyclerViewModelMutableLiveData;

    public MutableLiveData<RecyclerResponse> getinformation() {
        recyclerViewModelMutableLiveData = new MutableLiveData();
        getInformationData();

        return recyclerViewModelMutableLiveData;


    }

    private void getInformationData() {
        FlickGramRetrofitManager.FLICK_SERVICE.getinformation().enqueue(new Callback<RecyclerResponse>() {
            @Override
            public void onResponse(Call<RecyclerResponse> call, Response<RecyclerResponse> response) {
                RecyclerResponse recyclerResponse = response.body();
                if (response.isSuccessful()) {
                    recyclerViewModelMutableLiveData.setValue(recyclerResponse);
                } else {
                    recyclerViewModelMutableLiveData.setValue(recyclerResponse);
                }
            }

          /*  @Override
            public void onFailure(Call<RecyclerResponse> call, Throwable t) {

            }*/

            @Override
            public void onFailure(Call<RecyclerResponse> call, Throwable t) {
                RecyclerResponse recyclerResponse = new RecyclerResponse();
                recyclerViewModelMutableLiveData.setValue(recyclerResponse);
            }
        });
    }


}
