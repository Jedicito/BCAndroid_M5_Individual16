package chl.ancud.m5_individual16

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import chl.ancud.m5_individual16.databinding.ItemLayoutBinding
import coil.load

class Adapter: RecyclerView.Adapter <Adapter.ViewHolder>() {

    var paises = mutableListOf<Pais>()

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
    }

    class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(pais: Pais) {
            binding.txvNombre.text = pais.nombre
            binding.imgBandera.load(pais.imgUrl)
        }
    }

    fun setData(lista: List<Pais>) {
        this.paises = lista.toMutableList()
    }
}