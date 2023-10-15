package ma.ensa.tp4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ma.ensa.tp4.adapter.StarAdapter;
import ma.ensa.tp4.beans.Star;
import ma.ensa.tp4.service.StarService;

public class ListActivity extends AppCompatActivity {
    private List<Star> stars;
    private RecyclerView recyclerView;
    private StarAdapter starAdapter = null;
    private StarService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        stars = new ArrayList<>();
        service = StarService.getInstance();
        init();
        recyclerView = findViewById(R.id.recycle_view);
        //insérer le code
        starAdapter = new StarAdapter(this, service.findAll());
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void init(){
        service.create(new Star("kate bosworth", "https://source.unsplash.com/500x500/?man", 3.5f));
        service.create(new Star("george clooney", "https://source.unsplash.com/500x500/?man", 3));
        service.create(new Star("michelle rodriguez",
                "https://source.unsplash.com/500x500/?man", 5));
        service.create(new Star("george clooney", "https://source.unsplash.com/500x500/?man", 1));
        service.create(new Star("louise bouroin", "https://source.unsplash.com/500x500/?man", 5));
        service.create(new Star("louise bouroin", "https://source.unsplash.com/500x500/?man", 1));
    }
}
