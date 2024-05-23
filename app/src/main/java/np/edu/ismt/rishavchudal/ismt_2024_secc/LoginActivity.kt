package np.edu.ismt.rishavchudal.ismt_2024_secc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import np.edu.ismt.rishavchudal.ismt_2024_secc.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val TAG = "LoginActivity"
    private lateinit var binding: ActivityLoginBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.i(TAG, "onCreate: ")

        binding.tvLoginMessage.text = "LOGIN PAGE"
        binding.btnLogin.setOnClickListener {
            val email = binding.tieEmail.text.toString().trim()
            val password = binding.tiePassword.text.toString().trim()

            if (email.isNullOrEmpty()) {
                Toast.makeText(
                    this@LoginActivity,
                    "Please input an email",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(
                    this@LoginActivity,
                    "Please input an valid email",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (password.isNullOrEmpty()) {
                Toast.makeText(
                    this@LoginActivity,
                    "Please input an password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                //Local field validation success
                //TODO remote server or local db authentication

                val intent = Intent(
                    this@LoginActivity,
                    DashboardActivity::class.java
                )
                intent.putExtra("enteredEmail", email)
                startActivity(intent)
                finish()
            }


        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
    }
}