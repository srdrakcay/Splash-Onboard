package com.serdar.firstapp.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.serdar.firstapp.MainActivity
import com.serdar.firstapp.databinding.SiginInBinding

class SignInActivity: AppCompatActivity() {
    private lateinit var binding: SiginInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = SiginInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        firebaseAuth=FirebaseAuth.getInstance()


        if(firebaseAuth.currentUser !=null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.textSignin.setOnClickListener {
            val intent = Intent(this, SıgnUpActivity::class.java)
            startActivity(intent)
        }
    binding.entryButton.setOnClickListener {
            val email = binding.emailgiris.text.toString()
            val pass = binding.emailgirissifre.text.toString()

        if (email.isNotEmpty() && pass.isNotEmpty() ) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }

        } else {
            Toast.makeText(this, "Boş Bırakılamaz", Toast.LENGTH_SHORT).show()
        }
    }
}



}

