package APIClient;
public class ServicesConnection {
    public static final String PATCH = "PATCH";
    public static final String CONTENT_TYPE = "application/json";
    public static final String BASE_URL = "https://apex1-eu-uk.revion.com/ords/marvel/";
    private static ApiInterface apiInterface = null;
    private ServicesConnection() {
    }
    public static ApiInterface GetService() {
        if (apiInterface == null) {
            apiInterface = ApiClient.getClient().create(ApiInterface.class);
        }
        return apiInterface;
    }
}