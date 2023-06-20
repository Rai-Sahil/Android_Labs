package com.bcit.lab5_sahil

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

/**
 * A simple [Fragment] subclass.
 * Use the [FighterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FighterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_fighter, container, false)
        return v
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fighter_picture : ImageView = view.findViewById(R.id.imageView_fighterfragment)
        val textView_battleResult = view.findViewById<TextView>(R.id.textViewResult_fighterfragment)
        val textView_fighterName = view.findViewById<TextView>(R.id.textView_fighterfragment)

        val args = this.arguments
        val fighter : Fighter? = args?.getParcelable(ARG_PARAM1)
        val name = fighter?.name
        val resource = fighter?.resourceId
        val result = args?.get(ARG_PARAM3)

        textView_battleResult.text = result as CharSequence?
        textView_fighterName.text = name as CharSequence?
        resource?.let { fighter_picture.setImageResource(it as Int) }

        if(textView_battleResult.text == "Winner"){
            fighter_picture.animation = AnimationUtils.loadAnimation(view.context , R.anim.shake)
            textView_battleResult.setTextColor(Color.GREEN)
        } else{
            textView_battleResult.setTextColor(Color.RED)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FighterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: Int) =
                FighterFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putInt(ARG_PARAM2, param2)
                    }
                }
    }
}