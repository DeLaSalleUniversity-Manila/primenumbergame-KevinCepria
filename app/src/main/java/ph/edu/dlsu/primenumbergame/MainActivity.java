package ph.edu.dlsu.primenumbergame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int num;
    private int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            Button prime= (Button) findViewById(R.id.button);
            Button comp= (Button) findViewById(R.id.button2);
            final TextView x = (TextView) findViewById(R.id.textView2);
            RNG();
            prime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    whenPrimeisClicked();

                    x.setText("" + score);
                    RNG();
                }
            });

            comp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    whenCompisClicked();
                    x.setText("" + score);
                    RNG();
                }
            });


    }

    private void RNG(){
        Random rng = new Random();
        num = 2 + rng.nextInt(1000);  // Random numbers: 2 - 999
        TextView x = (TextView) findViewById(R.id.textView3);
        x.setText("" + num); // "" + int -> converts int to String
    }

    private boolean checkPrime(int value){
        Boolean temp = true;
        for (int divisor = 2; divisor < Math.sqrt(value); divisor++) {
            if (value % divisor == 0) {
                temp = false;
            }
        }
        return temp;
    }

    private void whenPrimeisClicked() {
        if (checkPrime(num) ) {
            score++;
            Toast.makeText(this, "Congratulations! You are correct!", Toast.LENGTH_SHORT).show();
        } else {
            score = score - 5;
            Toast.makeText(this, "You are wrong!", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Previous number: "+ num,Toast.LENGTH_SHORT).show();
    }

    private void whenCompisClicked() {
        if (!checkPrime(num) ) {
            score++;
            Toast.makeText(this, "Congratulations! You are correct!", Toast.LENGTH_SHORT).show();
        } else {
            score = score - 5;
            Toast.makeText(this, "You are wrong!", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Previous number: "+ num,Toast.LENGTH_SHORT).show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
