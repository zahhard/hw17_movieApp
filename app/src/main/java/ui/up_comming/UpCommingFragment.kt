package ui.up_comming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.hw17_movieapp.R
import com.example.hw17_movieapp.databinding.FragmentShowAllBinding
import com.example.hw17_movieapp.databinding.FragmentUpCommingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel



class UpCommingFragment : Fragment() {
    private lateinit var binding: FragmentUpCommingBinding
    val upcomingViewModel : UpCommingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpCommingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        
    }

}