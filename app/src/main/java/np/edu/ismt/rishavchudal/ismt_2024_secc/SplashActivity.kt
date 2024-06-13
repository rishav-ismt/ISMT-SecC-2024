package np.edu.ismt.rishavchudal.ismt_2024_secc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import np.edu.ismt.rishavchudal.ismt_2024_secc.dashboard.DashboardActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_first_app)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Navigating to Login Activity


        Handler().postDelayed(
            {
                //Checking loggedin state in sharedpreferences
                val sharedPreferences = this@SplashActivity
                    .application.getSharedPreferences(
                        "login",
                        Context.MODE_PRIVATE
                    )

                val isLoggedIn = sharedPreferences.getBoolean(
                    "isLoggedIn",
                    false
                )

                if (isLoggedIn) {
                    val intent = Intent(
                        this@SplashActivity,
                        DashboardActivity::class.java
                    )
                    startActivity(intent)
                    finish()
                } else {
                    val intent = Intent(
                        this@SplashActivity,
                        LoginActivity::class.java
                    )
                    startActivity(intent)
                    finish()
                }
            },
            3000
        )
    }
}