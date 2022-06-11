package com.serdar.firstapp.onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.serdar.firstapp.MainActivity
import com.serdar.firstapp.R
import com.serdar.firstapp.login.SignInActivity
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.schedule


class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val firebaseAuth= FirebaseAuth.getInstance()

        Handler().postDelayed({

            if(onBoardingFinished()){
                if(firebaseAuth.currentUser !=null){
                    val intent= Intent(requireActivity(), MainActivity::class.java)
                    startActivity(intent)
                }else{
                    val intent= Intent(requireActivity(), SignInActivity::class.java)
                   startActivity(intent)
                }
            }else{
               findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)

            }
        }, 1000)

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
    private fun onBoardingFinished(): Boolean{
        val sp = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sp.getBoolean("Finished",false)

    }
}