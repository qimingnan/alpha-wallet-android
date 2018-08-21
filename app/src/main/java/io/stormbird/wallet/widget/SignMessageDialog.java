package io.stormbird.wallet.widget;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.stormbird.wallet.R;
import io.stormbird.wallet.web3.entity.Message;

public class SignMessageDialog extends Dialog {
    //    private LinearLayout container;
    private TextView message;
    private TextView requester;
    private TextView address;
    private Button btnApprove;
    private Button btnReject;
    private Context context;

    public SignMessageDialog(@NonNull Activity activity) {
        super(activity);
        this.context = activity;

        setContentView(R.layout.dialog_sign_message);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCanceledOnTouchOutside(true);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        message = findViewById(R.id.message);
        requester = findViewById(R.id.requester);
        address = findViewById(R.id.address);
        btnApprove = findViewById(R.id.btn_approve);
        btnReject = findViewById(R.id.btn_reject);
        btnReject.setOnClickListener(v -> dismiss());
    }

    public SignMessageDialog(Activity activity, Message<String> message) {
        this(activity);

        setMessage(message.value);
        setRequester(message.url);
    }

    public void setMessage(CharSequence message) {
        this.message.setText(message);
    }

    public void setRequester(CharSequence requester) {
        this.requester.setText(requester);
    }

    public void setAddress(CharSequence address) {
        this.address.setText(address);
    }

    public void setOnApproveListener(View.OnClickListener listener) {
        btnApprove.setOnClickListener(listener);
    }

    public void setOnRejectListener(View.OnClickListener listener) {
        btnReject.setOnClickListener(listener);

    }
}
