package com.example.gestiondesabsences.IHM;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gestiondesabsences.R;

public class MainActivity extends AppCompatActivity {

    private Button btnAppel, btnRecapitulatif, btnGestion, btnQuitter;
    Intent AppelActivity, RecapitulatifActivity, GestionActivity;
    private RecyclerView rvLesCategories;

    /**
     * Listener pour quitter l'application
     */
    private View.OnClickListener quitter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Quitter();
        }
    };
    /**
     * Vue de l'appel élève
     */
    private View.OnClickListener appel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent AppelActivity = new Intent(MainActivity.this, AppelActivity.class);
            startActivity(AppelActivity);
        }
    };

    /**
     * Définition de l'interface pour la vue du récapitulatif des Judokas
     */
    private View.OnClickListener recapitulatif = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent RecapitulatifActivity = new Intent(MainActivity.this, RecapitulatifActivity.class);
            startActivity(RecapitulatifActivity);
        }
    };

    private View.OnClickListener gestion = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent GestionActivity = new Intent(MainActivity.this, GestionActivity.class);
            startActivity(GestionActivity);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constructeurGraphique();
        btnAppel.setOnClickListener(appel);
        btnRecapitulatif.setOnClickListener(recapitulatif);
        btnGestion.setOnClickListener(gestion);
        btnQuitter.setOnClickListener(quitter);
    }

    /**
     * Initialisation des différents composants de la page
     */
    private void constructeurGraphique(){
       btnAppel = (Button) findViewById(R.id.btnAppel);
       btnRecapitulatif = (Button) findViewById(R.id.btnRecapitulatifJudokas);
       btnGestion = (Button) findViewById(R.id.btnGestionJudokas);
       btnQuitter = (Button) findViewById(R.id.btnQuitter);
    }

    /**
     * Bouton pour quitter l'application
     */
    private void Quitter() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setMessage("Voulez vous vraiment quitter ?");
        alertDialogBuilder.setTitle("Confirmation");

        alertDialogBuilder
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("Non", null)
                .show();
    }
}