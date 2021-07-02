package com.gama.task.ui.fragments.subcategories

import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R

import com.gama.task.databinding.FragmentMainCategoryBinding
import com.gama.task.databinding.FragmentSubCategoryBinding
import com.gama.task.ui.base.BaseFragment
import com.gama.task.ui.fragments.voicedatacharg.mobilyfragment.MobilyFragmentDirections
import com.gama.task.ui.main.MainActivity
import com.gama.task.util.EndlessRecyclerViewScrollListener
import com.gama.task.util.EventObserver
import com.gama.task.util.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class SubcategoriesFragment : BaseFragment<SubcategoriesDataViewModel, FragmentSubCategoryBinding>(
    SubcategoriesDataViewModel::class.java
) {
//    Fragment
//}(R.layout.fragment_data_recharg_mobily)

    private val args by navArgs<SubcategoriesFragmentArgs>()
    var x:Int=1
    private var subcategoriesDataAdapter by autoCleared<SubcategoriesDataAdapter>()

    /**
     * A recyclerView scrollListener to handle Scroll.
     */
    private var scrollListener by autoCleared<EndlessRecyclerViewScrollListener>()

    override fun getLayoutRes() = R.layout.fragment_sub_category

    override fun init() {
        val sp: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        var lang=sp.getString("lang",null)
        viewModel.updateRequest(args.reqId,lang.toString())
        viewModel.allcontacts.observe(viewLifecycleOwner, ::handleApiStatus)

//init account list
        initAccountList()

    }



    private fun initAccountList() {

        viewModel.returnwithsuccess.observe(viewLifecycleOwner, EventObserver {
//            binding.setVariable(BR.isLoading, false)
        })
        viewModel.navigatewithresult.observe(viewLifecycleOwner) {

        }


        subcategoriesDataAdapter = SubcategoriesDataAdapter(dataBindingComponent, appExecutors) {

            Log.e("sub category ",it.imageURL)
                    findNavController().navigate(
                        R.id.actionproducts,
                        bundleOf(
                            "req_id" to it.id,
                            "logo_url" to it.imageURL,
                            "logo_name" to it.name
//                            "hotelSearchRequest" to viewModel.accountsList.value!!
                        )
                    )



        }
        val layoutManager = GridLayoutManager(context, 2)

        // at last set adapter to recycler view.

        // at last set adapter to recycler view.
        binding.rvsubcategories.setLayoutManager(layoutManager)
        binding.rvsubcategories.adapter = subcategoriesDataAdapter


//        (activity as MainActivity).open_cart_btn.setOnClickListener {
//
//            val action=SubcategoriesFragmentDirections.actionSubcategoryToCart()
//            findNavController().navigate(action)
//
//        }

        scrollListener = object :
            EndlessRecyclerViewScrollListener(binding.rvsubcategories.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
//                        x=x+1
//                        viewModel.fetchNextPage(""+x)
//                        Log.d(TAG, "onLoadMore: ")
            }
        }

        binding.rvsubcategories.removeOnScrollListener(scrollListener)
        binding.rvsubcategories.addOnScrollListener(scrollListener)

        viewModel.accountsList.observe(viewLifecycleOwner) {

//it.sortBy { it.id }

            subcategoriesDataAdapter.submitList(it)
            subcategoriesDataAdapter.notifyDataSetChanged()

        }


    }

}