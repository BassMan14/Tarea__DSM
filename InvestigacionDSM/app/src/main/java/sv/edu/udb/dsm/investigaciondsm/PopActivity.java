package sv.edu.udb.dsm.investigaciondsm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import sv.edu.udb.dsm.investigaciondsm.model.BubbleWrap;

public class PopActivity extends AppCompatActivity {

    private BubbleWrap bubbleWrap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        bubbleWrap = BubbleWrap.getInstance();

        setupPopButton();
        updateUI();
    }

    private void setupPopButton(){
        Button btn = findViewById(R.id.btnPop);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bubbleWrap.popBubble();
                Toast.makeText(PopActivity.this, "POP", Toast.LENGTH_LONG).show();
                updateUI();
            }
        });
    }

    private void updateUI(){
        TextView tv = findViewById(R.id.lbBurbujaContador);
        tv.setText(String.format(Locale.US, "Burbujas: %d", bubbleWrap.getNumBubbles()));
    }
}