package ui.showAll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw17_movieapp.R
import com.example.hw17_movieapp.databinding.FragmentShowAllBinding
import di.ShowAllAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class ShowAllFragment : Fragment() {
    private lateinit var binding: FragmentShowAllBinding
    val homeViewModel : ShowAllListViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowAllBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.getAllFilms()

        homeViewModel.filmListLiveData.observe(viewLifecycleOwner){
            if (it!= null){
//                var adapter = ShowAllAdapter({})
//                binding.recyclerview.adapter = adapter
//                adapter.submitList(it.filmList)

                val manager = LinearLayoutManager(requireContext())
                binding.recyclerview.setLayoutManager(manager)
//                binding.recyclerview.setHasFixedSize(true)
                var adapter = ShowAllAdapter(this) { id -> goToDetailPage(id) }
                adapter.submitList(it.filmList)
                binding.recyclerview.setAdapter(adapter)
            }
        }
    }

    private fun goToDetailPage(id: Int) {
        val bundle = bundleOf("filmId" to id)
//        homeViewModel.setFilmSelected(Integer.parseInt(binding.text.text.toString()))
        findNavController().navigate(R.id.action_showAllFragment_to_detailFragment, bundle)
    }

}