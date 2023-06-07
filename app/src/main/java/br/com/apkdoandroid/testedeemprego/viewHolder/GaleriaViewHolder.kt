package br.com.apkdoandroid.testedeemprego.viewHolder

import androidx.recyclerview.widget.RecyclerView
import br.com.apkdoandroid.testedeemprego.data.Foto
import br.com.apkdoandroid.testedeemprego.databinding.LayoutItemBinding
import com.squareup.picasso.Picasso

class GaleriaViewHolder(var binding : LayoutItemBinding) : RecyclerView.ViewHolder( binding.root) {

    fun bind(foto : Foto){

        Picasso.get().load(foto.url).into(binding.imageItem)

    }

}