package np.edu.ismt.rishavchudal.ismt_2024_secc

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class TestData(
    val variable1: String,
    val variable2: Int
): Parcelable
