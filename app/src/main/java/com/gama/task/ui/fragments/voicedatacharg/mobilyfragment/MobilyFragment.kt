package com.gama.task.ui.fragments.voicedatacharg.mobilyfragment

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.databinding.FragmentDataRechargMobilyBinding
import com.gama.task.models.Content
import com.gama.task.ui.Home.AdvancedSearch.Departments.DepartmentFragment
import com.gama.task.ui.Home.AdvancedSearch.Departments.DepartmentFragment.Companion.TAG
import com.gama.task.ui.base.BaseFragment
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.subcategories.SubcategoriesFragmentArgs
import com.gama.task.ui.main.MainActivity
import com.gama.task.util.EndlessRecyclerViewScrollListener
import com.gama.task.util.EventObserver
import com.gama.task.util.autoCleared
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.card_mobily_item.view.*


@AndroidEntryPoint
class MobilyFragment : BaseFragment<MobilyDataViewModel, FragmentDataRechargMobilyBinding>(
    MobilyDataViewModel::class.java
),DepartmentFragment.Communicator {
//    Fragment
//}(R.layout.fragment_data_recharg_mobily)

    private val args by navArgs<MobilyFragmentArgs>()
    var x:Int=1
    private var mobileDataAdapter by autoCleared<MobileDataAdapter>()

    /**
     * A recyclerView scrollListener to handle Scroll.
     */
    private var scrollListener by autoCleared<EndlessRecyclerViewScrollListener>()

    override fun getLayoutRes() = R.layout.fragment_data_recharg_mobily

    override fun init() {
        Log.d(TAG, "init: "+args.reqId)
        viewModel.updateRequest(args.reqId,"en")
//        viewModel.updateRequest1("en")
        viewModel.allcontacts.observe(viewLifecycleOwner, ::handleApiStatus)

//init account list
        initAccountList()

        binding.fav.setOnClickListener {
            findNavController().navigate(
                R.id.action_favouritefragment
            )
        }
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
        model.message.observe(viewLifecycleOwner) {
            Log.d(ContentValues.TAG, "init: "+it.toString())
            viewModel.accountsList.observe(viewLifecycleOwner) {

//                it.sortByDescending { it.createdAt }

                mobileDataAdapter.submitList(it)
                mobileDataAdapter.notifyDataSetChanged()
            }
        }

        model.asc.observe(viewLifecycleOwner) {
            Log.d(ContentValues.TAG, "init: "+it.toString())
            viewModel.accountsList.observe(viewLifecycleOwner) {

                it.sortBy { it.price }

                mobileDataAdapter.submitList(it)
                mobileDataAdapter.notifyDataSetChanged()
            }
        }

        model.desc.observe(viewLifecycleOwner) {
            Log.d(ContentValues.TAG, "init: "+it.toString())
            viewModel.accountsList.observe(viewLifecycleOwner) {

                it.sortByDescending { it.price }

                mobileDataAdapter.submitList(it)
                mobileDataAdapter.notifyDataSetChanged()
            }
        }
    }



    private fun initAccountList() {

        viewModel.returnwithsuccess.observe(viewLifecycleOwner, EventObserver {
//            binding.setVariable(BR.isLoading, false)
        })
        viewModel.navigatewithresult.observe(viewLifecycleOwner) {

        }


        mobileDataAdapter = MobileDataAdapter(dataBindingComponent, appExecutors ) { content: Content, view: View ->

            if  (view .id==R.id.favourites ){

                Log.e("click","favourites")
                view.favourites.background=(resources.getDrawable(R.drawable.bg_cart_counter_red))

            }else{

                GlobalClass.globalCartList.add(
                    CartItem(R.drawable.facebook
                        ,content.price
                        ,content.quantity
                        ,content.createdAt))

                if (!GlobalClass.globalCartList.isEmpty()){
                    (activity as MainActivity).observeCartCounter()
                    val action=MobilyFragmentDirections.actionMobilyFragmentToBottomSheetCheckOut()
                    findNavController().navigate(action)
                  // findNavController().navigate(MobilyFragmentDirections.action_MobilyFragment_to_bottomSheetCheckOut())
            }
            }



//            binding.favourites.setImageDrawable(resources.getDrawable(R.drawable.amazon))
            val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
            model.sendfavourites(content)
//viewModel.sendfavourites(content)
            val appSharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(context)
            val prefsEditor = appSharedPrefs.edit()
            val gson = Gson()
            val json = gson.toJson(content)
            prefsEditor.putString("MyObject", json)
            prefsEditor.commit()
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
        binding.recyclerNotification.adapter = mobileDataAdapter

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

        viewModel.accountsList.observe(viewLifecycleOwner) {

//it.sortByDescending { it.price }

            mobileDataAdapter.submitList(it)
            mobileDataAdapter.notifyDataSetChanged()

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
    override fun setI(name: String?) {
        Log.d(TAG, "onActivityResult: 113245555")
    }

    override fun onAttachFragment(childFragment: Fragment) {
        Log.d(TAG, "onActivityResult: 1132455557999")
        super.onAttachFragment(childFragment)
        Log.d(TAG, "onActivityResult: 1132455558798")
    }
}