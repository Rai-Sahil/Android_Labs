package com.bcit.async

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bcit.async.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val infoViewModel: InfoViewModel by activityViewModels()
        val textView = view.findViewById<TextView>(R.id.textView_info_data)
        val button = view.findViewById<Button>(R.id.button_info_go)

        //LiveData observer and registering of observers
        val dataObservers = Observer<Int> {
            println("OnChangedWithLiveData, new data: $it")
            textView.text = it.toString()
        }

        infoViewModel.genericLiveData.observe(viewLifecycleOwner, dataObservers)

        //Regular callback
        val dataListener = object : GenericCallbackData{
            override var value: Int?
                get() {
                    return value
                }
                set(value){
                    println("OnChangedWithCallback, new data: $value")
                    print(view)
                }
        }
        infoViewModel.genericCallbackData = dataListener

        button.setOnClickListener{
            findNavController().navigate(R.id.action_infoFragment_to_detailsFragment)
        }
    }
}