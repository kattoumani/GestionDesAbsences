package com.example.gestiondesabsences.IHM;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondesabsences.METIER.Categorie;
import com.example.gestiondesabsences.R;

import java.text.ParseException;
import java.util.List;

public class CategorieAdapter extends RecyclerView.Adapter<CategorieAdapter.ViewHolder> {
    private List<Categorie> categories;
    private Context context;
    private OnItemClickListener leClic;

    public CategorieAdapter(Context context, List<Categorie> categories, OnItemClickListener leClic){
        this.context = context;
        this.categories = categories;
        this.leClic = leClic;
    }


    public interface OnItemClicklistener {
        void onItemClick(int postiton);
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
        // Récupérer le layout et le transformer en une vue qui compose IHM
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.liste_categories, parent, false);

        return new ViewHolder(view);
    }

    /**
     * Lier les données de la liste à la vue correspondante dans le ViewHolder
     * r
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Categorie categorie = categories.get(position);
        holder.libelle.setText(categorie.getLibelle());
    }

    /**
     * Le nombre d'éléments dans la liste de catégories depuis la base de données
     * @return      Le nombre d'éléments dans la liste
     */
    @Override
    public int getItemCount() {
        Log.v("nb", String.valueOf(categories.size()));
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView libelle;

        public ViewHolder(View itemView){
            super(itemView);
            libelle = itemView.findViewById(R.id.categorie_lib);

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
