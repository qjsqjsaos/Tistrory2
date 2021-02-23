package org.techtown.tistrory2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;


public class CustomDialog extends Dialog {


    //Frag1으로 이 버튼을 보내기 위해 public static을 달아주었다.
    public static Dialog dialog; //dialog 객체

    public static Context context;
    public static CustomDialogListener customDialogListener;

    public CustomDialog(Context context) {
        super(context);
        this.context = context;
        dialogStart(); //이 다이얼로그 메서드를 실행될 수 있게 보낸다.
    }


    //인터페이스 설정
    public interface CustomDialogListener{
        void onPositiveClicked(String data);
    }

    //호출할 리스너 초기화
    public void setDialogListener(CustomDialogListener customDialogListener){
        this.customDialogListener = customDialogListener;
    }


    //다이얼로그 안에 버튼에 대한 설정을 할 수 있다.

    public void dialogStart(){
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog); //setContentView는 dialog안에 넣는다.
        dialog.show(); //띄우기

        //참조하실때 무조건 앞에 dialog를 붙여주세요.
       Button check_btn = dialog.findViewById(R.id.button);
       Button cancel_btn = dialog.findViewById(R.id.button2);
        EditText editText = dialog.findViewById(R.id.editText);


        check_btn.setOnClickListener(new View.OnClickListener() { //확인 버튼
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();

                //인터페이스의 함수를 호출하여 변수에 저장된 값들을 프래그먼트로 전달
                customDialogListener.onPositiveClicked(data);
                dialog.dismiss();

            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() { //취소 버튼
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

}
