package com.zanoafnan.submission1expert.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zanoafnan.submission1expert.R
import com.zanoafnan.submission1expert.databinding.FragmentFollBinding
import com.google.android.material.tabs.TabLayout
 

/*
class FollFragment() : Fragment() {


    companion object {
        const val ARG_POSITION = "position"
        const val ARG_USERNAME = "mealname"

        fun newInstance(position: Int, mealname: String): FollFragment {
            val fragment = FollFragment()
            val args = Bundle()
            args.putInt(ARG_POSITION, position)
            args.putString(ARG_USERNAME, mealname)
            fragment.arguments = args
            return fragment
        }
    }


    private var _binding: FragmentFollBinding? = null
    private val binding get() = _binding!!

    private var position: Int = 0
    var mealname: String = ""

    private lateinit var followersitemViewModel: FollowersitemViewModel
    private lateinit var followersAdapter: FollowersAdapter

    private lateinit var followingitemViewModel: FollowingitemViewModel
    private lateinit var followingAdapter: FollowingAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(ARG_POSITION)
            mealname = it.getString(ARG_USERNAME) ?: ""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //val tabLayout = requireActivity().findViewById<TabLayout>(R.id.tabs)

        // Initialize ViewModel
        followersitemViewModel = ViewModelProvider(this).get(FollowersitemViewModel::class.java)



        // Initialize RecyclerView
        val recyclerView = binding.rvFollRecycler
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize and set the adapter
        followersAdapter = FollowersAdapter()
        recyclerView.adapter = followersAdapter

        // Observe the followers list data
        followersitemViewModel.followersList.observe(viewLifecycleOwner, ){ followersList ->
            followersAdapter.submitList(followersList)
            showLoading(false)
        }

        followersitemViewModel.findFollowers(mealname)

        // Initialize ViewModel
        followingitemViewModel = ViewModelProvider(this).get(FollowingitemViewModel::class.java)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {

                    if (it.position == 0) {

                        followersitemViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
                            showLoading(isLoading)
                        }

                        // Initialize RecyclerView
                        val recyclerView = binding.rvFollRecycler
                        recyclerView.layoutManager = LinearLayoutManager(requireContext())

                        // Initialize and set the adapter
                        followersAdapter = FollowersAdapter()
                        recyclerView.adapter = followersAdapter

                        // Observe the followers list data
                        followersitemViewModel.followersList.observe(viewLifecycleOwner, ){ followersList ->
                            followersAdapter.submitList(followersList)
                            showLoading(false)
                        }

                        followersitemViewModel.findFollowers(mealname)
                        //binding.testMealname.text = "Get Follower $mealname"
                    } else {
                        followingitemViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
                            showLoading(isLoading)
                        }

                        // Initialize RecyclerView
                        val recyclerView = binding.rvFollRecycler
                        recyclerView.layoutManager = LinearLayoutManager(requireContext())

                        // Initialize and set the adapter
                        followingAdapter = FollowingAdapter()
                        recyclerView.adapter = followingAdapter

                        // Observe the followers list data
                        followingitemViewModel.followingList.observe(viewLifecycleOwner, ){ followingList ->
                            followingAdapter.submitList(followingList)
                            showLoading(false)
                        }

                        followingitemViewModel.findFollowing(mealname)
                        //binding.testMealname.text = "Get Following $mealname"
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })





    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}
*/