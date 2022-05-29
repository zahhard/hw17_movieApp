package ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.hw17_movieapp.R
import com.example.hw17_movieapp.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val bundle = this.arguments

//        val bundle = Bundle()
//        var s :Int? = null
//        s = bundle!!.getInt("id", -1).toInt()

       detailViewModel.getFilmDetail (requireArguments().getInt("filmId", -1))

        detailViewModel.filmLiveData.observe(viewLifecycleOwner) {
            binding.tvOverView.text = it.overview
            binding.textViewName.text = it.filmName

            setImage(it.imgSrcUrl, binding.imageViewPoster)
            setImage(it.backgroundImgUrl, binding.imageViewBacground)
        }

    }


    fun setImage(url: String, view: ImageView) {
        Glide.with(this)

            .load("https://image.tmdb.org/t/p/w500$url")
//            .load(url)
//            .circleCrop()
            .placeholder(R.drawable.ic_baseline_downloading_24)
            .error(R.drawable.ic_baseline_error_outline_24)
            .into(view)
    }

}