package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView mRecyclerView;
   private TestAdapter mTestAdapter;
    private ArrayList<QuestionModel> questionsList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


       mRecyclerView = findViewById( R.id.rv );

        mTestAdapter = new TestAdapter(this, questionsList);
        mRecyclerView.setAdapter( mTestAdapter);
        mRecyclerView.setHasFixedSize( true );
        mRecyclerView.setLayoutManager( new LinearLayoutManager( this ) );

           getQuestionResponce();





    }

    private void getQuestionResponce() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "https://opentdb.com/api.php?" )
                .addConverterFactory( GsonConverterFactory.create() ).build();

        Api_Interface api_interface = retrofit.create( Api_Interface.class );

        Call<List<QuestionModel>> call = api_interface.getApi();
        call.enqueue( new Callback<List<QuestionModel>>() {
            @Override
            public void onResponse(Call<List<QuestionModel>> call, Response<List<QuestionModel>> response) {

               Toast.makeText( getApplicationContext(),"succsess",Toast.LENGTH_LONG ).show();
              // questionsList = new ArrayList<>( response.body());
            }

            @Override
            public void onFailure(Call<List<QuestionModel>> call, Throwable t) {
                Toast.makeText( getApplicationContext(), "erro", Toast.LENGTH_LONG ).show();
            }
        } );

    }
}