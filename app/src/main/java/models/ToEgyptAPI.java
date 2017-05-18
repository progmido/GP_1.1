package models;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by root on 5/17/17.
 */

public interface ToEgyptAPI {

    @GET("/odata/users?$filter=type_id%20eq%202")
    Call<ResultUserSet> getUsers();

    @GET("/odata/users({id})/country")
    Call<country> getCountry(@Path("id") int id);

    @DELETE("/odata/users({id})")
    Call<Void> deleteUser(@Path("id") int userId);

    @GET("/odata/users?$filter=username%20eq%20%27kako%20dola%27%20and%20password%20eq%20%27321%27")
    Call<ResultUserSet> login();

    //@FormUrlEncoded
    @POST("/odata/users?fullname='{fullname}'&username='{username}'&email='{email}'&password='{password}'&age={age}&phonenumber={phonenumber}&type_id={type_id}&gender={gender}&country_id={country_id}&photo_path='{photo_path}'")
    Call<ResponseBody> adduser(@Path("fullname") String fullname,
                               @Path("username") String username,
                               @Path("email") String email,
                               @Path("password") String password,
                               @Path("age") int age,
                               @Path("phonenumber") int phonenumber,
                               @Path("type_id") int type_id,
                               @Path("gender") boolean gender,
                               @Path("country_id") int country_id,
                               @Path("photo_path") String photo_path);
    //string fullname, string username, string email, string password, int age, decimal phonenumber, int type_id, bool gender, int country_id, string photo_path
    //@Path(value = "username",encoded = true) String username,@Path(value = "password",encoded = true) String password
///odata/users?$filter=username%20eq%20%27kako%20dola%27%20and%20password%20eq%20%27321%27
    //void deleteUser(@Path("id") int userId, Callback<Response> callback);

}

