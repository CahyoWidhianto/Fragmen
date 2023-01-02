package com.example.praktikumfragmen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class MoveFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_move, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnMoveWithData: Button = view.findViewById(R.id.btn_Move_With_Data)

        btnMoveWithData.setOnClickListener {
            val moveWithDataFragment = MoveWithDataFragment()

            val mBundle = Bundle()
            mBundle.putInt(MoveWithDataFragment.EXTRA_AGE, 19)
            val name = "Cahyo Widhianto"

            moveWithDataFragment.arguments=mBundle
            moveWithDataFragment.receivedname =name

            val fragManager = parentFragmentManager
            fragManager.beginTransaction().apply {
                replace(
                    R.id.fragmen_container,
                    moveWithDataFragment,
                    MoveWithDataFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }


        }
    }
}