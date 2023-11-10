package com.example.navigationturotial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.navigationturotial.databinding.FragmentMathGameBinding
import com.example.navigationturotial.databinding.FragmentSelectDifficultyBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SelectDifficultyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectDifficultyFragment : Fragment() {

    private lateinit var binding: FragmentSelectDifficultyBinding
    val args: SelectDifficultyFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSelectDifficultyBinding.inflate(layoutInflater)
        val type = args.gameType

        binding.easyDifficultyButton.setOnClickListener {
            val difficulty = DifficultyLevel.EASY
            selectGameMode(type, difficulty)
        }

        return binding.root
    }

    fun selectGameMode(mode: PracticeType, difficulty: DifficultyLevel) {
        val action = SelectDifficultyFragmentDirections.actionSelectDifficultyFragmentToMathGameFragment(difficulty, mode)
        Navigation.findNavController(binding.root).navigate(action)
    }
}