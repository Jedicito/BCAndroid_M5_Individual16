package chl.ancud.m5_individual16

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import chl.ancud.m5_individual16.databinding.ItemLayoutBinding
import coil.load

class Adapter: RecyclerView.Adapter <Adapter.ViewHolder>() {

    var paises = mutableListOf<Pais>()
    var callback: PaisCallback? = null

    fun setPaisCallback(c: PaisCallback) {
        this.callback = c
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemLayoutBinding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return paises.size
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val item = paises[position]
        holder.bind(item)
        holder.binding.itemCardView.setOnClickListener(View.OnClickListener {
            val texto = "Nombre: ${item.nombre}. Población: ${item.poblacion}"
            Toast.makeText(holder.itemView.context, texto, Toast.LENGTH_SHORT).show()
            callback?.showPais(texto)

        })
    }

    inner class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(pais: Pais) {
            binding.txvNombre.text = pais.nombre
            binding.imgBandera.load(pais.imgUrl)

        }
    }

    fun setData(lista: List<Pais>) {
        this.paises = lista.toMutableList()
    }

    interface PaisCallback {
        fun showPais(texto: String)
    }
}