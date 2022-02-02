package com.example.tpfmassonnicolas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListMovie extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick {

    private RecyclerView listMovie;
    private RecyclerAdapter adapter;
    private List<Movie> items;

    private static final int REQUEST_CODE = 1;

    private static final List<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);

        initViews();
        initValues();
    }

    //Method for initialize views the list movie
    private void initViews() {
        listMovie = findViewById(R.id.listMovie);
    }

    //Method for initialize values and adapter
    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        listMovie.setLayoutManager(manager);

        items = movies;
        adapter = new RecyclerAdapter(items, this);
        listMovie.setAdapter(adapter);
    }

    //Click method to go to movie detail (DetailMovie)
    @Override
    public void itemClick(Movie item) {
        Intent intent = new Intent(this, DetailMovie.class);
        intent.putExtra("DetailMovie", item);
        startActivity(intent);
    }

    //Method to go to page add movie (AddMovie)
    public void pageAddMovie(View v) {
        startActivityForResult(new Intent(getApplicationContext(), AddMovie.class), REQUEST_CODE);
    }

    //return method of what is obtained in page add movie (AddMovie)
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Verification that the REQUEST_CODE belongs to the corresponding activity, like the RESULT_OK. In case different, it will show a message
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Movie movie = (Movie) extras.getSerializable("DetailMovie");
                    String name = movie.getName();
                    String type = movie.getType();
                    int year = movie.getYear();
                    int movieRating = movie.getMovieRating();
                    String movieDescription = movie.getMovieDescription();
                    movies.add(new Movie("" + name, "" + type, year, movieRating, "" + movieDescription));
                    
                    Intent listMovie = new Intent(this, ListMovie.class);
                    finish();
                    startActivity(listMovie);

                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Unsaved Data", Toast.LENGTH_SHORT).show();
            }
        }
    }
}