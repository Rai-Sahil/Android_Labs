package com.bcit.lab8

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bcit.lab8.*
import com.bcit.lab8.Adapter.QuestsAdapter
import com.bcit.lab8.Interface.NavigateToQuestDetailsListener
import com.bcit.lab8.Objects.Quest
import com.bcit.lab8.ViewModel.Quest_ViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestsFragment : Fragment(), NavigateToQuestDetailsListener {
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
        val v: View = inflater.inflate(R.layout.fragment_quests, container, false)

        val recyclerView = v.findViewById<RecyclerView>(R.id.recyclerview_quests)
        val questViewmodel: Quest_ViewModel by activityViewModels()
        val resources = questViewmodel.quests

        recyclerView.adapter = QuestsAdapter(resources, this)
        recyclerView.layoutManager = LinearLayoutManager(v.context)

        return v
    }

    override fun onNavigateToQuestDetails(quest: Quest) {
        val questViewModel : Quest_ViewModel by activityViewModels()

        val index = questViewModel.quests.indexOf(quest)
        var bundle = bundleOf("KEY_INDEX" to index)
        findNavController().navigate(R.id.action_questsFragment_to_questsDetailFragment, bundle)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.act
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuestsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}