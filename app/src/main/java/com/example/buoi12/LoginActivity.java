package com.example.buoi12;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ShareActionProvider;

import com.example.buoi12.databinding.ActivityLoginBinding;
import com.example.buoi12.utils.ValidatorUtils;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements View.OnClickListener {

    private SharedHelper helper;

    @Override
    protected void initAct() {
        helper  = new SharedHelper(this);
        String userName = helper.get(SharedHelper.Keys.USERNAME, null);
        String password = helper.get(SharedHelper.Keys.PASSWORD, null);
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)){
            startMainActivity();
            return;
        }
        binding.btnLogin.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        if (ValidatorUtils.isEmpty(binding.edtUserName, binding.edtPassword)){
            return;
        }
        helper.set(SharedHelper.Keys.USERNAME, binding.edtUserName.getText().toString());
        helper.set(SharedHelper.Keys.PASSWORD, binding.edtPassword.getText().toString());
        startMainActivity();
    }

    private void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
