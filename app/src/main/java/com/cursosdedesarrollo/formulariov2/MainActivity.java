package com.cursosdedesarrollo.formulariov2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Button imagebutton;
    private EditText edittext;
    private CheckBox checkbox;
    private RadioButton radio_red;
    private RadioButton radio_blue;
    private ToggleButton togglebutton;
    private RatingBar ratingbar;
    private Button send;
    private Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setUpViews();
    }
    private void setUpViews() {
        // inicializamos los objetos de la vista
        imagebutton = (Button) findViewById(R.id.button);
        edittext = (EditText) findViewById(R.id.edittext);
        checkbox = (CheckBox) findViewById(R.id.checkbox);
        radio_red = (RadioButton) findViewById(R.id.radio_red);
        radio_blue = (RadioButton) findViewById(R.id.radio_blue);
        togglebutton = (ToggleButton) findViewById(R.id.togglebutton);
        ratingbar = (RatingBar) findViewById(R.id.ratingbar);
        //send = (Button) findViewById(R.id.send);
        //send.setEnabled(false);
        radio_red.setChecked(true);
        Toast.makeText(this,
                "Hasta que no marques la checkbox no podrás salvar",
                Toast.LENGTH_LONG).show();

        //volver = (Button) findViewById(R.id.volver);

        View.OnClickListener click=new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();

            }
        };
        //volver.setOnClickListener(click);
        // cambiamos los comportamientos que no son click
        edittext.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    Toast.makeText(MainActivity.this,
                            edittext.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        RatingBar.OnRatingBarChangeListener i =
                new RatingBar.OnRatingBarChangeListener() {
                    public void onRatingChanged(
                            RatingBar ratingBar, float rating,
                            boolean fromUser) {
                        Toast.makeText(
                                MainActivity.this,
                                "New Rating: " + rating,
                                Toast.LENGTH_SHORT).show();
                    }
                };
        ratingbar.setOnRatingBarChangeListener(i);

    }

    // cambio de comportamiento del boton con imagen
    public void ImageClick(View v) {
        // Perform action on clicks
        Toast t=Toast.makeText(this, "Beep Bop", Toast.LENGTH_SHORT);
        t.show();
    }

    // cambio de comportamiento del boton volver
    public void volver(View v) {
        // Perform action on clicks
        finish();
    }

    // cambio de comportamiento de la checkbox
    public void checkBoxClick(View v) {
        String text = "";
        // Perform action on clicks, depending on whether it's now checked
        // CheckBox cb=(CheckBox) v;
        if (checkbox.isChecked()) {
            text = "Selected";
            send.setEnabled(true);
            Toast.makeText(this,
                    "Ya puedes Salvar",
                    Toast.LENGTH_LONG).show();
        } else {
            send.setEnabled(false);
            Toast.makeText(this,
                    "Hasta que no marques la casilla no podrás salvar",
                    Toast.LENGTH_LONG).show();
            text = "Not selected";

        }
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    // cambio de comportamiento de los botones de radio
    public void radioClick(View v) {
        // Perform action on clicks
        RadioButton rb = (RadioButton) v;
        if (rb.getId() == R.id.radio_red) {

        }
        Toast.makeText(this, rb.getText(), Toast.LENGTH_SHORT).show();
    }

    // cambio de comportamiento del toggle
    public void toggleClick(View v) {
        //ToggleButton tb=(ToggleButton)v;
        // Perform action on clicks
        if (togglebutton.isChecked()) {
            //if (tb.isChecked()) {
            Toast.makeText(MainActivity.this, "Checked",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Not checked",
                    Toast.LENGTH_SHORT).show();
        }
    }

    // cambio de comportamiento del boton enviar
    public void sendClick(View v) {
        // Perform action on clicks
        String allText = new String("campo:"
                + edittext.getText());
        allText = allText + ":checkbox:";
        if (checkbox.isChecked()) {
            allText = allText + "Checked:";
        } else {
            allText = allText + "Not Checked:";

        }
        allText = allText + ":toggle:";
        if (togglebutton.isChecked()) {
            allText = allText + "Checked:";
        } else {
            allText = allText + "Not Checked:";

        }
        allText = allText + "radios:rojo:";
        String redtext = "";
        if (radio_red.isChecked()) {
            redtext = "pulsado:";
        } else {
            redtext = "no pulsado:";
        }
        allText = allText + redtext;
        allText = allText + "azul";
        String bluetext = "";
        if (radio_blue.isChecked()) {
            bluetext = "pulsado:";
        } else {
            bluetext = "no pulsado:";
        }
        allText = allText + bluetext;
        allText = allText + "rating:";
        float f = ratingbar.getRating();
        allText = allText + Float.toString(f) + ":";

        Log.d("app", allText);
        Toast.makeText(this, allText, Toast.LENGTH_LONG).show();
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
            sendClick(null);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
