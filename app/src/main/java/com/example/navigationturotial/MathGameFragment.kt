package com.example.navigationturotial

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.navigationturotial.databinding.FragmentMathGameBinding
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MathGameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MathGameFragment : Fragment() {

    private lateinit var binding: FragmentMathGameBinding
    val args: MathGameFragmentArgs by navArgs()

    var correctAnswers = 0
    var wrongAnswers = 0
    var questions: Array<Boolean?> = arrayOf(null, null, null, null)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMathGameBinding.inflate(layoutInflater)
        binding.calculateScoreButton.setOnClickListener {

            val answer1 = binding.question1Answer.text.toString().toInt();
            val answer2 = binding.question2Answer.text.toString().toInt();
            val answer3 = binding.question3Answer.text.toString().toInt();
            val answer4 = binding.question4Answer.text.toString().toInt();

            var result = 0

            if (answer1 == 4) correctAnswers++
            else {
                wrongAnswers++
            }
            if (answer2 == 10) correctAnswers++
            else {
                wrongAnswers++
            }
            if (answer3 == 14) correctAnswers++
            else {
                wrongAnswers++
            }
            if (answer4 == 19) correctAnswers++
            else {
                wrongAnswers++
            }
            val sharedPref = activity?.getSharedPreferences("myPref", Context.MODE_PRIVATE)
            val editor = sharedPref?.edit()
            val savedScore = correctAnswers
            editor.apply {
                putInt("score", savedScore)
                apply()
            }
                val action = MathGameFragmentDirections.actionMathGameFragmentEasyToScoreFragment(
                    correctAnswers
                )
                Navigation.findNavController(binding.root).navigate(action)

        }
        return binding.root
    }
}
