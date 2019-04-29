package com.lookroulette.android.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.lookroulette.android.R;
import com.lookroulette.android.activities.BaseActivity;


public class LookRouletteProgressDialog extends Dialog {

    private BaseActivity baseActivity = null;
    private String       message      = null;
    private boolean      isCancelable = true;

    public LookRouletteProgressDialog(BaseActivity activity) {
        this(activity, true);
    }

    public LookRouletteProgressDialog(BaseActivity activity, boolean cancelable) {
        super(activity);
        baseActivity = activity;
        isCancelable = cancelable;

        setOwnerActivity(baseActivity);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // We handle canceling ourselves in onBackPressed().
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.progress_dialog);
        setMessage(message);
    }

    public void setMessage(String message) {
        this.message = message;
        TextView view = (TextView) findViewById(R.id.progress_text);
        if (view != null) {
            view.setText(message);
        }
    }

    @Override
    public void onBackPressed() {
        if (isCancelable) {
            dismiss();
            baseActivity.onBackPressed();
        }
    }
}