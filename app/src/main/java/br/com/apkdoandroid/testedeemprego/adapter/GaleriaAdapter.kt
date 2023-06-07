package br.com.apkdoandroid.testedeemprego.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.apkdoandroid.testedeemprego.R
import br.com.apkdoandroid.testedeemprego.data.Foto
import br.com.apkdoandroid.testedeemprego.databinding.LayoutItemBinding
import br.com.apkdoandroid.testedeemprego.viewHolder.GaleriaViewHolder

class GaleriaAdapter : RecyclerView.Adapter<GaleriaViewHolder>() {

    private var fotos : List<Foto> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaleriaViewHolder {

      //var view = LayoutInflater.from(parent.context).inflate(LayoutItemBinding,parent,false)

        var layoutInflater = LayoutInflater.from(parent.context)
        var view  = LayoutItemBinding.inflate(layoutInflater,parent,false)

        return GaleriaViewHolder(view)
    }

    override fun getItemCount(): Int {
       return fotos.count()
    }

    override fun onBindViewHolder(holder: GaleriaViewHolder, position: Int) {
        holder.bind(fotos.get(position))
    }

    fun attackFotos(fotos : List<Foto> ){
        this.fotos = fotos
        notifyDataSetChanged()

    }
}