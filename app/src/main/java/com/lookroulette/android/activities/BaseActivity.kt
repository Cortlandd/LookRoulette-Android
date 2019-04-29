package com.lookroulette.android.activities

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import com.lookroulette.android.LookRoulette
import com.lookroulette.android.R
import com.lookroulette.android.dialogs.LookRouletteProgressDialog

open class BaseActivity : AppCompatActivity() {

    /**
     * A Toast to be used across Activites that inherit BaseActivity
     */
    protected var activityToast: Toast? = null

    /**
     * A progressDialog to be used across Activities that inherit BaseActivity
     */
    protected var lookRouletteProgressDialog: LookRouletteProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onPause() {
        super.onPause()
    }

    /**
     * Show Progress dialog
     *
     * @param messageId The String resource to be displayed.
     */
    fun showProgressDialog(messageId: Int) {
        showProgressDialog(getString(messageId))
    }

    /**
     * Show Progress Dialog
     *
     * @param message The String message to be displayed.
     */
    fun showProgressDialog(message: String) {
        showProgressDialog(message, true)
    }

    /**
     * Show Progress Dialog
     *
     * @param messageId The String resource to be displayed.
     * @param cancelable Can this Progress Dialog be cancelled?
     */
    fun showProgressDialog(messageId: Int, cancelable: Boolean) {
        showProgressDialog(getString(messageId), cancelable)
    }

    /**
     * Show Progress Dialog
     *
     * @param message The String message to be displayed.
     * @param cancelable Can this Progress Dialog be cancelled?
     */
    fun showProgressDialog(message: String, cancelable: Boolean) {
        if (lookRouletteProgressDialog != null && lookRouletteProgressDialog!!.isShowing()) {
            lookRouletteProgressDialog?.setMessage(message)
        } else {
            lookRouletteProgressDialog = LookRouletteProgressDialog(this, cancelable)
            lookRouletteProgressDialog?.setMessage(message)
            lookRouletteProgressDialog?.show()
        }
    }

    /**
     * Cancel current Progress Dialog
     */
    fun cancelProgressDialog() {

        if (lookRouletteProgressDialog != null) {
            lookRouletteProgressDialog?.dismiss()
            lookRouletteProgressDialog = null
        }
    }

    /**
     * A simple Dialog to show an alert.
     */
    fun showDialog(message: String) {
        AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("ok") { dialog, which -> dialog.dismiss() }
                .show()
    }

    /**
     * Hide currently active Keyboard
     */
    fun hideKeyboard() {
        val view = findViewById<View>(android.R.id.content)
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.applicationWindowToken, 0)
        }
    }


    //-------------- Toasts -----------------

    fun toast(message: String, length: Int) {
        if (activityToast == null) {
            val tv = LayoutInflater.from(LookRoulette().applicationContext).inflate(R.layout.toast_layout, null) as TextView
            tv.text = message

            activityToast = Toast(LookRoulette().getApplicationContext())
            activityToast?.setGravity(Gravity.CENTER or Gravity.TOP, 0, LookRoulette().getApplicationContext()!!.getResources().getDimensionPixelOffset(R.dimen.toast_offset))
            activityToast?.duration = Toast.LENGTH_LONG
            activityToast?.view = tv
        } else {
            val v = activityToast?.view
            val tv = v as TextView
            tv.text = message
        }
        activityToast!!.duration = length
        activityToast!!.show()
    }

    fun cancelToast() {
        if (activityToast != null)
            activityToast?.cancel()
    }

    fun toastShort(messageId: Int) {
        toastShort(LookRoulette().getApplicationContext()!!.getString(messageId))
    }

    fun toastShort(message: String) {
        toast(message, Toast.LENGTH_SHORT)
    }

    fun toastLong(messageId: Int) {
        toastLong(LookRoulette().getApplicationContext()!!.getString(messageId))
    }

    fun toastLong(message: String) {
        toast(message, Toast.LENGTH_LONG)
    }

    //-------------- Orientation locks -----------------

    fun lockOrientationLandscape(activity: Activity) {

        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    fun lockOrientationPortrait(activity: Activity) {

        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    fun isLandscape(): Boolean {
        return LookRoulette().getApplicationContext()!!.getResources().getConfiguration().orientation === Configuration.ORIENTATION_LANDSCAPE
    }

    fun isTablet(activity: Activity): Boolean {
        return activity.resources.configuration.smallestScreenWidthDp > 520
    }
}
