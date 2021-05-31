package com.gama.task.ui.pager

import android.content.Context
import com.gama.task.R
import com.gama.task.models.CategoryItem
import com.gama.task.ui.main.MainActivity
import kotlin.coroutines.coroutineContext

/*
    created by Abdallah.elsyd.sh@gmail.com
 */
//class CategoryLisDataSource {
     object DataSet {

        fun createDataSet(context: Context): ArrayList<CategoryItem> {
            val list = ArrayList<CategoryItem>()
            list.add(
                CategoryItem(
                    0,

                    context.getString(R.string.category_title0),
                    context.getString(R.string.category_paragraph_0),
                    R.drawable.ic_data
                )
            )
            list.add(
                CategoryItem(
                    1,
                    context.getString(R.string.category_title1),
                    context.getString(R.string.category_paragraph_1),
                    R.drawable.ic_voice
                )
            )

            list.add(
                CategoryItem(
                    2,
                    context.getString(R.string.category_title2),
                    context.getString(R.string.category_paragraph_2),
                    R.drawable.ic_game_recharge
                )
            )
            list.add(
                CategoryItem(
                    3,
                    context.getString(R.string.category_title3),
                    context.getString(R.string.category_paragraph_3),
                    R.drawable.ic_cinima,

                    )
            )
            list.add(
                CategoryItem(
                    4,
                    context.getString(R.string.category_title4),
                    context.getString(R.string.category_paragraph_4),
                    R.drawable.ic_gift_card,
                )
            )
            list.add(
                CategoryItem(
                    5,
                    context.getString(R.string.category_title5),
                    context.getString(R.string.category_paragraph_5),
                    R.drawable.ic_favorite
                )
            )
            return list
        }
    }
//}