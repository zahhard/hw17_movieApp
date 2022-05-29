package data.network

import model.Film
import model.Films
import retrofit2.http.*
import java.nio.file.attribute.UserDefinedFileAttributeView


const val API_KTY = "8615e332ad100989dfaaba4d95fa88c7"

interface ApiService {

    @GET("movie/popular")
    suspend fun getFilmList(
        @Query("api_key") key : String = API_KTY,
        @Query("page") page : Int = 1
    ) : Films

    @GET("movie/m")
    suspend fun getUpComingFilmList(
        @Query("api_key") key : String = API_KTY,
        @Query("page") page : Int = 1
    ) : Films

    @GET("movie/{movie_id}")
    suspend fun getFilmDetail(
        @Path(value = "movie_id") filmId : Int,
        @Query("api_key") apiKey : String = API_KTY
    ) : Film

//    @POST("users")
//    suspend fun register(@Body user : User) : User
//
//    @GET("users/{id}")
//    suspend fun getUser(@Path("id") id: String): User
//
//    @GET("Users")
//    suspend fun getUserList() : List<User>
//
//    @FormUrlEncoded
//    @PUT("users/{id}")
//    suspend fun updateState(
//        @Path("id") roomId: String?,
//        @Field("status") state: String?
//    ): User
}