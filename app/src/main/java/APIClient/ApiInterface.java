package APIClient;
import java.util.Map;
import Model.ResponseBookingItem;
import Model.Response_Labs;
import Model.Response_Sheet_Treatment;
import Model.Response_XRay;
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

    @POST("clinic/sheet_treatment")
    Call<Response_Sheet_Treatment> getSheetTreatment(@QueryMap Map<String , String> queryParameters);

    @POST("clinic/sheet_xray")
    Call<Response_XRay> getSheetX_Ray(@QueryMap Map<String , String> queryParameters);

    @POST("clinic/sheet_labs")
    Call<Response_Labs> getSheetLabs(@QueryMap Map<String , String> queryParameters);
}