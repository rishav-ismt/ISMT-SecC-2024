package np.edu.ismt.rishavchudal.ismt_2024_secc

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import np.edu.ismt.rishavchudal.ismt_2024_secc.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedEmail = intent.getStringExtra("enteredEmail")
        Toast.makeText(
            this@DashboardActivity,
            "Received Email : ".plus(receivedEmail),
            Toast.LENGTH_SHORT).show()
    }
}