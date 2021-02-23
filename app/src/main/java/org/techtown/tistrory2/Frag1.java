package org.techtown.tistrory2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.viewpager_fragment, container, false);
            textView = viewGroup.findViewById(R.id.textView2); //뷰페이저 안에 텍스트 뷰

        Bottom_Fragment_1 bottom_fragment_1 = new Bottom_Fragment_1(); //바텀 프래그먼트 객체 생성
        bottom_fragment_1.dialog_btn.setOnClickListener(new View.OnClickListener() { //클릭 리스너를 만든다.
            @Override
            public void onClick(View v) {
                CustomDialog dialog = new CustomDialog(getContext()); //커스텀 다이얼로그 객체를 생성 후
                dialog.setDialogListener(new CustomDialog.CustomDialogListener() { //인터페이스를 호출한다.
                    @Override
                    public void onPositiveClicked(String data) { //이곳에서 String데이터를 받아온다.
                        textView.setText(data); //다이얼로그에서 입력한 값 넣기
                        Log.d("값", data);
                    }
                });
            }
        });

        return  viewGroup;
    }
}
