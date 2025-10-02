package com.example.lab_week_06.model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.ImageLoader
import com.example.lab_week_06.R

private const val FEMALE_SYMBOL = "\u2640" // ♀
private const val MALE_SYMBOL = "\u2642"   // ♂
private const val UNKNOWN_SYMBOL = "?"     // default jika gender tidak diketahui

class CatViewHolder(
    containerView: View,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(containerView) {

    // containerView adalah layout dari tiap item list
    // findViewById untuk mendapatkan referensi view di layout item
    private val catBiographyView: TextView by lazy {
        containerView.findViewById(R.id.cat_biography)
    }
    private val catBreedView: TextView by lazy {
        containerView.findViewById(R.id.cat_breed)
    }
    private val catGenderView: TextView by lazy {
        containerView.findViewById(R.id.cat_gender)
    }
    private val catNameView: TextView by lazy {
        containerView.findViewById(R.id.cat_name)
    }
    private val catPhotoView: ImageView by lazy {
        containerView.findViewById(R.id.cat_photo)
    }

    // Fungsi dipanggil di adapter untuk mengikat data ke view
    fun bindData(cat: CatModel) {
        imageLoader.loadImage(cat.imageUrl, catPhotoView)

        // Nama
        catNameView.text = cat.name

        // Breed
        catBreedView.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
            else -> "Unknown"
        }

        // Biografi
        catBiographyView.text = cat.biography

        // Gender
        catGenderView.text = when (cat.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            else -> UNKNOWN_SYMBOL
        }
    }
}
