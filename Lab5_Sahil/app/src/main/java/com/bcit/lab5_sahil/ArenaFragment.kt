package com.bcit.lab5_sahil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

/**
 * A simple [Fragment] subclass.
 * Use the [ArenaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArenaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var v: View;

    public var ashoka: Fighter = Fighter("ASHOKA", R.drawable.ahsoka, 120)
    public var bb8: Fighter = Fighter("BB8", R.drawable.bb8, 101)
    public var c3po: Fighter = Fighter("C3P0", R.drawable.c3po, 32)
    public var chebacaa: Fighter = Fighter("CHEWBACCA", R.drawable.chewbacca, 12)
    public var grogu: Fighter = Fighter("GROGU", R.drawable.grogu, 50)
    public var jabba: Fighter = Fighter("JABBA", R.drawable.jabba, 49)
    public var kilo: Fighter = Fighter("KILO", R.drawable.kilo, 79)
    public var trooper: Fighter = Fighter("TROOPER", R.drawable.trooper, 44)
    public var yoda: Fighter = Fighter("YODA", R.drawable.yoda, 901)

    var battle : Battle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_arena, container, false)

        return v
    }

    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        super.onViewCreated(v, savedInstanceState)
        var list = listOf<Fighter>(ashoka, bb8, c3po, chebacaa, grogu, jabba, kilo, trooper, yoda)


        val fragmentManager = requireActivity().supportFragmentManager

        var randomIndex1 = Random.nextInt(list.size)
        val randomFighter1: Fighter = list[randomIndex1]

        var randomIndex2 = Random.nextInt(list.size)
        while (randomIndex1 == randomIndex2) {
            randomIndex2 = Random.nextInt(list.size)
        }

        var randomFighter2: Fighter = list[randomIndex2]

        battle = Battle(randomFighter1, randomFighter2)
        var result: Fighter? = battle?.winner()


        val bundle_fighter1 = Bundle()
        bundle_fighter1.putParcelable(ARG_PARAM1, randomFighter1)

        val bundle_fighter2 = Bundle()
        bundle_fighter2.putParcelable(ARG_PARAM1, randomFighter2)

        if (result == null) {
            bundle_fighter1.putString(ARG_PARAM3, "draw")
            bundle_fighter2.putString(ARG_PARAM3, "draw")
        } else if (result == randomFighter1) {
            bundle_fighter1.putString(ARG_PARAM3, "Winner")
            bundle_fighter2.putString(ARG_PARAM3, "Loser")
        } else {
            bundle_fighter2.putString(ARG_PARAM3, "Winner")
            bundle_fighter1.putString(ARG_PARAM3, "Loser")
        }

        val fighterFragment1 = FighterFragment()
        val fighterFragment2 = FighterFragment()

        fighterFragment1.arguments = bundle_fighter1
        fighterFragment2.arguments = bundle_fighter2

        fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView1_arenafragment, fighterFragment1).commit()
        fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2_arenafragment, fighterFragment2).commit()
    }

    override fun onResume() {
        super.onResume()

        val backButton : Button = v.findViewById(R.id.button_arenafragment_home)
        val nextFight : Button = v.findViewById(R.id.button3_arenafrgment_next)

        var list = listOf<Fighter>(ashoka, bb8, c3po, chebacaa, grogu, jabba, kilo, trooper, yoda)

        backButton.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            val arenaFragment = fragmentManager.findFragmentByTag("ARENAFRAGMENT_TAG")
            val homeFragment = fragmentManager.findFragmentByTag("HOMEFRAGMENT_TAG")

            if (homeFragment != null) {
                if (arenaFragment != null) {
                    fragmentTransaction.hide(arenaFragment)
                }
                fragmentTransaction.show(homeFragment)
            }
            fragmentTransaction.commit()
        }

        nextFight.setOnClickListener {
            var list = listOf<Fighter>(ashoka, bb8, c3po, chebacaa, grogu, jabba, kilo, trooper, yoda)

            val fragmentManager = requireActivity().supportFragmentManager

            var randomIndex1 = Random.nextInt(list.size)
            val randomFighter1: Fighter = list[randomIndex1]

            var randomIndex2 = Random.nextInt(list.size)
            while (randomIndex1 == randomIndex2) {
                randomIndex2 = Random.nextInt(list.size)
            }

            var randomFighter2: Fighter = list[randomIndex2]

            battle = Battle(randomFighter1, randomFighter2)
            var result: Fighter? = battle?.winner()


            val bundle_fighter1 = Bundle()
            bundle_fighter1.putParcelable(ARG_PARAM1, randomFighter1)

            val bundle_fighter2 = Bundle()
            bundle_fighter2.putParcelable(ARG_PARAM1, randomFighter2)

            if (result == null) {
                bundle_fighter1.putString(ARG_PARAM3, "draw")
                bundle_fighter2.putString(ARG_PARAM3, "draw")
            } else if (result == randomFighter1) {
                bundle_fighter1.putString(ARG_PARAM3, "Winner")
                bundle_fighter2.putString(ARG_PARAM3, "Loser")
            } else {
                bundle_fighter2.putString(ARG_PARAM3, "Winner")
                bundle_fighter1.putString(ARG_PARAM3, "Loser")
            }

            val fighterFragment1 = FighterFragment()
            val fighterFragment2 = FighterFragment()

            fighterFragment1.arguments = bundle_fighter1
            fighterFragment2.arguments = bundle_fighter2

            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView1_arenafragment, fighterFragment1).commit()
            fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView2_arenafragment, fighterFragment2).commit()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ArenaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ArenaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}