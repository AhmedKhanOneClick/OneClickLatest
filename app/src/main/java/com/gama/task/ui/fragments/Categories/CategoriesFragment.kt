package com.gama.task.ui.fragments.Categories

import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R

import com.gama.task.databinding.FragmentMainCategoryBinding
import com.gama.task.ui.base.BaseFragment
import com.gama.task.util.EndlessRecyclerViewScrollListener
import com.gama.task.util.EventObserver
import com.gama.task.util.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesFragment : BaseFragment<CategoriesDataViewModel, FragmentMainCategoryBinding>(
    CategoriesDataViewModel::class.java
) {
//    Fragment
//}(R.layout.fragment_data_recharg_mobily)


    var x:Int=1
    private var categoriesDataAdapter by autoCleared<CategoriesDataAdapter>()

    /**
     * A recyclerView scrollListener to handle Scroll.
     */
    private var scrollListener by autoCleared<EndlessRecyclerViewScrollListener>()

    override fun getLayoutRes() = R.layout.fragment_main_category

    override fun init() {

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


        categoriesDataAdapter = CategoriesDataAdapter(dataBindingComponent, appExecutors) {
                    findNavController().navigate(
                        R.id.actionsubcategories1,
                        bundleOf(
                            "req_id" to it.id.toString()
//                            "hotelSearchRequest" to viewModel.accountsList.value!!
                        )
                    )



        }
//        val layoutManager = GridLayoutManager(context, 2)

        // at last set adapter to recycler view.

        // at last set adapter to recycler view.
//        binding.rvCategories.setLayoutManager(layoutManager)
        binding.rvCategories.adapter = categoriesDataAdapter

        scrollListener = object :
            EndlessRecyclerViewScrollListener(binding.rvCategories.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
//                        x=x+1
//                        viewModel.fetchNextPage(""+x)
//                        Log.d(TAG, "onLoadMore: ")
            }
        }

        binding.rvCategories.removeOnScrollListener(scrollListener)
        binding.rvCategories.addOnScrollListener(scrollListener)

        viewModel.accountsList.observe(viewLifecycleOwner) {

//it.sortBy { it.id }

            categoriesDataAdapter.submitList(it)
            categoriesDataAdapter.notifyDataSetChanged()

        }


    }

}