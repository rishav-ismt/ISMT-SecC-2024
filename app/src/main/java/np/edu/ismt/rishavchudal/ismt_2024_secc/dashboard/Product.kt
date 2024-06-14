package np.edu.ismt.rishavchudal.ismt_2024_secc.dashboard

data class Product(
    var name: String,
    var price: String,
    var description: String,
    var image: String? = null,
    var category: String? = null,
    var storeLocationLat: String? = null,
    var storeLocationLng: String? = null,
    var markAsPurchased: Boolean? = false,
    var quantity: String? = null
)
