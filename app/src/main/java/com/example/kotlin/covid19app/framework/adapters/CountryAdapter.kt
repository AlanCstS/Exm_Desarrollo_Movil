package com.example.kotlin.covid19app.framework.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.covid19app.data.network.model.Country
import com.example.kotlin.covid19app.databinding.ItemCountryBinding
import com.example.kotlin.covid19app.framework.adapters.viewholders.CountryViewHolder

/**
 * Adaptador para el RecyclerView que muestra la lista de países.
 */
class CountryAdapter : RecyclerView.Adapter<CountryViewHolder>() {

    // Lista de datos de países
    var data: ArrayList<Country> = ArrayList()
    private lateinit var context: Context

    /**
     * Inicializa el adaptador con datos básicos y el contexto.
     *
     * @param basicData Lista de datos de países.
     * @param context Contexto de la aplicación.
     */
    @SuppressLint("NotConstructor")
    fun CountryAdapter(basicData: ArrayList<Country>, context:Context) {
        this.data = basicData
        this.context = context
    }

    /**
     * Vincula los datos de un país al ViewHolder.
     *
     * @param holder ViewHolder que contiene la vista de un elemento de país.
     * @param position Posición del elemento en la lista.
     */
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }

    /**
     * Crea un nuevo ViewHolder para la vista de un elemento de país.
     *
     * @param parent Grupo al que se añadirá la nueva vista.
     * @param viewType Tipo de vista.
     * @return Nuevo ViewHolder para la vista de un elemento de país.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    /**
     * Obtiene el número total de elementos en el conjunto de datos.
     *
     * @return Número total de elementos en el conjunto de datos.
     */
    override fun getItemCount(): Int {
        return data.size
    }
}
