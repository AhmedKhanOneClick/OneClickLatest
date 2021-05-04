package com.gama.task.ui.fragments.giftcards

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_gift_card.*

class GiftCard:Fragment(R.layout.fragment_gift_card) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        amazon_btn.setOnClickListener {
            val action =
                GiftCardDirections.actionGiftCardToAmazonFragment()
            findNavController().navigate(action)
        }

        careem_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToCareemFragment()
            findNavController().navigate(action)
        }

        ebay_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToEbayragment()
            findNavController().navigate(action)
        }

        facebook_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToFacebookFragment()
            findNavController().navigate(action)
        }

        googleplay_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToGoogleplayFragment()
            findNavController().navigate(action)
        }

        itunes_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToItuneFragment()
            findNavController().navigate(action)
        }

        mcaffee_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToMcaffeeFragment()
            findNavController().navigate(action)
        }

        mrsool_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToMrsoolFragment()
            findNavController().navigate(action)
        }

        noon_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToNoonFragment()
            findNavController().navigate(action)
        }

        office_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToOfficeFragment()
            findNavController().navigate(action)
        }

        razorgold_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToRazorgoldFragment()
            findNavController().navigate(action)
        }

        skype_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToSkypeFragment()
            findNavController().navigate(action)
        }

        tmmmt_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToTmmmtFragment()
            findNavController().navigate(action)
        }

        windows_btn.setOnClickListener{
            val action = GiftCardDirections.actionGiftCardToWindowsFragment()
            findNavController().navigate(action)
        }
    }
}