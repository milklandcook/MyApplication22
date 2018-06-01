package com.example.smart_00.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    //동적 배열
    private ArrayList<ListVO> listVo = new ArrayList<>();

    //생성자
    public ListAdapter() {

    }

    public ListAdapter(ArrayList<ListVO> listVO) {
        this.listVo = listVO;
    }

    //추가 메서드==> 데이터값 넣어주기
    public void addVO(Drawable icon, String title, String desc){
        ListVO item = new ListVO();
        item.setImg(icon);
        item.setTitle(title);
        item.setContext(desc);
        listVo.add(item);
    }


    @Override
    public int getCount() { //데이터 전체 갯수
        return listVo.size(); //size() : 배열의 총 갯수
    }

    @Override
    public Object getItem(int position) { //위치에 해당하는 데이터 값 리턴
        return listVo.get(position); //get(위치)
    }

    @Override
    public long getItemId(int position) { //위치에 해당하는 데이터 식별자
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos =position; //위치 체크할 변수
        final Context context = parent.getContext();


        //1>convertView 가 있는지 없는지 체크null이면 새로 뷰를 만듬
        if(convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.custom_listview,
                                parent, false);
        }
        //2> 위치에 해당하는 뷰 보여주기
        ImageView image = (ImageView) convertView.findViewById(R.id.img);
        TextView title =(TextView) convertView.findViewById(R.id.title);
        TextView context1 = (TextView) convertView.findViewById(R.id.context);

        ListVO listViewitem = listVo.get(position);
        image.setImageDrawable(listViewitem.getImg());
        title.setText(listViewitem.getTitle());
        context1.setText(listViewitem.getContext());
        //getter 메서드를 이용해서 해당 xml 문서 영역에 보여주기

        //3> 보여지는 뷰의 값의 기능 부여
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, (pos + 1)+ "번째 항목입니다",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //4> 다 작성한 뷰를 리턴
        return convertView;
    }
}
