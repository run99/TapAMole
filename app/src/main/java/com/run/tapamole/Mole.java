package com.run.tapamole;

import android.widget.ImageView;

public class Mole {

    int state; //もぐらの状態　0:潜っている 1:出てきている 2:叩かれている
    ImageView moleImage;

    android.os.Handler h; //Handler スレッド間の処理を投げる役割

    Runnable hide;//Handlerで投げる処理の中身を書くためのくらす


    public Mole(ImageView imageView){
        state = 0;
        moleImage = imageView;
        moleImage.setImageResource(R.drawable.mole1);

        h = new android.os.Handler();
        hide = new Runnable() {
            @Override
            public void run() {
                state = 0;

     moleImage.setImageResource(R.drawable.mole1);
            }
        };


    }

    public  void start(){
        if(state == 0){ //もぐらが引っ込んでいる状態のとき
            state = 1;
            moleImage.setImageResource(R.drawable.mole2);

            h.postDelayed(hide, 1000);
        }
    }

    public int tapMole() {
        if(state == 1){ //モグラが出ている状態のとき
            state = 2;
            moleImage.setImageResource(R.drawable.mole3);

            h.removeCallbacks(hide);
            h.postDelayed(hide, 1000);
            return 1;
        }
        return 0;
    }

}
