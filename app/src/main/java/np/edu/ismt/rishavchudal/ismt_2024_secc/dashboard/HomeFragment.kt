package np.edu.ismt.rishavchudal.ismt_2024_secc.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import np.edu.ismt.rishavchudal.ismt_2024_secc.dashboard.adapters.OffersHorizontalAdapter
import np.edu.ismt.rishavchudal.ismt_2024_secc.dashboard.db.Product
import np.edu.ismt.rishavchudal.ismt_2024_secc.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(
            layoutInflater,
            container,
            false
        )
        //Views initialization
        setUpOffersRecyclerView()
        setUpFabButton()
        return binding.root
    }

    private fun setUpOffersRecyclerView() {
        val adapter = OffersHorizontalAdapter(generateOffers())
        binding.rvOffers.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.HORIZONTAL,
            false
        )
        binding.rvOffers.adapter = adapter
    }

    private fun generateOffers(): List<Product> {
        val products = mutableListOf<Product>()
        for(i in 1..20) {
            val product = Product(
                name = "Product ".plus(i),
                price = (100 * i).toString(),
                description = "Description ".plus(i)
            )
            products.add(product)
        }
        return products
    }

    private fun setUpFabButton() {
        binding.fabAddItem.setOnClickListener {
            val intent = Intent(
                requireActivity(),
                AddOrUpdateActivity::class.java
            )
            startActivity(intent)
        }
    }

}  