package com.gama.task.ui.pager

import androidx.recyclerview.widget.LinearLayoutManager
import com.gama.task.R
import com.gama.task.databinding.FragmentMainCategoryBinding
import com.gama.task.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


/*
    created by Abdallah.elsyd.sh@gmail.com
 */
@AndroidEntryPoint
class MainCategoriesFragment :
    BaseFragment<PagerViewModel, FragmentMainCategoryBinding>(PagerViewModel::class.java) {

    var categoriesListAdaptor: CategoriesListAdaptor = CategoriesListAdaptor()

    override fun getLayoutRes() = R.layout.fragment_main_category
    override fun init() {
        initRecyclerView()
        addDataSet()

    }

    private fun addDataSet() {
        val data = CategoryLisDataSource.createDataSet()
        categoriesListAdaptor.submitList(data)
    }

    private fun initRecyclerView() {
        binding.rvCategories.apply {
            adapter = categoriesListAdaptor
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}