package com.bcit.lab8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.bcit.lab8.ViewModel.Quest_ViewModel


class QuestsDetailFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quests_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val questViewModel: Quest_ViewModel by activityViewModels()
        val index = arguments?.getInt("KEY_INDEX")
        println(index)
        println(questViewModel.quests)
        val quest = questViewModel.quests[index!!]

        val id = quest.Id
        val sidekick = quest.sidekick
        val item = quest.item
        val res = quest.savedHyrule
        val message = "Quest ID: $id\nSidekick: $sidekick\nItem: $item\nResult: $res"
        val textView = view.findViewById<TextView>(R.id.textView_questsdetailsfrag)
        textView.text = message
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            QuestsDetailFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}