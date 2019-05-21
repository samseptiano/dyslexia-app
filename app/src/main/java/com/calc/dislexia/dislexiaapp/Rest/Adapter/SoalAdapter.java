package com.calc.dislexia.dislexiaapp.Rest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.calc.dislexia.dislexiaapp.Model.Soal;
import com.calc.dislexia.dislexiaapp.Model.kumpulanJawaban;
import com.calc.dislexia.dislexiaapp.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ester on 4/15/18.
 */

public class SoalAdapter extends RecyclerView.Adapter<SoalAdapter.MyViewHolder>{
    String hasiljawabs="";
    ArrayList<String> hasiljawab = new ArrayList<String>();
    List<Soal> mSoalList;
    //String[] aa;
    int i = 0;
    public RadioButton radioButton;
    Context context;
    kumpulanJawaban kj = new kumpulanJawaban();



    public SoalAdapter(Context context, List<Soal> SoalList) {
        this.context = context;
        mSoalList = SoalList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.soal, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (final MyViewHolder holder, final int position){
        holder.mTextViewId.setText("Id = " + mSoalList.get(position).getId());
        holder.mTextViewSoal.setText("Soal = " + mSoalList.get(position).getSoal());

        holder.mRadioGroup.setClickable(mSoalList.get(position).isSelected());

        holder.mRadioGroup.setTag(mSoalList.get(position));

        holder.mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
                // This puts the value (true/false) into the variable
                boolean isChecked = checkedRadioButton.isChecked();


                // If the radiobutton that has changed in check state is now checked...
                if (isChecked)
                {
                    //if(checkedRadioButton.getText().toString() == "Ya"){
                        mSoalList.get(position).setSelected(checkedRadioButton.isChecked());
                        mSoalList.get(position).setJawaban(checkedRadioButton.getText().toString());
                    //}
                    //Soal dataSoal = (Soal) checkedRadioButton.getTag();
                    //dataSoal.setSelected(checkedRadioButton.isChecked());
                    //if(checkedRadioButton.getText().toString() == "Tidak") {
                       // mSoalList.get(position).setSelected(checkedRadioButton.isChecked());
                    //}

                }


            }

        });


    }

    public List<Soal> getSoalist() {
        return mSoalList;
    }

    @Override
    public int getItemCount () {
        return mSoalList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewSoal;
        public RadioGroup mRadioGroup;


        public MyViewHolder(final View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.IdSoal);
            mTextViewSoal = (TextView) itemView.findViewById(R.id.Soal);
            mRadioGroup = (RadioGroup) itemView.findViewById(R.id.radiogroup1);

        }
    }
}
