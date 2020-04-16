package com.example.project2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {
    Context context;
    ArrayList<QuestionModel> questionsArray;

    public TestAdapter(MainActivity mainActivity, ArrayList<QuestionModel> questionsList) {
      this.context=mainActivity;
      this.questionsArray=questionsList;
    }

    @Override
    public TestAdapter.TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.testitem, parent, false);
        return new TestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.TestViewHolder holder, int position) {
        QuestionModel currentItem = questionsArray.get(position);

        holder.question.setText( questionsArray.get( position ).getQuestion() );
        holder.rd1.setText( questionsArray.get( position ).getCorrectAnswer() );
        holder.rd2.setText( questionsArray.get( position ).getIncorrectAnswers().get( 0 ) );
        holder.rd3.setText( questionsArray.get( position ).getIncorrectAnswers().get( 1 ) );
        holder.rd4.setText( questionsArray.get( position ).getIncorrectAnswers().get( 2 ) );
    }

    @Override
    public int getItemCount() {
        return questionsArray.size();
    }

    public void setArrayList(ArrayList<QuestionModel>questionsArray){
        this.questionsArray=questionsArray;
        notifyDataSetChanged();
    }

    public class TestViewHolder extends RecyclerView.ViewHolder{
        TextView question;
        RadioButton rd1,rd2,rd3,rd4;
        public TestViewHolder(@NonNull View itemView) {
            super( itemView );

            question=itemView.findViewById( R.id.tvQuest );
            rd1=itemView.findViewById( R.id.rd1 );
            rd2=itemView.findViewById( R.id.rd2 );
            rd3=itemView.findViewById( R.id.rd3 );
            rd4=itemView.findViewById( R.id.rd4 );
        }
    }
}
