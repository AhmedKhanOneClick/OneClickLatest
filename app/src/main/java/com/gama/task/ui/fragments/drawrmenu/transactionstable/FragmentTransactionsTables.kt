package com.gama.task.ui.fragments.drawrmenu.transactionstable

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.drawrmenu.orderprinttable.OrderPrintAdapter
import com.gama.task.ui.fragments.drawrmenu.orderprinttable.OrderPrintTableData
//- import com.gama.task.ui.fragments.giftcards.tmmmtfragment.TmmmtFragmentDirections
import kotlinx.android.synthetic.main.fragment_order_print.*
import kotlinx.android.synthetic.main.fragment_transactions_tables.*

class FragmentTransactionsTables:Fragment(R.layout.fragment_transactions_tables),TransactionsAdapter.OnItemClickListener {
    val transactionsList=ArrayList<TransactionTableData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transactionsList.add(TransactionTableData("122","222.0","10","completed"))
        transactionsList.add(TransactionTableData("122","222.0","10","completed"))
        transactionsList.add(TransactionTableData("122","222.0","10","completed"))
        transactionsList.add(TransactionTableData("122","222.0","10","completed"))
        transactionsList.add(TransactionTableData("122","222.0","10","completed"))
        transactionsList.add(TransactionTableData("122","222.0","10","completed"))
        transactionsList.add(TransactionTableData("122","222.0","10","completed"))
        transactionsList.add(TransactionTableData("122","222.0","10","completed"))
        transactionsList.add(TransactionTableData("122","222.0","10","completed"))
        transactionsList.add(TransactionTableData("122","222.0","10","completed"))
        transactionsList.add(TransactionTableData("122","222.0","10","completed"))
        transactionsList.add(TransactionTableData("122","222.0","10","completed"))



        rv_menu_oder_detailes.adapter = TransactionsAdapter(transactionsList,this)
        rv_menu_oder_detailes.layoutManager = LinearLayoutManager(context)
        rv_menu_oder_detailes.setHasFixedSize(true)


    }

    override fun onClick(position: Int) {
     // findNavController().navigate(FragmentTransactionsTablesDirections.actionFragmentTransactionsTablesToFragmentTransactionDetailes())
    }

    override fun onLongClick(position: Int) {

    }
}