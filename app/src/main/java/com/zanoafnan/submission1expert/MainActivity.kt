package com.zanoafnan.submission1expert

//this
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zanoafnan.submission1expert.core.data.source.Resource
import com.zanoafnan.submission1expert.core.domain.model.Meal
import com.zanoafnan.submission1expert.databinding.ActivityMainBinding
import com.zanoafnan.submission1expert.ui.MainViewModel
import com.zanoafnan.submission1expert.ui.MealAdapter
import com.zanoafnan.submission1expert.ui.SettingsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding
    //private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MealAdapter

    private var currentQuery = ""


    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // factory = ViewModelFactory(Injection.provideMealUseCase(applicationContext))
        // mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        val layoutManager = LinearLayoutManager(this)
        binding.rvReview.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvReview.addItemDecoration(itemDecoration)

        adapter = MealAdapter()

        val sharedPref = getSharedPreferences("theme", MODE_PRIVATE)
        val aktifDarkMode = sharedPref.getBoolean("is_dark_mode", false)
        //mainViewModel.findMeal()

        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView
                .editText
                .setOnEditorActionListener { _, _, _  ->
                    searchBar.setText(searchView.text)
                    searchView.hide()
                    val query = searchView.text.toString().trim()
                    performSearch(query)

                    false
                }
        }


        if (binding.searchView.text.isNullOrEmpty()) {
            mainViewModel.setQuery("li")
        }

        mainViewModel.meal.observe(this) { meal ->
            if (meal != null) {
                Log.d("MainAct meal", meal.data.toString())
                when (meal) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        meal.data?.let { setMealData(it) }
                        adapter.setData(meal.data)
                    }

                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                    }
                }
            }
        }

        AppCompatDelegate.setDefaultNightMode(
            if (aktifDarkMode) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )

        mainViewModel.isLoading.observe(this) {
            showLoading(it)
        }






    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favmeal -> {
                val uri = Uri.parse("submission1expert://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
                return true
            }
            R.id.settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


    private fun performSearch(query: String) {
        currentQuery = query.trim()
        mainViewModel.setQuery(currentQuery)
        //mainViewModel.findMeal()
    }

    private fun setMealData(mealData: List<Meal>) {

        adapter.submitList(mealData)
        binding.rvReview.adapter = adapter

    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}