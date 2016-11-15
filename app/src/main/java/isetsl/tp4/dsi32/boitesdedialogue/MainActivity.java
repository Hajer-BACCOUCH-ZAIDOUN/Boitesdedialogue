package isetsl.tp4.dsi32.boitesdedialogue;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
    }

    public void popup(String msg){
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }


    public void btn1Click(View view){
        AlertDialog.Builder alertdialog= new AlertDialog.Builder(MainActivity.this);
        alertdialog.setTitle("Boite de dialogue 1");
        alertdialog.setIcon(R.drawable.question);
        alertdialog.setMessage("C'est une boite de dialogue avec un seul bouton.");

        alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                popup("Vous avez cliqué sur le bouton OK.");
            }
        });

        alertdialog.show();
    }

    public void btn2Click(View view){
        AlertDialog.Builder alertdialog= new AlertDialog.Builder(MainActivity.this);
        alertdialog.setTitle("Boite de dialogue 2");
        alertdialog.setIcon(R.drawable.question);
        alertdialog.setMessage("C'est une boite de dialogue avec deux boutons. Cliquer sur OUI ou NON.");

        alertdialog.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                popup("Vous avez cliqué sur le bouton OUI.");
            }
        });

        alertdialog.setNegativeButton("NON", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                popup("Vous avez cliqué sur le bouton NON.");
            }
        });

        alertdialog.show();
    }

    public void btn3Click(View view){
        AlertDialog.Builder alertdialog= new AlertDialog.Builder(MainActivity.this);
        alertdialog.setTitle("Boite de dialogue 3");
        alertdialog.setIcon(R.drawable.question);
        alertdialog.setCancelable(true);
        alertdialog.setMessage("C'est une boite de dialogue avec trois boutons. Cliquer sur l'un des boutons.\nVous voulez se déplacer à Droite, en Haut, à Gauche.");

        alertdialog.setPositiveButton("RIGHT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                popup("Vous avez cliqué sur le bouton RIGHT. Vous voulez se déplacer à Droite.");
            }
        });

        alertdialog.setNegativeButton("TOP", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                popup("Vous avez cliqué sur le bouton TOP. Vous voulez se déplacer en Haut.");
            }
        });

        alertdialog.setNeutralButton("LEFT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                popup("Vous avez cliqué sur le bouton LEFT. Vous voulez se déplacer à Gauche.");
            }
        });
        alertdialog.show();
    }

    public void btn4Click(View view){
        //Initialiser un array de couleurs
        final String[] couleurs = new String[]{
                "RED","GREEN","YELLOW","WHITE","BLACK"
        };

        AlertDialog.Builder alertdialog= new AlertDialog.Builder(MainActivity.this);
        alertdialog.setTitle("Sélectionner une couleur.");
        alertdialog.setIcon(R.drawable.question);

        //0 pour cocher le premier radiobutton
        alertdialog.setSingleChoiceItems(couleurs, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String msg = "Vous avez sélectionner l'élément numéro " + String.valueOf(which) + ".";
                msg += "\nVous avez sélectionner la couleur :  " + Arrays.asList(couleurs).get(which);
                popup(msg);
            }
        });


        alertdialog.setPositiveButton("VALIDER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String msg = "Vous avez cliqué sur le bouton VALIDER.";
                popup(msg);
            }
        });


        alertdialog.setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String msg = "Vous avez cliqué sur le bouton ANNULER.";
                popup(msg);
            }
        });

        alertdialog.show();
    }

    public void btn5Click(View view){

        //Initialiser un array de couleurs
        final String[] couleurs = new String[]{
                "RED","GREEN","YELLOW","WHITE","BLACK"
        };

        //ArrayList pour stocker les positions des éléments selectionnés
        final ArrayList<Integer> selectedItems = new ArrayList<Integer>();

        //Array pour stocker les états des checkbox initialement à false
        final boolean[] preCheckedItems = new boolean[]{
                false,false,false,false,false
        };


        AlertDialog.Builder alertdialog= new AlertDialog.Builder(MainActivity.this);
        alertdialog.setTitle("Sélectionner des couleurs. C'est une boite de dialogue avec une liste avec multiples choix possible. Cliquer sur VALIDER ou ANNULER.");
        alertdialog.setIcon(R.drawable.question);

        alertdialog.setMultiChoiceItems(couleurs, preCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked)
                {
                    //si l'élément est coché, on l'ajoute à la liste
                    selectedItems.add(which);
                }
                else if(selectedItems.contains(which))
                {
                    //si l'élément est décoché, on le supprime de la liste des éléments sélectionnés
                    selectedItems.remove(which);
                }
            }
        });

        alertdialog.setPositiveButton("VALIDER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectedColor="";
                //parcourir les éléments sélectionnés
                for(int i=0;i<selectedItems.size();i++) {
                    //récuperer position
                    int index = selectedItems.get(i);

                    //récupérer le nom de l'élément couleur sélectionné
                    selectedColor += Arrays.asList(couleurs).get(index) + " ";
                }

                String msg = "Vous avez sélectionner la couleur  <" + selectedColor + ">. Vous avez cliqué sur le bouton VALIDER.";
                popup(msg);
            }
        });


        alertdialog.setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String msg = "Vous avez cliqué sur le bouton ANNULER.";
                popup(msg);
            }
        });

        alertdialog.show();
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
