package com.gama.task.ui.fragments.favourites

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.data.repository.AuthRepository
import com.gama.task.databinding.FragmentDataRechargMobilyBinding
import com.gama.task.databinding.FragmentFavouritesBinding
import com.gama.task.models.Content
import com.gama.task.ui.Home.AdvancedSearch.Departments.DepartmentFragment
import com.gama.task.ui.Home.AdvancedSearch.Departments.DepartmentFragment.Companion.TAG
import com.gama.task.ui.base.BaseFragment
import com.gama.task.ui.fragments.voicedatacharg.mobilyfragment.SharedViewModel
import com.gama.task.util.EndlessRecyclerViewScrollListener
import com.gama.task.util.EventObserver
import com.gama.task.util.autoCleared
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavouritesFragment (): BaseFragment<FavouritesViewModel, FragmentFavouritesBinding>(
    FavouritesViewModel::class.java
) {
//    Fragment
//}(R.layout.fragment_data_recharg_mobily)


    var x:Int=1
    private var favouritesAdapter by autoCleared<FavouritesAdapter>()

    /**
     * A recyclerView scrollListener to handle Scroll.
     */
    private var scrollListener by autoCleared<EndlessRecyclerViewScrollListener>()

    override fun getLayoutRes() = R.layout.fragment_favourites

    override fun init() {

//        viewModel.allcontacts.observe(viewLifecycleOwner, ::handleApiStatus)

//init account list
        initAccountList()
        //init Add account
//        binding.searchresult.setOnSearchClickListener {
////            binding.toolbar.visibility= View.GONE
////
////            binding.userIcon.visibility= View.GONE
////            binding.notificationIcon.visibility= View.GONE
//
//
//        }
//        binding.searchresult.setOnCloseListener(object : SearchView.OnCloseListener {
//            override fun onClose(): Boolean {
////                binding.toolbar.visibility= View.VISIBLE
////                binding.userIcon.visibility= View.VISIBLE
////                binding.notificationIcon.visibility= View.VISIBLE
//
//                return false
//            }
//        })
        binding.sort.setOnClickListener {
//            viewModel.accountsList.observe(viewLifecycleOwner) {
//
//                it.sortByDescending { it.price }
//
//                mobileDataAdapter.submitList(it)
//                mobileDataAdapter.notifyDataSetChanged()
//            }
//
//        }
            DepartmentFragment.newInstance(
                "", ""
            )
                .apply {
//                    setTargetFragment(this,1)
                    isCancelable = false }
                .show(childFragmentManager, DepartmentFragment.TAG)
        }
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
//        model.message.observe(viewLifecycleOwner) {
//            Log.d(ContentValues.TAG, "init: "+it.toString())
//            viewModel.accountsList.observe(viewLifecycleOwner) {
//
//                it.sortByDescending { it.createdAt }
//
//                favouritesAdapter.submitList(it)
//                favouritesAdapter.notifyDataSetChanged()
//            }
//        }
//
//        model.asc.observe(viewLifecycleOwner) {
//            Log.d(ContentValues.TAG, "init: "+it.toString())
//            viewModel.accountsList.observe(viewLifecycleOwner) {
//
//                it.sortBy { it.price }
//
//                favouritesAdapter.submitList(it)
//                favouritesAdapter.notifyDataSetChanged()
//            }
//        }
//
//        model.desc.observe(viewLifecycleOwner) {
//            Log.d(ContentValues.TAG, "init: "+it.toString())
//            viewModel.accountsList.observe(viewLifecycleOwner) {
//
//                it.sortByDescending { it.price }
//
//                favouritesAdapter.submitList(it)
//                favouritesAdapter.notifyDataSetChanged()
//            }
//        }
    }



    private fun initAccountList() {

        viewModel.returnwithsuccess.observe(viewLifecycleOwner, EventObserver {
//            binding.setVariable(BR.isLoading, false)
        })
        viewModel.navigatewithresult.observe(viewLifecycleOwner) {

        }


        favouritesAdapter = FavouritesAdapter(dataBindingComponent, appExecutors ) {
//            val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
//            model.sendfavourites(it)
//                    findNavController().navigate(
//                        R.id.hotelsListFragment,
//                        bundleOf(
//                            "req_no" to it.id.toString()
////                            "hotelSearchRequest" to viewModel.accountsList.value!!
//                        )
//                    )



        }
        val layoutManager = GridLayoutManager(context, 2)

        // at last set adapter to recycler view.

        // at last set adapter to recycler view.
        binding.recyclerNotification.setLayoutManager(layoutManager)
        binding.recyclerNotification.adapter = favouritesAdapter

        scrollListener = object :
            EndlessRecyclerViewScrollListener(binding.recyclerNotification.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
//                        x=x+1
//                        viewModel.fetchNextPage(""+x)
//                        Log.d(TAG, "onLoadMore: ")
            }
        }

        binding.recyclerNotification.removeOnScrollListener(scrollListener)
        binding.recyclerNotification.addOnScrollListener(scrollListener)
        val appSharedPrefs = PreferenceManager
            .getDefaultSharedPreferences(context)
        val gson = Gson()
        val json = appSharedPrefs.getString("MyObject", "")
        val obj = gson.fromJson(json, Content::class.java)
         val _accountsList = MutableLiveData<MutableList<Content>?>(ArrayList())
        _accountsList.value!!.add(obj)
        _accountsList.value=_accountsList.value
        _accountsList.observe(viewLifecycleOwner){
            favouritesAdapter.submitList(it)
            favouritesAdapter.notifyDataSetChanged()
        }
//        userrepositiry.getAllFavourites().apply {
//            favouritesAdapter.submitList(it)
//            favouritesAdapter.notifyDataSetChanged()
//        }
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        model._accountsList.observe(viewLifecycleOwner) {
//        viewModel.accountsList.observe(viewLifecycleOwner) {

//it.sortByDescending { it.price }

            favouritesAdapter.submitList(it)
            favouritesAdapter.notifyDataSetChanged()

        }


    }

    override fun onResume() {
        Log.d(TAG, "sdfonResume:1 ")
        super.onResume()

        Log.d(TAG, "sdfonResume: ")
    }

    override fun onPause() {
        Log.d(TAG, "sdfonPause: ")
        super.onPause()
        Log.d(TAG, "sdfonPause: 1")
    }

    override fun onStart() {
        Log.d(TAG, "onStart: ")
        super.onStart()
        Log.d(TAG, "onStart:1 ")
    }

    override fun onStop() {
        Log.d(TAG, "onStop: ")
        super.onStop()
        Log.d(TAG, "onStop:1 ")
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
        Log.d(TAG, "onDestroy: 1")
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "onActivityResult: 11324")
            if (resultCode == Activity.RESULT_OK) {
                if (data?.extras!!.containsKey("return")) {
                    val myValue = data?.extras!!.getString("return")
                    Log.d(TAG, "onActivityResult: " + myValue)
                    // Use the returned value
                }

        }
    }
//    override fun setI(name: String?) {
//        Log.d(TAG, "onActivityResult: 113245555")
//    }

    override fun onAttachFragment(childFragment: Fragment) {
        Log.d(TAG, "onActivityResult: 1132455557999")
        super.onAttachFragment(childFragment)
        Log.d(TAG, "onActivityResult: 1132455558798")
    }
}