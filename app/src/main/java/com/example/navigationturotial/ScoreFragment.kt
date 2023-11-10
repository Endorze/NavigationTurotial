package com.example.navigationturotial

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.navigationturotial.databinding.FragmentScoreBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ScoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding
    val args:  ScoreFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val easyScore = args.easyScore
        val mediumScore = args.mediumScore
        val hardScore = args.hardScore
        binding = FragmentScoreBinding.inflate(layoutInflater)
        binding.easyScoreTextView.text = "Din poäng: ${easyScore} av 4"
        // Inflate the layout for this fragment


        return binding.root
    }
}