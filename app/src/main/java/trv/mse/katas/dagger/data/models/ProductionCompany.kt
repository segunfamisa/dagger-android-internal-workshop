package trv.mse.katas.dagger.data.models

import com.google.gson.annotations.SerializedName


data class ProductionCompany(
        @SerializedName("id") val id: Long = 0,
        @SerializedName("name") val name: String? = null
)