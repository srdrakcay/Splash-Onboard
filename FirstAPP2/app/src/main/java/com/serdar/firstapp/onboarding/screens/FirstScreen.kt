package com.serdar.firstapp.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.serdar.firstapp.R
import kotlinx.android.synthetic.main.fragment_first_screen.*
import kotlinx.android.synthetic.main.fragment_first_screen.view.*
import kotlinx.android.synthetic.main.fragment_view_pager.*


class FirstScreen : Fragment() {


    override fun onCreateView(


        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_first_screen, container, false)

     var viewPager= activity?.findViewById<ViewPager2>(R.id.viewPager)

        view.next.setOnClickListener {
             viewPager


            viewPager?.currentItem=1

        }
        return view
    }





}