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

        val receivedEmail = intent.getStringExtra(AppConstants.KEY_EMAIL)

        val receivedTestData: TestData?
        if (android.os.Build.VERSION.SDK_INT >= 33) {
            receivedTestData = intent.getParcelableExtra(
                AppConstants.KEY_TEST_DATA,
                TestData::class.java
            )
        } else {
            receivedTestData = intent
                .getParcelableExtra<TestData>(AppConstants.KEY_TEST_DATA)
        }
        Toast.makeText(
            this@DashboardActivity,
            "Received TestData : ".plus(receivedTestData?.variable1),
            Toast.LENGTH_SHORT
        ).show()
    }
}