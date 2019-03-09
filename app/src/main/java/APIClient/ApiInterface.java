package APIClient;
import java.util.Map;

import Model.ResponseBookingItem;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    @POST("clinic/patient")
    Call<String> login(@Body String body, @Header("Content-Type") String content_type);

    @GET("clinic/appointment")
    Call<ResponseBookingItem> getBookingHistory(@QueryMap Map<String , String> queryParameters);
}
