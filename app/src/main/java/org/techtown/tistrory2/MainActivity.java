package org.techtown.tistrory2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bottom_Fragment_1 bottom_fragment_1 = new Bottom_Fragment_1();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,bottom_fragment_1).commitAllowingStateLoss();
        //프래그먼트 트랜잭션 해주기
    }
}