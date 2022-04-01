package sv.edu.udb.dsm.investigaciondsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import sv.edu.udb.dsm.investigaciondsm.model.BubbleWrap;

public class MainActivity extends AppCompatActivity {

    private BubbleWrap bubbleWrap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bubbleWrap = BubbleWrap.getInstance();

        setupAddMoreButton();
        setupPopActivityButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    private void setupAddMoreButton(){
        Button btn = findViewById(R.id.btnAgregar);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bubbleWrap.addMoreBubble();
                updateUI();
            }
        });
    }

        private void setupPopActivityButton() {
            Button btn = findViewById(R.id.btnEmpearPopping);
            btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(MainActivity.this, PopActivity.class);
                    startActivity(intent);
                    }
            });
        }

    private void updateUI() {
        TextView tv = findViewById(R.id.lblBubbleWrap);
        String mag = String.format(
                Locale.getDefault(),
                "%d Burbujas totales",
                bubbleWrap.getNumBubbles());
        tv.setText(mag);
    }
}