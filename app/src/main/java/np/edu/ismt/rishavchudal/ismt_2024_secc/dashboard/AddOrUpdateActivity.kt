package np.edu.ismt.rishavchudal.ismt_2024_secc.dashboard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import np.edu.ismt.rishavchudal.ismt_2024_secc.R
import np.edu.ismt.rishavchudal.ismt_2024_secc.dashboard.db.SampleDatabase
import np.edu.ismt.rishavchudal.ismt_2024_secc.databinding.ActivityAddOrUpdateBinding

class AddOrUpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddOrUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddOrUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mbAddOrUpdate.setOnClickListener {
            val db = SampleDatabase.getInstance(this.applicationContext)
            val dao = db.getProductDao()

            Thread {
                dao.deleteProducts()
            }.start()

        }
    }
}