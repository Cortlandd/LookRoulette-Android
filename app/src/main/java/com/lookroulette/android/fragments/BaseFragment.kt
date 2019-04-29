package com.lookroulette.android.fragments


import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import com.lookroulette.android.R


open class BaseFragment : Fragment() {

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    fun getNewDialog(): Dialog {
        val returnDialog = Dialog(activity!!)
        returnDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        returnDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        return returnDialog
    }


}
