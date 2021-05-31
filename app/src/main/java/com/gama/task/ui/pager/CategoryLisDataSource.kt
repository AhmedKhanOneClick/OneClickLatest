package com.gama.task.ui.pager

import com.gama.task.R
import com.gama.task.models.CategoryItem

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
                    "Data Recharge",
                    "mobily - zain - Lebara - Virgin - FRIENDI - stc",
                    R.drawable.ic_data
                )
            )
            list.add(
                CategoryItem(
                    1,
                    "Voice Recharge",
                    "Mobily - Zain - Lebara - Virgin - FRIENDI - Stc - GO",
                    R.drawable.ic_voice
                )
            )

            list.add(
                CategoryItem(
                    2,
                    "Games Cards",
                    "Nintendo - Xbox - PUBG - FIFA - VIP Jalsat - Mobile Legends...",
                    R.drawable.ic_game_recharge
                )
            )
            list.add(
                CategoryItem(
                    3,
                    "(OTT) Cinema",
                    "STARZPLAY - Netflix - Kitab Sawti - Weyyka - Shaid Vip",
                    R.drawable.ic_cinima,

                    )
            )
            list.add(
                CategoryItem(
                    4,
                    "Gift Cards",
                    "Skype - Microsoft - Mcafee - Facebook",
                    R.drawable.ic_gift_card,
                )
            )
            list.add(
                CategoryItem(
                    5,
                    "Favorites",
                    "Long Press On Any Card to Add/Remove Form Your Favorites",
                    R.drawable.ic_favorite
                )
            )
            return list
        }
    }
}