package com.zanoafnan.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.zanoafnan.favorite.databinding.ActivityFavMealBinding
import com.zanoafnan.favorite.di.favMealModule
import com.zanoafnan.submission1expert.ui.DetailMealActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavMealActivity : AppCompatActivity() {

    private val favoriteViewModel: FavMealViewModel by viewModel()

    private lateinit var binding: ActivityFavMealBinding
    private lateinit var adapter: FavMealAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavMealBinding.inflate(layoutInflater)
        supportActionBar?.title = "Favorite Meal"
        setContentView(binding.root)

        loadKoinModules(favMealModule)

        val mealAdapter = FavMealAdapter()
        mealAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailMealActivity::class.java)
            intent.putExtra(DetailMealActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }


        favoriteViewModel.favoriteMeal.observe(this) { dataMeal ->
            mealAdapter.setData(dataMeal)
            binding.tvName.visibility = if (dataMeal.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvFavRecycler) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mealAdapter
        }
    }
}




/*
class FavMealActivity : AppCompatActivity() {


    private val favoriteViewModel: FavMealViewModel by viewModel()

    private var _binding: ActivityFavMealBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityFavMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val mealAdapter = MealAdapter()
            mealAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMealActivity::class.java)
                intent.putExtra(DetailMealActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoriteViewModel.favoriteMeal.observe(viewLifecycleOwner, { dataMeal ->
                mealAdapter.setData(dataMeal)
                binding.viewEmpty.root.visibility = if (dataMeal.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(binding.rvMeal) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = mealAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

*/


/*
class FavMealActivity : AppCompatActivity() {

    private val viewModel: FavMealViewModel by viewModel()

    private lateinit var binding: ActivityFavMealBinding
    private lateinit var adapter: FavMealAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

       loadKoinModules(favMealModule)

        adapter = FavMealAdapter()

        // Inisialisasi RecyclerView dan Adapter

        binding.rvFavRecycler.layoutManager = LinearLayoutManager(this)
        binding.rvFavRecycler.adapter = adapter

        // Observe perubahan dari ViewModel
        /*viewModel.favoriteMeal.observe(this) { favoriteMeals ->
            adapter.submitList(favoriteMeals)
        }*/

        /*viewModel.favoriteMeal.observe(this) { favoriteMeals ->
            setMealData(favoriteMeals)
        }*/

        viewModel.favoriteMeal.observe(this) { dataMeal ->
            adapter.setData(dataMeal)
            Log.d("1st Log FavMealData Adapter", dataMeal.toString())
            //binding.viewEmpty.root.visibility = if (dataMeal.isNotEmpty()) View.GONE else View.VISIBLE
        }

        getMealData()

    }

    private fun setMealData(favoriteMeals: List<Meal>) {
        //adapter.submitList(favoriteMeals)
    }

    private fun getMealData() {
        viewModel.favoriteMeal.observe(this) { meal ->
            if (meal != null) {

                when (meal) {
                    is Resource.Loading<*> -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success<*> -> {
                        binding.progressBar.visibility = View.GONE
                        //binding.tvMaps.text = "This is map of ${meal.data?.get(0)?.name}"
                        adapter.setData(meal.data as List<Meal>)


                        with(binding.rvFavRecycler) {
                            layoutManager = LinearLayoutManager(context)
                            setHasFixedSize(true)
                            adapter = adapter
                        }
                    }

                    is Resource.Error<*> -> {
                        binding.progressBar.visibility = View.GONE
                        //binding.tvError.visibility = View.VISIBLE
                        //binding.tvError.text = meal.message
                    }
                }

                Log.d("2nd Log FavMealData Adapter", meal.toString())
            }
        }
    }
}
*/