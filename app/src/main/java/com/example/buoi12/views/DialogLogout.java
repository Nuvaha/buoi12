package com.example.buoi12.views;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.buoi12.R;
import com.example.buoi12.databinding.UiDialogBinding;

public class DialogLogout extends Dialog implements View.OnClickListener {

    private UiDialogBinding binding;
    private LayoutCallback callback;

    public DialogLogout(Context context) {
        super(context, android.R.style.Theme_DeviceDefault_Dialog_NoActionBar_MinWidth);
        LayoutInflater inflater = LayoutInflater.from(context);
        binding = DataBindingUtil.inflate(inflater, R.layout.ui_dialog, null, false);
        setContentView(binding.getRoot());
        binding.btnOk.setOnClickListener(this);
        binding.btnCancel.setOnClickListener(this);
    }

    public void setCallback(LayoutCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btn_ok:
                dismiss();
                if (callback != null)
                    callback.onOkClicked();
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
        }

    }

    public interface LayoutCallback{
        void onOkClicked();
    }
}
