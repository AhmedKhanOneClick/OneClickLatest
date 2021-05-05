package com.gama.task.ui.fragments.voicedatacharg.mobilyfragment

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.databinding.FragmentDataRechargMobilyBinding
import com.gama.task.ui.base.BaseFragment
import com.gama.task.util.EndlessRecyclerViewScrollListener
import com.gama.task.util.EventObserver
import com.gama.task.util.autoCleared

class MobilyFragment : BaseFragment<MobilyDataViewModel, FragmentDataRechargMobilyBinding>(
    MobilyDataViewModel::class.java
) {
//    Fragment
//}(R.layout.fragment_data_recharg_mobily)


    var x:Int=1
    private var mobileDataAdapter by autoCleared<MobileDataAdapter>()

    /**
     * A recyclerView scrollListener to handle Scroll.
     */
    private var scrollListener by autoCleared<EndlessRecyclerViewScrollListener>()

    override fun getLayoutRes() = R.layout.fragment_data_recharg_mobily

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
    }



    private fun initAccountList() {

        viewModel.returnwithsuccess.observe(viewLifecycleOwner, EventObserver {
//            binding.setVariable(BR.isLoading, false)
        })
        viewModel.navigatewithresult.observe(viewLifecycleOwner) {

        }


        mobileDataAdapter = MobileDataAdapter(dataBindingComponent, appExecutors) {
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

//it.sortBy { it.id }

            mobileDataAdapter.submitList(it)
            mobileDataAdapter.notifyDataSetChanged()


//                    val swipeHandler = object : SwipeToDeleteCallback(this!!.requireContext(),"read") {
//                        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                            val adapter = recycler_notification.adapter as NotificationAdapter
//
//                            Log.d("onSwiped", "onSwiped: "+ viewHolder.adapterPosition)
//                            Log.d(TAG, "onSwiped: " +it[viewHolder.adapterPosition].body)
//
//
//viewModel.updateDetailsRequest(""+it[viewHolder.adapterPosition].id)
//                            viewModel.do_read()
//                                .observe(viewLifecycleOwner
//                                ) {
//                                    handleApiStatus(it)
//
//                                    if (it.status == Status.SUCCESS){
//
//
//                                        viewModel.dispalyagain()
//                                    }else{
//                                       viewModel.dispalyagain()
//                                    }
//                                }
////                            }
////                onDeleteClicked(it[viewHolder.adapterPosition])
////
////                NotificationUtils().cancelNotification(todoItem, MainActivity.this)
//                        }
//                    }
//                    val itemTouchHelper = ItemTouchHelper(swipeHandler)
//                    itemTouchHelper.attachToRecyclerView(recycler_notification)

        }


    }

}