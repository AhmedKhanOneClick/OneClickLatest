package com.gama.task.binding

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import com.gama.task.models.Content
import com.gama.task.ui.Home.AdvancedSearch.Departments.DepartmentFragment
import com.gama.task.ui.Home.AdvancedSearch.Departments.DepartmentFragment.Companion.TAG
import com.gama.task.util.extensions.getDrawableCompat
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.slider.RangeSlider
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.*


object BindingAdapters {

    /**
     * Extension function to set the visibility of the view to [View.VISIBLE] or [View.GONE].
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <View
     *       ...
     *       app:isvisible:"@{true}"/>
     *  ```
     *
     * @receiver [View]
     * @param show Boolean true if target to set visibility to [View.VISIBLE], false to set visibility to [View.GONE]
     *
     * @see setInvisible
     */
    @JvmStatic
    @BindingAdapter("isVisible")
    fun View.showHide(show: Boolean) {
        visibility = if (show) View.VISIBLE else View.GONE
    }

    /**
     * Extension function to set the visibility of the view to [View.INVISIBLE] or [View.VISIBLE].
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <View
     *       ...
     *       app:invisible:"@{true}"/>
     *  ```
     * @receiver [View]
     * @param isInvisible Boolean true if target to set visibility to [View.INVISIBLE], false to set visibility to [View.VISIBLE]
     *
     * @see showHide
     */
    @JvmStatic
    @BindingAdapter("invisible")
    fun View.setInvisible(isInvisible: Boolean) {
        visibility = if (isInvisible) View.INVISIBLE else View.VISIBLE
    }

    /**
     * Extension function to set [TextView]'s style as bold or clear it.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <TextView
     *       ...
     *       app:isBold:"@{true}"/>
     *  ```
     * @receiver [TextView]
     * @param isBold Boolean true to set it **Bold**, false to clear it.
     */
    @JvmStatic
    @BindingAdapter("isBold")
    fun TextView.setBold(isBold: Boolean) {
        if (isBold) {
            setTypeface(null, Typeface.BOLD)
        } else {
            setTypeface(null, Typeface.NORMAL)
        }
    }

    /**
     * Extension function to set all or some corners corners of [ShapeableImageView] to be rounded.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <com.google.android.material.imageview.ShapeableImageView
     *       ...
     *       app:topLeftCorner:"@{@dimen/some_dimen}"
     *       app:topRightCorner:"@{@dimen/some_dimen}"
     *       app:bottomLeftCorner:"@{@dimen/some_dimen}"
     *       app:bottomRightCorner:"@{@dimen/some_dimen}"/>
     *  ```
     *
     *
     * @receiver ShapeableImageView
     * @param topLeftCorner Float? the top-left corner radius or null to make it un-rounded
     * @param topRightCorner Float? the top-right corner radius or null to make it un-rounded
     * @param bottomLeftCorner Float? the bottom-left corner radius or null to make it un-rounded
     * @param bottomRightCorner Float? the bottom-right corner radius or null to make it un-rounded
     */
    @JvmStatic
    @BindingAdapter(
        value = ["topLeftCorner", "topRightCorner", "bottomLeftCorner", "bottomRightCorner"],
        requireAll = false
    )
    fun ShapeableImageView.setCornerRadius(
        topLeftCorner: Float?,
        topRightCorner: Float?,
        bottomLeftCorner: Float?,
        bottomRightCorner: Float?
    ) {
        shapeAppearanceModel = shapeAppearanceModel.toBuilder()
            .setTopLeftCorner(CornerFamily.ROUNDED, topLeftCorner ?: 0f)
            .setTopRightCorner(CornerFamily.ROUNDED, topRightCorner ?: 0f)
            .setBottomLeftCorner(CornerFamily.ROUNDED, bottomLeftCorner ?: 0f)
            .setBottomRightCorner(CornerFamily.ROUNDED, bottomRightCorner ?: 0f)
            .build()
    }


    /**
     * Extension function to set all or some corners corners of [TextInputLayout]'s box to be rounded.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <com.google.android.material.textfield.TextInputLayout
     *       ...
     *       app:topStartCorner:"@{@dimen/some_dimen}"
     *       app:topEndCorner:"@{@dimen/some_dimen}"
     *       app:bottomStartCorner:"@{@dimen/some_dimen}"
     *       app:bottomEndCorner:"@{@dimen/some_dimen}"/>
     *  ```
     *
     * @receiver TextInputLayout
     * @param topStartCorner Float? the top-start corner radius or null to make it un-rounded
     * @param topEndCorner Float? the top-end corner radius or null to make it un-rounded
     * @param bottomStartCorner Float? the bottom-start corner radius or null to make it un-rounded
     * @param bottomEndCorner Float? the bottom-end corner radius or null to make it un-rounded
     */
    @JvmStatic
    @BindingAdapter(
        value = ["topStartCorner", "topEndCorner", "bottomStartCorner", "bottomEndCorner"],
        requireAll = false
    )
    fun TextInputLayout.setBoxCornerRadius(
        topStartCorner: Float?,
        topEndCorner: Float?,
        bottomStartCorner: Float?,
        bottomEndCorner: Float?
    ) {

        setBoxCornerRadii(
            topStartCorner ?: 0f,
            topEndCorner ?: 0f,
            bottomStartCorner ?: 0f,
            bottomEndCorner ?: 0f
        )
    }

    /**
     * Extension function to make [TextInputLayout] listen to editText's text change and clear error.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <com.google.android.material.textfield.TextInputLayout
     *       ...
     *       app:textWatcher:"@{true}"/>
     *  ```
     *
     * @receiver TextInputLayout
     * @param textWatcher Boolean true if the required behavior is to clear error on textChange
     */
    @JvmStatic
    @BindingAdapter("textWatcher")
    fun TextInputLayout.setError(textWatcher: Boolean) {

        if (textWatcher)
            editText?.doOnTextChanged { _, _, _, _ -> error = null }
    }

    /**
     * Extension function to override [TextInputLayout]'s endIcon click listener to perform editText click.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <com.google.android.material.textfield.TextInputLayout
     *       ...
     *       app:overrideEndIconClick:"@{true}"/>
     *  ```
     *
     * @receiver TextInputLayout
     * @param overrideEndIconClick Boolean
     */
    @JvmStatic
    @BindingAdapter("overrideEndIconClick")
    fun TextInputLayout.overrideEndIconClick(overrideEndIconClick: Boolean) {

        if (overrideEndIconClick)
            setEndIconOnClickListener { editText?.performClick() }
    }


    /**
     * Extension function to set [TextView]'s text to be a date with a specific format.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <TextView
     *       ...
     *       app:format:"@{`dd/mm/yyyy`}"
     *       app:time:"@{timeInMillis}"/>
     *  ```
     *
     * @receiver TextView
     * @param time Long? the time in millis to be displayed in a [format]
     * @param format String the format to display the time it it.
     *
     * @see changeTimeFormat
     */
    @SuppressLint("SimpleDateFormat")
    @JvmStatic
    @BindingAdapter(value = ["time", "format"], requireAll = true)
    fun TextView.setDateFormatted(time: Long?, format: String) {

        if (time == null)
            return
        text = SimpleDateFormat(format).format(time)
    }

    /**
     * Extension function to make [TextView] accept a date in a specific format and change set text with another format.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <TextView
     *       ...
     *       app:fromFormat:"@{`dd/mm/yyyy`}"
     *       app:toFormat:"@{`mmm/yyyy`}"
     *       app:time:"@{date in a fromFormat pattern}"/>
     *  ```
     *
     * @receiver TextView
     * @param time String? the date in a [fromFormat] pattern
     * @param fromFormat String the format of [time]
     * @param toFormat String the format to display date with
     *
     * @see setDateFormatted
     */
    @SuppressLint("SimpleDateFormat")
    @JvmStatic
    @BindingAdapter(value = ["time", "fromFormat", "toFormat"], requireAll = true)
    fun TextView.changeTimeFormat(time: String?, fromFormat: String, toFormat: String) {
//        var time1="1992/09/16T00:00:00"
        if (time == null)
            return
//        if(time.equals("0001-01-01T00:00:00")){
//            Log.d("changeTimeFormat", "changeTimeFormat1: " +time)
//             time1 = time.substring(0, time.indexOf('T'))
//            Log.d("changeTimeFormat", "changeTimeFormat2: " +time1)
//        }
//        Log.d("changeTimeFormat", "changeTimeFormat: " +time1)
        time.split('-', '/')
        var time2 = time.replace('-', '/')
        val timeMillis = SimpleDateFormat(fromFormat).parse(time2)?.time

        text = SimpleDateFormat(toFormat).format(timeMillis)
    }

    /**
     * Extension function to set [RangeSlider]'s values to be as from, to values.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <com.google.android.material.slider.RangeSlider
     *       ...
     *       app:valuesWithMaxMin:"@{true}"/>
     *  ```
     *
     * @receiver RangeSlider
     * @param valuesWithMaxMin Boolean true to set values to be as from, to values
     */
    @JvmStatic
    @BindingAdapter("valuesWithMaxMin")
    fun RangeSlider.setRangeValues(valuesWithMaxMin: Boolean) {

        if (valuesWithMaxMin)
            setValues(valueFrom, valueTo)
    }

    /**
     * Extension function to change the [TextView]'s text according to [RangeSlider]'s fromValue.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <TextView
     *       ...
     *       app:textFromRange:"@{id of RangeSlider in camelCase}"
     *       app:valueConcat="@{`$`}"/>
     *  ```
     *
     * @receiver TextView
     * @param slider RangeSlider the slider to listen for its values change and get it's first value
     * @param valueConcat String? the text to contact to the from value of the slider
     *
     * @see textToRange
     */
    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter(value = ["textFromRange", "valueConcat"], requireAll = false)
    fun TextView.textFromRange(slider: RangeSlider, valueConcat: String?) {

        text = "${slider.valueFrom.toInt()} ${valueConcat ?: ""}"

        slider.addOnChangeListener { _, _, _ ->
            text = "${slider.values[0].toInt()} ${valueConcat ?: ""}"
        }
    }

    /**
     * Extension function to change the [TextView]'s text according to [RangeSlider]'s toValue.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <TextView
     *       ...
     *       app:textToRange:"@{id of RangeSlider in camelCase}"
     *       app:valueConcat="@{`$`}"/>
     *  ```
     *
     * @receiver TextView
     * @param slider RangeSlider the slider to listen for its values change and get it's second value
     * @param valueConcat String? the text to contact to the to value of the slider
     *
     * @see textToRange
     */
    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter(value = ["textToRange", "valueConcat"], requireAll = false)
    fun TextView.textToRange(slider: RangeSlider, valueConcat: String?) {

        text = "${slider.valueTo.toInt()} ${valueConcat ?: ""}"

        slider.addOnChangeListener { _, _, _ ->
            text = "${slider.values[1].toInt()} ${valueConcat ?: ""}"
        }
    }


    /**
     * Extension function to set the [ImageView]'s src to icon using the icon name.
     *
     * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
     *  ```xml
     *      <ImageView
     *       ...
     *       app:iconName:"@{`the icon name`}"/>
     *  ```
     *
     * @receiver ImageView
     * @param iconName String? the name of icon to read from drawable
     *
     */
    @JvmStatic
    @BindingAdapter("iconName")
    fun ImageView.readIconByName(iconName: String?) {

        if (iconName == null)
            return

        val resourceId = context.resources.getIdentifier(
            "ic_${iconName.replace("-", "_")}",
            "drawable",
            context.packageName
        )

        if (resourceId == 0)
            return

        setImageDrawable(context.getDrawableCompat(resourceId))
    }
    @JvmStatic
    @BindingAdapter("image")
    fun ImageView.setdatetime(image: String?) {
 var  resourceId=0
        if (image == null)
            return
        val appSharedPrefs = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val prefsEditor = appSharedPrefs.edit()
//            val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val serializedObject: String = appSharedPrefs.getString("MyObject", "")!!
        Log.d(DepartmentFragment.TAG, "setdatetime:7 " + serializedObject.toString())

        if (!serializedObject.equals("")||!serializedObject.equals("[]")) {


            val gson = GsonBuilder().serializeNulls().create()

            var fromJson: List<Content> =
                gson.fromJson(
                    serializedObject,
                    object : TypeToken<ArrayList<Content?>?>() {}.type
                )

            var arrayItems: ArrayList<Content>
            arrayItems= arrayListOf()

            arrayItems= fromJson as ArrayList<Content>
            if(arrayItems.size==0){

                resourceId = context.resources.getIdentifier(
                    "favourites",
                    "drawable",
                    context.packageName
                )
            }
//            else{
//                resourceId = context.resources.getIdentifier(
//                    "favouritesred",
//                    "drawable",
//                    context.packageName
//                )
//            }

  for(i in 0..arrayItems.size-1){
      Log.d(TAG, "setdatetime:3 ")
      if(arrayItems[i].createdAt.equals(image)){
          Log.d(TAG, "setdatetime:4 ")
           resourceId = context.resources.getIdentifier(
              "favouritesred",
              "drawable",
              context.packageName
          )
      }
//      else{
//          Log.d(TAG, "setdatetime:5 ")
//          resourceId = context.resources.getIdentifier(
//              "favourites",
//              "drawable",
//              context.packageName
//          )
//      }
  }
        }else{

            resourceId = context.resources.getIdentifier(
                "favourites",
                "drawable",
                context.packageName
            )
        }


        if (resourceId == 0)
            return

        setImageDrawable(context.getDrawableCompat(resourceId))
    }

}