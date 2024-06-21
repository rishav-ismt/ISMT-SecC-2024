package np.edu.ismt.rishavchudal.ismt_2024_secc.dashboard.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {
    @Insert
    fun insertAProduct(product: Product)

    @Insert
    fun insertProducts(products: List<Product>)

    @Insert
    fun insertProducts(vararg product: Product)

    @Update
    fun updateProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)

    @Query("Delete from product")
    fun deleteProducts()

    @Query("Select * from product")
    fun getAllProducts()

    @Query("Select * from product where mark_as_purchased = 1")
    fun getAllMarkAsPurchasedProducts()

    @Query("Select * from product where name like :names")
    fun getAllProductsWithGivenName(names: String)
}