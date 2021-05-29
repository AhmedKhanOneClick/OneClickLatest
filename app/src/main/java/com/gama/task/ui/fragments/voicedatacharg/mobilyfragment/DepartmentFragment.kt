package com.gama.task.ui.Home.AdvancedSearch.Departments

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import android.view.inputmethod.EditorInfo
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.gama.task.R
import com.gama.task.binding.FragmentDataBindingComponent
import com.gama.task.databinding.FragmentAdvancedDepartmentsBinding
import com.gama.task.models.Resource
import com.gama.task.models.Status
import com.gama.task.ui.common.DialogType
import com.gama.task.ui.common.GeneralDialog
import com.gama.task.ui.fragments.voicedatacharg.mobilyfragment.SharedViewModel
import com.gama.task.ui.main.MainActivity
import com.gama.task.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_advanced_departments.view.*


/**
 * Display login UI form.
 */
@AndroidEntryPoint
class DepartmentFragment() : DialogFragment()
//    ,
//    BaseFragment<LoginViewModel, FragmentLoginBinding>(LoginViewModel::class.java)
    ,
    ViewTreeObserver.OnGlobalLayoutListener
//    BaseFragment<LoginViewModel, FragmentLoginBinding>(LoginViewModel::class.java)

{
    lateinit var model: SharedViewModel
    var callback: Communicator? = null

    interface Communicator {
        fun setI(name: String?)
    }
    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)
    lateinit var binding: FragmentAdvancedDepartmentsBinding
    private val viewModel: DepartmentViewModel by viewModels()
//    binding = DataBindingUtil.setContentView(this, R.layout.fragment_login)
//    binding.lifecycleOwner = this
    companion object {

        const val TAG = "DepartmentFragment"

        private const val id2 = "KEY_SUBTITLE1"
        private const val statuees = "KEY_SUBTITLE2"


        fun newInstance(subTitle: String, subTitle1: String): DepartmentFragment {
            val args = Bundle()

            args.putString(id2, subTitle)
            args.putString(statuees, subTitle1)

            val fragment = DepartmentFragment()
            fragment.arguments = args
            return fragment
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate<FragmentAdvancedDepartmentsBinding>(
             LayoutInflater.from(context),
             R.layout.fragment_advanced_departments,
             container,
             false, dataBindingComponent
         )

        binding.lifecycleOwner = this
                return inflater.inflate(R.layout.fragment_advanced_departments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        setupView(view)
//        setupClickListeners(view)

//        view.id_accept.setText(""+arguments?.get(id2.toString()))
//        view.statues_accept.setText(""+arguments?.get(statuees.toString()))
//     viewModel.updateDetailsRequest(""+arguments?.get(id2.toString()))
        init()
initSignIn(view)
    }

    override fun onStart() {

        super.onStart()

        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )

    }


    var android_id = ""
    var x:Int=0


//    override fun getLayoutRes() = R.layout.fragment_login

     fun init() {
//        logout()
//        initScrollChildToMathScreenSize()
//        initSignIn()
      // initSignUp()
     //   initForgetPass()
//        val id: String = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)

    }


    /**
     * add view observer to add margin to footer img if it's not aligned with screen bottom.
     */
//    private fun initScrollChildToMathScreenSize() {
//
//        if (binding.loginForm.viewTreeObserver.isAlive) {
//            binding.loginForm.viewTreeObserver.addOnGlobalLayoutListener(this@LoginFragment)
//        }
//    }


    /**
     * - validate on login with amazon form whe login btn clicked.
     * - onValid send login request.
     * - handle the request states and if success navigate to [MainActivity].
     * if request is reqistered before but not complete  navigate to [Confirm Signup].
     */
     fun initSignIn(view: View) {


//        viewModel.navigate.observe(viewLifecycleOwner, EventObserver {
//            openActivity(MainActivity::class.java, true)
//        })
//        viewModel.navigateToMainActivity.observe(viewLifecycleOwner, EventObserver {
//view.accept.setOnClickListener {
//    viewModel.accept_statues()
//    .observe(viewLifecycleOwner) {
//                    handleApiStatus(it)
//                    if (it.status == Status.SUCCESS){
//
//
////                        binding.linear1.visibility=View.INVISIBLE
////                        Toast.makeText(context,"تم الاعتماد",Toast.LENGTH_LONG).show()
//
//                        findNavController().navigate(
//                            R.id.hotelsListFragment,
//                            bundleOf(
//                                "req_no" to view.id_accept.text.toString()
////                            "hotelSearchRequest" to viewModel.accountsList.value!!
//                            )
//                        )
//                }else{
////                        handle401Error()
//            }
//            }
//}
//        view.cancel.setOnClickListener { dismiss() }


//        })
        view.recent.setOnClickListener {
//            val image = resources.getDrawable(R.drawable.pop_up_text_back2) as Drawable
            view.recent.setBackgroundResource(R.drawable.pop_up_text_back2)
            model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
            model.sendMessage("MindOrks")
            dismiss()
        }
        view.asc.setOnClickListener {
//            val image = resources.getDrawable(R.drawable.pop_up_text_back2) as Drawable
            view.recent.setBackgroundResource(R.drawable.pop_up_text_back2)
            model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
            model.sendAsc("MindOrks")
            dismiss()
        }
        view.desc.setOnClickListener {
//            val image = resources.getDrawable(R.drawable.pop_up_text_back2) as Drawable
            view.recent.setBackgroundResource(R.drawable.pop_up_text_back2)
            model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
            model.sendDesc("MindOrks")
            dismiss()
        }

//        view.apply.setOnClickListener {
////            var activity: AppCompatActivity? = activity as AppCompatActivity?
////            CalenderFragment.newInstance(
////                "", ""
////            )
////                .apply { isCancelable = false
////                }
////
////                .show(activity!!.getSupportFragmentManager(), SearchStatuestFragment.TAG)
////            Handler().postDelayed({ dismiss() }, 1000)
//            val bundle = Bundle()
//            bundle.putString("return", "MyValue")
//
//            val intent = Intent().putExtras(bundle)
////            fragmentManager.set
////            fragmentManager?.setFragmentResult(1.toString(),bundle)
////            setTargetFragment(this, 0);
////targetFragment!!.onActivityResult(1, 1,intent)
////            targetFragment!!.setTargetFragment(targetFragment,1)
//            targetFragment!!.onActivityResult(1, Activity.RESULT_OK, intent)
//
//            callback?.setI("Important Data");
//            dismiss()
//////            findNavController().navigate(R.id.searchstatues1)
//        }

        viewModel.error.observe(viewLifecycleOwner, EventObserver {
            if (x == 1) {

            } else {
                handle401Error()
            }
        })

    }

    /**
     * override 401 error handling in login request to show error msg with invalid inputs.
     */
    fun handle401Error() {
//x=x+1
        GeneralDialog(DialogType.ERROR, "من فضلك حاول مره اخري").show(
            childFragmentManager,
            tag
        )
    }


    override fun onGlobalLayout() {

    }





    fun <T> handleApiStatus(apiStatus: Resource<T>) {



        // handle loading status
//        binding.setVariable(BR.isLoading, apiStatus.status == Status.LOADING)


        // update view if request has content


//        binding.setVariable(BR.accountnameStr, apiStatus.data != null)

        // user is logged in but token expired or it's login request with un valid data.
        if (apiStatus.code == 401) {

        } else if (apiStatus.status == Status.ERROR) {

            // handle error status
            handleApiErrorStatus(apiStatus)
        }
    }
    open fun <T> handleApiErrorStatus(apiStatus: Resource<T>) {
        val errorMsg = when {
            apiStatus.code == 500 -> getString(R.string.error_api_500)
            apiStatus.message != null -> apiStatus.message
            else -> getString(R.string.error_api_general)
        }

//        GeneralDialog(ERROR, errorMsg).show(childFragmentManager, tag)
    }

    override fun onPause() {
//        Log.d(TAG, "onPauseonPause: ")
        super.onPause()
        dismiss()
    }

    override fun onDestroy() {
//        Log.d(TAG, "onPauseonDestroy: ")
        super.onDestroy()

        
        dismiss()
    }

    override fun onResume() {
        super.onResume()

//        Log.d(TAG, "onPauseononResume: ")



//        dismiss()
    }
}