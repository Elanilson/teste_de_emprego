package br.com.apkdoandroid.testedeemprego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.apkdoandroid.testedeemprego.adapter.GaleriaAdapter
import br.com.apkdoandroid.testedeemprego.api.RetrofitHelper
import br.com.apkdoandroid.testedeemprego.data.Foto
import br.com.apkdoandroid.testedeemprego.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val jsonplaceholderAPI by lazy { RetrofitHelper.recuperarServico() }
    private val adapter = GaleriaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = GridLayoutManager (
            this,
            3,
            RecyclerView.VERTICAL,
            false
        )
        binding.recyclerView.adapter = adapter
        recuperarFotos()

    }
    fun recuperarFotos(){

        CoroutineScope(Dispatchers.IO).launch {
            var resposta : Response<List<Foto>>? = null

            try {
                resposta = jsonplaceholderAPI.recuperarFotos()
            }catch (e : Exception){
                e.printStackTrace()
            }

            if(resposta != null && resposta.isSuccessful){
                val fotos = resposta.body()
                if(fotos != null){
                    withContext(Dispatchers.Main){
                        adapter.attackFotos(fotos)

                    }
                }
            }else{
                Log.d("Teste_API","Resposta veio null")
            }
        }
    }
}