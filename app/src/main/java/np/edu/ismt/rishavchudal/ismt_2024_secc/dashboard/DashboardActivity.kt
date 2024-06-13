package np.edu.ismt.rishavchudal.ismt_2024_secc.dashboard

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import np.edu.ismt.rishavchudal.ismt_2024_secc.R
import np.edu.ismt.rishavchudal.ismt_2024_secc.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private val homeFragment = HomeFragment()
    private val myItemsFragment = MyItemsFragment()
    private val offersFragment = OffersFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadRespectiveFragment(homeFragment)
        binding.bottomNavView.setOnNavigationItemSelectedListener { menuItem ->
            if (menuItem.itemId == R.id.home) {
                loadRespectiveFragment(homeFragment)
                true
            } else if (menuItem.itemId == R.id.items) {
                loadRespectiveFragment(myItemsFragment)
                true
            } else if (menuItem.itemId == R.id.offers) {
                loadRespectiveFragment(offersFragment)
                true
            } else {
                loadRespectiveFragment(profileFragment)
                true
            }
        }
    }

    private fun loadRespectiveFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainerView.id, fragment)
            .addToBackStack(null)
            .commit()
    }
}