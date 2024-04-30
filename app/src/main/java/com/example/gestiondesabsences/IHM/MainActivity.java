package com.example.gestiondesabsences.IHM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gestiondesabsences.R;

public class MainActivity extends AppCompatActivity {

    private Button btnAppel, btnRecapitulatif, btnGestion;
    Intent AppelActivity, RecapitulatifActivity, GestionActivity;

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
    }

    /**
     * Initialisation des différents composants de la page
     */
    private void constructeurGraphique(){
       btnAppel = (Button) findViewById(R.id.btnAppel);
       btnRecapitulatif = (Button) findViewById(R.id.btnRecapitulatifJudokas);
       btnGestion = (Button) findViewById(R.id.btnGestionJudokas);
    }
}