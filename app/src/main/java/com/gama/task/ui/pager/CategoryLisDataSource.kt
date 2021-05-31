package com.gama.task.ui.pager

import com.gama.task.R
import com.gama.task.models.CategoryItem
import java.util.*

/*
    created by Abdallah.elsyd.sh@gmail.com
 */
class CategoryLisDataSource {
    companion object {
        fun createDataSet(): ArrayList<CategoryItem> {
            val list = ArrayList<CategoryItem>()
            list.add(
                CategoryItem(
                    0,
                    R.string.category_title0.toString(),
                    R.string.category_paragraph_0.toString(),
                    R.drawable.ic_data
                )
            )
            list.add(
                CategoryItem(
                    1,
                    R.string.category_title1.toString(),
                    R.string.category_paragraph_1.toString(),
                    R.drawable.ic_voice
                )
            )

            list.add(
                CategoryItem(
                    2,
                    R.string.category_title2.toString(),
                    R.string.category_paragraph_2.toString(),
                    R.drawable.ic_game_recharge
                )
            )
            list.add(
                CategoryItem(
                    3,
                    R.string.category_title3.toString(),
                    R.string.category_paragraph_3.toString(),
                    R.drawable.ic_cinima,

                    )
            )
            list.add(
                CategoryItem(
                    4,
                    R.string.category_title4.toString(),
                    R.string.category_paragraph_4.toString(),
                    R.drawable.ic_gift_card,
                )
            )
            list.add(
                CategoryItem(
                    5,
                    R.string.category_title5.toString(),
                    R.string.category_paragraph_5.toString(),
                    R.drawable.ic_favorite
                )
            )
            return list
        }
    }
}