package di

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw17_movieapp.R
import model.Film

typealias showFilmDetails = (Int) -> Unit

class ShowAllAdapter(var fragment: Fragment, private var showFilmDetails: showFilmDetails) :
    ListAdapter<Film, ShowAllAdapter.ViewHolder>(DiffCallback) {
//    inner class ViewHolder(
//        private var binding: ShowAllItemBinding
//    ) : RecyclerView.ViewHolder(binding.root) {

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvDate = view.findViewById<TextView>(R.id.tv_date)
        val imageView = view.findViewById<ImageView>(R.id.imageView_bacground)
        val ratingBar = view.findViewById<RatingBar>(R.id.ratingBar)
        val textView = view.findViewById<TextView>(R.id.text)

        //
        fun bind(film: Film, showFilmDetails: showFilmDetails) {
            tvName.text = film.filmName
            tvDate.text = film.voteAverage.toString()

//                btnShow.setOnClickListener {
//                    onShowCityClick?.invoke(City)
//                }
        }
    }
//    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.show_all_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val currentFilm = getItem(position)
//        holder.bind(currentFilm, showFilmDetails)

        holder.tvName.text = getItem(position).filmName
        holder.tvDate.text = getItem(position).voteAverage.toString()
        holder.ratingBar.rating = getItem(position).voteAverage.toFloat() / 2


        Glide.with(fragment)
            .load("https://image.tmdb.org/t/p/w500${getItem(position).imgSrcUrl}")
//            .load(getItem(position).imgSrcUrl)
//            .circleCrop()
            .placeholder(R.drawable.ic_baseline_downloading_24)
            .error(R.drawable.ic_baseline_error_outline_24)
            .into(holder.imageView)


        holder.itemView.setOnClickListener {

//            val bundle = Bundle()
//            bundle.putInt("id", getItem(position).id)
//            fragment.arguments = bundle


            showFilmDetails(getItem(position).id)
        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<Film>() {
        override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem.id == newItem.id
        }
    }
}