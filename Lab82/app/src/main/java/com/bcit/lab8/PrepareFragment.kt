package com.bcit.lab8

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bcit.lab8.*
import com.bcit.lab8.Interface.QuestResultListener
import com.bcit.lab8.ViewModel.Quest_ViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PrepareFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PrepareFragment : Fragment(), QuestResultListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_prepare, container, false)

        val viewModel_dataHolder: Quest_ViewModel by activityViewModels()

        var itemSelected: ITEM? = null

        v.findViewById<RadioGroup>(R.id.radiogroup_Item).setOnCheckedChangeListener{ _, i ->

            when (i){
                R.id.radioButton_preparefrag_shield ->
                    itemSelected = ITEM.SHIELD
                R.id.radioButton_preparefrag_compass ->
                    itemSelected = ITEM.COMPASS
                R.id.radioButton_preparefrag_potion ->
                    itemSelected = ITEM.POTION
            }

        }

        var sidekickSelected: SIDEKICK? = null

        v.findViewById<RadioGroup>(R.id.radiogroup_sidekick).setOnCheckedChangeListener{ _, i ->

            when (i){
                R.id.radioButton_preparefrag_chicken ->
                    sidekickSelected = SIDEKICK.CHICKEN
                R.id.radioButton_preparefrag_fairy ->
                    sidekickSelected = SIDEKICK.FAIRY
                R.id.radioButton_preparefrag_goron ->
                    sidekickSelected = SIDEKICK.GORON
            }

        }

        v.findViewById<Button>(R.id.button_startquests).setOnClickListener{
            viewModel_dataHolder.startNewQuest(itemSelected, sidekickSelected, this)
        }

        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PrepareFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PrepareFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onSavedHyrule() {
            findNavController().navigate(R.id.action_prepareFragment_to_successFragment)
    }

    override fun onDidNotSaveHyrule() {
        findNavController().navigate(R.id.action_prepareFragment_to_failFragment)
    }
}