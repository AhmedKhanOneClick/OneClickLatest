package com.gama.task.ui.fragments.orders

import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R


import com.gama.task.databinding.FragmentTransactionsTablesBinding
import com.gama.task.models.Content
import com.gama.task.models.Content6
import com.gama.task.models.Order
import com.gama.task.ui.Home.AdvancedSearch.Departments.DepartmentFragment.Companion.TAG
import com.gama.task.ui.base.BaseFragment
import com.gama.task.ui.fragments.voicedatacharg.mobilyfragment.MobileDataAdapter
import com.gama.task.util.EndlessRecyclerViewScrollListener
import com.gama.task.util.EventObserver
import com.gama.task.util.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrdersFragment : BaseFragment<OrdersDataViewModel, FragmentTransactionsTablesBinding>(
    OrdersDataViewModel::class.java
) {
//    Fragment
//}(R.layout.fragment_data_recharg_mobily)


    var x:Int=1
    private var ordersDataAdapter by autoCleared<OrdersDataAdapter>()

    /**
     * A recyclerView scrollListener to handle Scroll.
     */
    private var scrollListener by autoCleared<EndlessRecyclerViewScrollListener>()

    override fun getLayoutRes() = R.layout.fragment_transactions_tables

    override fun init() {
        viewModel.updateRequest("en")
        viewModel.allcontacts.observe(viewLifecycleOwner, ::handleApiStatus)

//init account list
        initAccountList()
binding.create.setOnClickListener {
    val products12=Order.Products11("0a94af0a3bed4f1dae06738b2629af01",1.0)
    val depts = Order(678904234.0,58.0, 58.0,2.0,3.0,11.0,"shipped",viewModel.getvendorid(),
        listOf(products12)
    )
    viewModel.addDepts(depts)
    viewModel.accept_statues1()
}
    }



    private fun initAccountList() {

        viewModel.returnwithsuccess.observe(viewLifecycleOwner, EventObserver {
//            binding.setVariable(BR.isLoading, false)
        })
        viewModel.navigatewithresult.observe(viewLifecycleOwner) {

        }


        ordersDataAdapter = OrdersDataAdapter(dataBindingComponent, appExecutors) { content: Content6, view: View ->
//                    findNavController().navigate(
//                        R.id.actionsubcategories1,
//                        bundleOf(
//                            "req_id" to content.id.toString()
////                            "hotelSearchRequest" to viewModel.accountsList.value!!
//                        )
//                    )
            findNavController().navigate(
                R.id.getorderdetails,
                bundleOf(
                    "req_id" to content.id.toString()
//                            "hotelSearchRequest" to viewModel.accountsList.value!!
                )
            )
            Log.d(TAG, "initAccountList: "+content.id.toString())


        }
//        val layoutManager = GridLayoutManager(context, 2)

        // at last set adapter to recycler view.

        // at last set adapter to recycler view.
//        binding.rvCategories.setLayoutManager(layoutManager)
        binding.rvMenuOderDetailes.adapter = ordersDataAdapter

        scrollListener = object :
            EndlessRecyclerViewScrollListener(binding.rvMenuOderDetailes.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
//                        x=x+1
//                        viewModel.fetchNextPage(""+x)
//                        Log.d(TAG, "onLoadMore: ")
            }
        }

        binding.rvMenuOderDetailes.removeOnScrollListener(scrollListener)
        binding.rvMenuOderDetailes.addOnScrollListener(scrollListener)

        viewModel.accountsList.observe(viewLifecycleOwner) {

//it.sortBy { it.id }

            ordersDataAdapter.submitList(it)
            ordersDataAdapter.notifyDataSetChanged()

        }


    }

}