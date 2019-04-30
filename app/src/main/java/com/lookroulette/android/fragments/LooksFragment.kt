package com.lookroulette.android.fragments



import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lookroulette.android.adapter.LooksAdapter
import com.lookroulette.android.R
import com.lookroulette.android.activities.MainActivity

import com.lookroulette.android.content.LooksContent
import com.lookroulette.android.content.LooksContent.LookItem
import com.lookroulette.android.dialogs.LookRouletteProgressDialog
import org.jetbrains.anko.support.v4.progressDialog

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [LooksFragment.OnListFragmentInteractionListener] interface.
 */
class LooksFragment : BaseFragment() {

    // TODO: Customize parameters
    private var columnCount = 2

    private var listener: OnListFragmentInteractionListener? = null

    private var activity: MainActivity? = null

    var pdialog: LookRouletteProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_looks_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = LooksAdapter(LooksContent.ITEMS, listener)
            }
        }

        /* Progress Dialog */
        /*
        pdialog = LookRouletteProgressDialog(activity, true)
        pdialog?.setMessage("Testing looks")
        pdialog?.show()
        */

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as MainActivity?
        // Wherever this is implemented at is its context
        // TODO: Improve onAttach for LooksFragment
//        if (context is OnListFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
//        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: LookItem?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
                LooksFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}
