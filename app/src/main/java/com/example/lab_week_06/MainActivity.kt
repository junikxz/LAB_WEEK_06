package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatAdapter
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup adapter untuk RecyclerView
        recyclerView.adapter = catAdapter

        // Setup layout manager untuk RecyclerView (vertikal)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Tambahkan data ke adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.BalineseJavanese,
                    name = "Fred",
                    biography = "Silent and deadly",
                    imageUrl = "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.ExoticShorthair,
                    name = "Wilma",
                    biography = "Cuddly assassin",
                    imageUrl = "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    gender = Gender.Unknown,
                    breed = CatBreed.AmericanCurl,
                    name = "Curious George",
                    biography = "Award winning investigator",
                    imageUrl = "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.ExoticShorthair,
                    name = "Tommy",
                    biography = "Playful troublemaker",
                    imageUrl = "https://cdn2.thecatapi.com/images/8qf.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.BalineseJavanese,
                    name = "Luna",
                    biography = "Elegant and mysterious",
                    imageUrl = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg" // ✅ valid
                ),
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.AmericanCurl,
                    name = "Max",
                    biography = "Always curious about everything",
                    imageUrl = "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg" // ✅ valid
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.ExoticShorthair,
                    name = "Molly",
                    biography = "Sleeps 20 hours a day",
                    imageUrl = "https://cdn2.thecatapi.com/images/5pr.jpg"
                ),
                CatModel(
                    gender = Gender.Unknown,
                    breed = CatBreed.BalineseJavanese,
                    name = "Shadow",
                    biography = "Loves hiding in dark corners",
                    imageUrl = "https://cdn2.thecatapi.com/images/9k3.jpg"
                ),
                CatModel(
                    gender = Gender.Male,
                    breed = CatBreed.AmericanCurl,
                    name = "Oscar",
                    biography = "Charming and fearless",
                    imageUrl = "https://cdn2.thecatapi.com/images/8fj.jpg"
                ),
                CatModel(
                    gender = Gender.Female,
                    breed = CatBreed.ExoticShorthair,
                    name = "Daisy",
                    biography = "Sweet but sassy",
                    imageUrl = "https://cdn2.thecatapi.com/images/bpc.jpg"
                )
            )
        )

    }
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
        //Set the title for the dialog
                    .setTitle("Cat Selected")
        //Set the message for the dialog
                    .setMessage("You have selected cat ${cat.name}")
        //Set if the OK button should be enabled
                    .setPositiveButton("OK") { _, _ -> }.show()
    }

}
