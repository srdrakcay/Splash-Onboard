package com.serdar.firstapp.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.serdar.firstapp.R
import com.serdar.firstapp.databinding.SiginUpBinding

class SıgnUpActivity: AppCompatActivity() {
    private lateinit var binding:SiginUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=SiginUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth=FirebaseAuth.getInstance()

        binding.Button.setOnClickListener {
            val email =binding.emailText.text.toString()
            val pass=binding.passwordText.text.toString()
            val confirm = binding.passwordText1.text.toString()

            binding.registerText.setOnClickListener {
                val intent=Intent(this,SignInActivity::class.java)
                startActivity(intent)
            }
            if (email.isNotEmpty() && pass.isNotEmpty() && confirm.isNotEmpty()){
                if (pass == confirm){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                        if (it.isSuccessful){
                           finish()
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                }
            }else{
                    Toast.makeText(this, "Şifreler Uyuşmuyor", Toast.LENGTH_SHORT).show()
                }
         }else{
                Toast.makeText(this, "Boş Bırakılamaz", Toast.LENGTH_SHORT).show()
            }
    }
}
}