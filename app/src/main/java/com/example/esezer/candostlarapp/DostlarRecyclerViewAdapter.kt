package com.example.esezer.candostlarapp

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.tek_uye.view.*


//Dost tipinde bir değişken oluşturduk.
class DostlarRecyclerViewAdapter(tumDostlar: ArrayList<Dost>) :
    RecyclerView.Adapter<DostlarRecyclerViewAdapter.DostViewHolder>() {

    var dostlar = tumDostlar
    val data = mutableListOf<String>(
        "Kedi 1",
        "Kedi 2",
        "Kedi 3",
        "Kedi 4",
        "Kedi 5",
        "Kedi 6",
        "Kedi 7",
        "Köpek 1",
        "Köpek 2",
        "Köpek 3",
        "Köpek 4",
        "Köpek 5",
        "Geyik 1",
        "Geyik 2",
        "Geyik 3",
        "Geyik 4",
        " Papagan 1",
        " Papagan 2",
        " Papagan 3",
        " Papagan 4",
        " Papagan 5",
        " Papagan 6",
        " Papagan 7",
        " Papagan 8"
    )



    init {
        for (index in 0..22) {
            data.add(index.toString())
        }
    }

    //kaç eleman olacağına burada bakılıyordu.
    override fun getItemCount(): Int {
        return dostlar.size
    }

    //inflater xml kodlarının javaya dönüştürülmesi.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DostViewHolder {

        var inflater = LayoutInflater.from(parent.context)
        var tek_uye = inflater.inflate(R.layout.tek_uye, parent, false)
        return DostViewHolder(tek_uye)

    }
    override fun onBindViewHolder(holder: DostViewHolder, position: Int) {
        //o an kaçıncısatır oluşturuluyorsa onun bilgisi alındı.
        var oanOlusuturulanDost = dostlar.get(position)
        holder.setData(oanOlusuturulanDost, position)
    }


    inner class DostViewHolder(tek_uye: View) : RecyclerView.ViewHolder(tek_uye) {

        var tekDostBilgisi = tek_uye as CardView
        var dostAd = tekDostBilgisi.tvDost
        var dostResim = tekDostBilgisi.imgDostView
        //buarada ayrıştırılan elemanları onbindviewholderda kullanıyoruz.

        fun setData(oanOlusuturulanDost: Dost, position: Int) {
            dostAd.text = oanOlusuturulanDost.isim
            dostResim.setImageResource(oanOlusuturulanDost.resim)
            tekDostBilgisi.setOnClickListener {
                Toast.makeText(tekDostBilgisi.context,"Tiklandı : "+ position,Toast.LENGTH_SHORT).show()
            }
        }
        fun bind(item: String) {
            dostAd.text = item
        }
    }

    fun setFilter(aranilanlar:ArrayList<Dost>)
    {
        dostlar=ArrayList<Dost>()
        dostlar.addAll(aranilanlar)
        notifyDataSetChanged()
    }



}