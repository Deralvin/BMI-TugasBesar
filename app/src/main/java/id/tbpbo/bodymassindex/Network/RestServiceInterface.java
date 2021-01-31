package id.tbpbo.bodymassindex.Network;
import id.tbpbo.bodymassindex.Model.BMI.BmiCheck;
import id.tbpbo.bodymassindex.Model.Category.CategoryModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


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


}
