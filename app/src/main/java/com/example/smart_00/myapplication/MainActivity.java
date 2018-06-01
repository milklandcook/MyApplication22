package com.example.smart_00.myapplication;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //리스트 뷰
    ListView listview;
    //어댑터
    ListAdapter adapter;

    //배열 ==> 정적 혹은 동적
    int[] img = {R.drawable.one, R.drawable.two, R.drawable.three};
    String[] title = {"제목1", "제목2", "제목3"};
    String[] context = {"내용1", "내용2", "내용3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 어댑터를 통한 리스트 뷰");

        adapter = new ListAdapter(); //내가 만든 어댑터 ==> 수정
        listview = (ListView) findViewById(R.id.List_view);

        listview.setAdapter(adapter);
        //리스트의 모양
        listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //값 전달
        for (int i=0; i < img.length; i++){
            adapter.addVO
                    (ContextCompat.getDrawable(this, img[i]), title[i], context[i]);


}


    }

}
