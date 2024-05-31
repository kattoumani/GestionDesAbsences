package com.example.gestiondesabsences.IHM;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondesabsences.METIER.Judoka;
import com.example.gestiondesabsences.R;

import java.text.ParseException;
import java.util.List;

public class JudokaAdapter extends RecyclerView.Adapter<JudokaAdapter.ViewHolder>  {
    private List<Judoka> judokas;
    private Context context;
    private OnItemClickListener leClic;



    public JudokaAdapter(Context context, List<Judoka> judokas, OnItemClickListener leClic){
        this.context = context;
        this.judokas = judokas;
        this.leClic = leClic;
    }

    /**
     * Créer une nouvelle instance de ViewHolder pour les éléments de la liste
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.liste_judokas, parent, false);

        return new ViewHolder(view);
    }

    /**
     * Lier les données de la liste à la vue correspondante dans le ViewHolder
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Judoka judoka = judokas.get(position);
        holder.nom.setText(judoka.getNom());
        holder.prenom.setText(judoka.getPrenom());
        holder.numeroTelephone.setText(judoka.getNumeroTelephone());
        holder.dateNaissance.setText(judoka.getDateNaissance());
        //holder.categorie.setText(judoka.getCategorie().getLibelle());
    }


    /**
     * Le nombre d'éléments dans la liste de catégories depuis la base de données
     *
     * @return      Le nombre d'éléments dans la liste
     */
    @Override
    public int getItemCount() {
        return judokas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nom;
        TextView prenom;
        TextView numeroTelephone;
        TextView dateNaissance;
        TextView categorie;

        public ViewHolder(View itemView){
            super(itemView);
            nom = itemView.findViewById(R.id.judoka_nom);
            prenom = itemView.findViewById(R.id.judoka_pre);
            numeroTelephone = itemView.findViewById(R.id.judoka_num);
            dateNaissance = itemView.findViewById(R.id.judoka_dat);
            //categorie = itemView.findViewById(R.id.judoka_cat);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(leClic != null){
                        leClic.onItemClick(getAdapterPosition());
                    }
                }
            });


        }
    }
}
