package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class RecyclerView1Activity extends AppCompatActivity {
    RecyclerView1Adapter recyclerView1Adapter;
    ArrayList<String> arrayList;            //변수 생성 -> arraylist와 뷰 객체를 전달할 adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view1);

        arrayList = new ArrayList<String>();
        arrayList.add("one");
        arrayList.add("two");

        recyclerView1Adapter = new RecyclerView1Adapter(this, arrayList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);        //객체에 대한 참조 구하기
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));    // 목록의 항복들 사이 가로선 그리기
        recyclerView.setLayoutManager(new LinearLayoutManager(this));       // 목록의 배치를 세로 한 열로 한다
        recyclerView.setItemAnimator(new DefaultItemAnimator());                    //목록의 항목들이 스크롤/추가/삭제 될 때 기본적인 애니메이션이 보임
        recyclerView.setAdapter(recyclerView1Adapter);  // 뷰 객체를 지닌 택배상자(Adapter) 전달

        Button b = findViewById(R.id.btnAdd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText e = findViewById(R.id.editText);
                String s = e.getText().toString();
                e.setText("");
                arrayList.add(s);
                recyclerView1Adapter.notifyDataSetChanged();
            }
        });
    }
}