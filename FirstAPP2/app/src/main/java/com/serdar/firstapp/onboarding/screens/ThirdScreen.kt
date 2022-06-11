package com.serdar.firstapp.onboarding.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.serdar.firstapp.R
import com.serdar.firstapp.login.SignInActivity
import kotlinx.android.synthetic.main.fragment_first_screen.view.*
import kotlinx.android.synthetic.main.fragment_third_screen.*
import kotlinx.android.synthetic.main.fragment_third_screen.view.*


class ThirdScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third_screen, container, false)

        val viewPager= activity?.findViewById<ViewPager2>(R.id.viewPager)

            view.finish.setOnClickListener {

                val intent = Intent(requireActivity(), SignInActivity::class.java)
                startActivity(intent)


        }
        return view
    }

private fun onBoardingFinished(){
    val sp = requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)

    val editor = sp.edit()
    editor.putBoolean("Finished",true)

    editor.apply()

}



}