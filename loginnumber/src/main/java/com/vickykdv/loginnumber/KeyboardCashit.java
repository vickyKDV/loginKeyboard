package com.vickykdv.loginnumber;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.IdRes;


public class KeyboardCashit extends LinearLayout implements View.OnClickListener {

    public TextView mPassword, password_hint;
    private TextView txt_forgotpass;
    private ImageView img_showpassword,img_finger;
    private OnClickListener clickListener;
//    private CompleteListener completeListener;

    public KeyboardCashit(Context context) {
        super(context);
        init();
    }

    public KeyboardCashit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KeyboardCashit(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.keyboard, this);
        initViews();
    }

    private void initViews() {
        mPassword = $(R.id.password_field);
        password_hint = $(R.id.password_hint);
        img_showpassword = $(R.id.img_showpassword);
        txt_forgotpass = $(R.id.txt_forgotpass);
        img_finger = $(R.id.img_finger);
        $(R.id.t9_key_0).setOnClickListener(this);
        $(R.id.t9_key_1).setOnClickListener(this);
        $(R.id.t9_key_2).setOnClickListener(this);
        $(R.id.t9_key_3).setOnClickListener(this);
        $(R.id.t9_key_4).setOnClickListener(this);
        $(R.id.t9_key_5).setOnClickListener(this);
        $(R.id.t9_key_6).setOnClickListener(this);
        $(R.id.t9_key_7).setOnClickListener(this);
        $(R.id.t9_key_8).setOnClickListener(this);
        $(R.id.t9_key_9).setOnClickListener(this);
        $(R.id.img_showpassword).setOnClickListener(this);
        $(R.id.txt_forgotpass).setOnClickListener(this);
        $(R.id.img_backspace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable editable = (Editable) mPassword.getText();
                int charCount = editable.length();
                if (charCount > 0) {
                    editable.delete(charCount - 1, charCount);
                } else {
                    password_hint.setVisibility(VISIBLE);
                }
            }
        });


    }

    public void clearPassword(){
        if(mPassword.length()>0){
            mPassword.setText("");
            password_hint.setVisibility(VISIBLE);
        }
    }

    public void setClickListener(final OnClickListener clickListener) {
        this.clickListener = clickListener;
    }


//    public void onCompletePIN(final CompleteListener changedListener){
//        this.completeListener = changedListener;
//    }


    public interface OnClickListener {
        void onFingerClick();
        void onForgotClick();

    }
//
//    public interface CompleteListener{
//        void CompletePIN();
//    }


    @Override
    public void onClick(View v) {
        if (v.getTag() != null && "number_button".equals(v.getTag())) {
            mPassword.append(((TextView) v).getText());
            return;
        }
    }

    public String getInputText() {
        return mPassword.getText().toString();
    }


    public void KeyboardBuilder(String forgotText, boolean showForgot, boolean showFinger, int maxLenght) {
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLenght);
        mPassword.setFilters(fArray);


        for (int i = 0; i < maxLenght; i++) {

        }



        txt_forgotpass.setText(forgotText);
        if(showForgot){
            txt_forgotpass.setVisibility(VISIBLE);
        }else{
            txt_forgotpass.setVisibility(GONE);
        }

        if(showFinger){
            img_finger.setImageDrawable(getResources().getDrawable(R.drawable.ic_fingerprint_black_24dp));
            img_finger.setOnClickListener(this);
            img_finger.setEnabled(true);
        }else{
            img_finger.setImageDrawable(null);
            img_finger.setOnClickListener(null);
            img_finger.setEnabled(false);
        }

        BuilderKeyboard();

    }
    //
    //    public void KeyboardBuilder(String forgotText,boolean showForgot){
    ////        InputFilter[] fArray = new InputFilter[1];
    ////        fArray[0] = new InputFilter.LengthFilter(maxLenght);
    ////        mPassword.setFilters(fArray);
    //
    //        txt_forgotpass.setText(forgotText);
    //        if(showForgot){
    //            txt_forgotpass.setVisibility(VISIBLE);
    //        }else{
    //            txt_forgotpass.setVisibility(GONE);
    //        }
    //
    //        BuilderKeyboard();
    //
    //    }

//    public void KeyboardBuilder(String forgotText,boolean showForgot){
////        InputFilter[] fArray = new InputFilter[1];
////        fArray[0] = new InputFilter.LengthFilter(255);
////        mPassword.setFilters(fArray);
//
//        txt_forgotpass.setText(forgotText);
//        if(showForgot){
//            txt_forgotpass.setVisibility(VISIBLE);
//        }else{
//            txt_forgotpass.setVisibility(GONE);
//        }
//        BuilderKeyboard();
//    }


    //    public void KeyboardBuilder(boolean showForgot){
    ////        InputFilter[] fArray = new InputFilter[1];
    ////        fArray[0] = new InputFilter.LengthFilter(maxLenght);
    ////        mPassword.setFilters(fArray);
    //
    //        txt_forgotpass.setText("Lupa kata sandi?");
    //        if(showForgot){
    //            txt_forgotpass.setVisibility(VISIBLE);
    //        }else{
    //            txt_forgotpass.setVisibility(GONE);
    //        }
    //
    //        BuilderKeyboard();
    //
    //    }


    //    public void KeyboardBuilder(int maxLenght){
    ////        InputFilter[] fArray = new InputFilter[1];
    ////        fArray[0] = new InputFilter.LengthFilter(maxLenght);
    ////        mPassword.setFilters(fArray);
    //
    //        txt_forgotpass.setText("Lupa kata sandi?");
    //        txt_forgotpass.setVisibility(VISIBLE);
    //        BuilderKeyboard();
    //
    //    }

    public void KeyboardBuilder(){
//        InputFilter[] fArray = new InputFilter[1];
//        fArray[0] = new InputFilter.LengthFilter(255);
//        mPassword.setFilters(fArray);
        txt_forgotpass.setText("Lupa kata sandi?");
        txt_forgotpass.setVisibility(VISIBLE);

        BuilderKeyboard();

    }


    private void BuilderKeyboard(){

        img_finger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    clickListener.onFingerClick();
                } catch (Exception e) {
                    Log.d("KeyboardCashit", "onClick: " + e.getMessage());
                }
            }
        });


        txt_forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    clickListener.onForgotClick();
                }catch (Exception e){
                    Log.d("KeyboardCashit", "onClick: "+e.getMessage());
                }
            }
        });

        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(mPassword.length() > 0){
                    password_hint.setVisibility(GONE);
                    //                    mPassword.setBackground(getResources().getDrawable(R.drawable.ck_edittext_style_selected));
                }else{
                    password_hint.setVisibility(VISIBLE);
                    //                    mPassword.setBackground(getResources().getDrawable(R.drawable.ck_edittext_style_default));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        img_showpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPassword.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {
                    img_showpassword.setImageDrawable(getResources().getDrawable(R.drawable.ic_visibility_off_black_24dp));
                    mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    img_showpassword.setImageDrawable(getResources().getDrawable(R.drawable.ic_visibility_black_24dp));
                    mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }




    protected <T extends View> T $(@IdRes int id) {
        return (T) super.findViewById(id);
    }


}
