package com.example.praktikumfragmen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

class MakananDialogFragment : DialogFragment() {

    private var dialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_makanan_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCancel = view.findViewById<Button>(R.id.btn_cancel)
        val btnChoose = view.findViewById<Button>(R.id.btn_choose)
        val rgMakanan = view.findViewById<RadioGroup>(R.id.rg_makanan)
        val rbNasigoreng = view.findViewById<RadioButton>(R.id.rb_nasi_goreng)
        val rbNasiPadang = view.findViewById<RadioButton>(R.id.rb_nasi_padang)
        val rbNasiTelur = view.findViewById<RadioButton>(R.id.rb_nasi_telur)

        btnChoose.setOnClickListener {
            val selecedRadioButtonId = rgMakanan.checkedRadioButtonId
            if (selecedRadioButtonId != -1) {
                val makanan: String = when (selecedRadioButtonId) {
                    R.id.rb_nasi_goreng -> rbNasigoreng.text.toString()
                    R.id.rb_nasi_padang -> rbNasiPadang.text.toString()
                    R.id.rb_nasi_telur -> rbNasiTelur.text.toString()

                    else -> ""
                }
                dialogListener?.onOptionSelected(makanan)
                dialog?.dismiss()
            }
        }
        btnCancel.setOnClickListener {
            dialog?.cancel()
        }
    }

    interface OnOptionDialogListener {
        fun onOptionSelected(text: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment
        if (fragment is MoveWithDataFragment) {
            this.dialogListener = fragment.dialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.dialogListener = null
    }

}

