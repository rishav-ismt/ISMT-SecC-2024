package np.edu.ismt.rishavchudal.ismt_2024_secc.dashboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import np.edu.ismt.rishavchudal.ismt_2024_secc.dashboard.db.Product
import np.edu.ismt.rishavchudal.ismt_2024_secc.databinding.LayoutItemOffersBinding

class OffersHorizontalAdapter(
    val products: List<Product>
): RecyclerView.Adapter<OffersHorizontalAdapter.ViewHolder>(){

    class ViewHolder(
        val binding: LayoutItemOffersBinding
    ): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LayoutItemOffersBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val product = products[position]
        holder.binding.tvItemOffersName.text = product.name
        holder.binding.tvItemOffersDesc.text = product.description
        holder.binding.mbItemOffersView.setOnClickListener {
            Toast.makeText(
                holder.binding.root.context,
                "Position: " + position,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}