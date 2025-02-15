package com.example.attendance_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.attendance_app.databinding.FragmentAddSubjectBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class add_subject : BottomSheetDialogFragment() {

    private lateinit var binding:FragmentAddSubjectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentAddSubjectBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddSubject.setOnClickListener {
            val subjectName=binding.subjectName.text.toString()
            val bundle=Bundle().apply {
                putString("subjectName",subjectName)
            }
            parentFragmentManager.setFragmentResult("RequestKey",bundle)
            dismiss()
        }

    }

}