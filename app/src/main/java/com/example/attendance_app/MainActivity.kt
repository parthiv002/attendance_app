package com.example.attendance_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter: SubjectAdapter
    private var subjects= mutableListOf<Subject>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        floatingActionButton=findViewById(R.id.fab)
        recyclerView=findViewById(R.id.recyclerView)
        adapter= SubjectAdapter(subjects)

        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)



        floatingActionButton.setOnClickListener{
            add_subject().show(supportFragmentManager,"TAG")
        }

        supportFragmentManager.setFragmentResultListener("RequestKey",this){_,bundle->
            val newSubjectName=bundle.getString("subjectName")
            val newSubject=Subject(name=newSubjectName!!)
            subjects.add(newSubject)
            adapter.notifyDataSetChanged()
        }


    }
}