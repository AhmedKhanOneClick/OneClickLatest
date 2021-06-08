package com.gama.task.ui.fragments.sidemenu

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.gama.saudi2go.data.db.UserAuthDao
import com.gama.task.R
import com.gama.task.data.api.RetrofitClient
import com.gama.task.models.menumodel.profile.ProfileModel
import kotlinx.android.synthetic.main.fragment_menu_account.*
import retrofit2.Call
import retrofit2.Response

class AccountFragmnet:Fragment(R.layout.fragment_menu_account) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         var  userAuthDao= UserAuthDao()

        var  token :String=userAuthDao.getUserToken().toString()

        Log.e("profile",token)
getProfile1(token)

    }

    private fun getProfile1(token: String) {
        RetrofitClient.instance.getUserLoggedInProfile("Bearer " + token)
            .enqueue(object : retrofit2.Callback<ProfileModel> {
                override fun onFailure(call: Call<ProfileModel>, t: Throwable) {
                    Log.e("profilef", t.message.toString())
                }

                override fun onResponse(
                    call: Call<ProfileModel>,
                    response: Response<ProfileModel>
                ) {

                    if (response.isSuccessful) {

                        account_pos_id.text = response.body()?.data?.posCode.toString()

                        account_phone.text = response.body()?.data?.phoneNumber.toString()

                        account_email.text = response.body()?.data?.credential?.email.toString()

                        account_shop_name.text = response.body()?.data?.shopName.toString()

                        account_name.text =
                            (response.body()?.data?.posCode.toString() + response.body()?.data?.lastName.toString())

                    }else {
                        Log.e("profile", response.message().toString())
                    }
                    }


            })

    }
}