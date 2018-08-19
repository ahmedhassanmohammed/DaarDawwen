package app.sunshine.com.example.android.daardawwen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView markfavorite;
    Button favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        markfavorite = findViewById(R.id.markFavorite);
        favorite = findViewById(R.id.favorites_btn);

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favorite.setEnabled(false);
                favorite.setText("\u2713");
                markfavorite.setText("Marked As Favorites Successfully");
            }
        });

    }


}
