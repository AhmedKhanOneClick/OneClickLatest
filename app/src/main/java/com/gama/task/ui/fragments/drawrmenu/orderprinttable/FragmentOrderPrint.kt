package com.gama.task.ui.fragments.drawrmenu.orderprinttable

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.voicedatacharg.gofragment.GoAdapter
import kotlinx.android.synthetic.main.fragment_data_card_go.*
import kotlinx.android.synthetic.main.fragment_order_print.*

class FragmentOrderPrint:Fragment(R.layout.fragment_order_print),OrderPrintAdapter.OnItemClickListener {

    val orderPrintList=ArrayList<OrderPrintTableData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        orderPrintList.add(OrderPrintTableData("122","222.0","completed"))
        orderPrintList.add(OrderPrintTableData("122","222.0","completed"))
        orderPrintList.add(OrderPrintTableData("122","222.0","completed"))
        orderPrintList.add(OrderPrintTableData("122","222.0","completed"))
        orderPrintList.add(OrderPrintTableData("122","222.0","completed"))
        orderPrintList.add(OrderPrintTableData("122","222.0","completed"))
        orderPrintList.add(OrderPrintTableData("122","222.0","completed"))
        orderPrintList.add(OrderPrintTableData("122","222.0","completed"))
        orderPrintList.add(OrderPrintTableData("122","222.0","completed"))
        orderPrintList.add(OrderPrintTableData("122","222.0","completed"))
        orderPrintList.add(OrderPrintTableData("122","222.0","completed"))
        orderPrintList.add(OrderPrintTableData("122","222.0","completed"))

        rv_menu_receipt.adapter = OrderPrintAdapter(orderPrintList,this)
        rv_menu_receipt.layoutManager = LinearLayoutManager(context)
        rv_menu_receipt.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {

        findNavController().navigate(FragmentOrderPrintDirections.actionFragmentOrderPrintToFragmentReceipt())
    }

    override fun onLongClick(position: Int) {

    }
}