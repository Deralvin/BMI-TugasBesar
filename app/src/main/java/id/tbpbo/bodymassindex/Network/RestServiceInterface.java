package id.tbpbo.bodymassindex.Network;
import id.tbpbo.bodymassindex.Model.BMI.BmiCheck;
import id.tbpbo.bodymassindex.Model.Category.CategoryModel;
import id.tbpbo.bodymassindex.Model.History.HistoryModel;
import id.tbpbo.bodymassindex.Model.Login.LoginModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface RestServiceInterface {

    @FormUrlEncoded
    @POST("api/bmi-check")
    Call<BmiCheck> checkBmi(@Field("nama") String name,
                            @Field("berat_badan") String bb,
                            @Field("tinggi_badan") String tb,
                            @Field("umur") String age,
                            @Field("gender") String gender);
    @GET("api/category")
    Call<CategoryModel> checkCategory ();

    @FormUrlEncoded
    @POST("api/auth/login")
    Call<LoginModel> loginApi(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("api/bmi-check/{id}")
    Call<HistoryModel> getHistory(
            @Path("id") long id
    );




}
