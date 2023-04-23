package net.skhu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerView1Adapter extends RecyclerView.Adapter<RecyclerView1Adapter.ViewHolder> {
    static class ViewHolder extends RecyclerView.ViewHolder {   //innerclass 구현 -> Viewholder쿨래스 : 뷰를 담기위한 택배상자
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }
    }

    LayoutInflater layoutInflater;  //XML파일 내용대로 뷰 객체들을 자동으로 만드는 객체 생성
    ArrayList<String> arrayList;

    public RecyclerView1Adapter(Context context, ArrayList<String> arrayList) {
        this.layoutInflater = LayoutInflater.from(context); // LayoutInflater 객체를 구해서 layoutInflater 변수에 대입
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }               //데이터항목 수 리턴 메소드 재정의

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {       //
        View view = layoutInflater.inflate(R.layout.memo1, viewGroup, false);   // 데이터 항목 뷰 객체 생성
        return new ViewHolder(view);                                                       // Viewholder객체로 생성해서 리턴
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {    // ViewHolder객체 내부에 뷰 객체를 넣는 코드
        viewHolder.textView.setText(arrayList.get(index));
    }
}