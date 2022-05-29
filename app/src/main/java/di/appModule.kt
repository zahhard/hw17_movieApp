package di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import data.FilmRepository
import data.LocalDataSource
import data.RemoteDataSource
import data.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ui.detail.DetailViewModel
import ui.showAll.ShowAllListViewModel
import ui.up_comming.UpCommingFragment
import ui.up_comming.UpCommingViewModel
import java.util.concurrent.TimeUnit

val appModule = module {

    single { FilmRepository(get(), get()) }

    single { RemoteDataSource(get()) }

    single { LocalDataSource() }

    single {


//        var client = new OkHttpClient();
//        client.setConnectTimeout(10, TimeUnit.SECONDS);
//        client.setReadTimeout(30, TimeUnit.SECONDS);
//        client.interceptors().add(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                return onOnIntercept(chain);
//            }
//        });

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .connectTimeout(50, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()

            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
        retrofit
    }

    single {
        val retrofit = get() as Retrofit
        val loginApiService = retrofit.create(ApiService::class.java)

        loginApiService
    }

    viewModel { ShowAllListViewModel (get()) }
    viewModel { DetailViewModel (get()) }
    viewModel { UpCommingViewModel (get()) }
//    viewModel { LoginViewModel (get()) }
//    viewModel { HomeViewModel (get()) }
}