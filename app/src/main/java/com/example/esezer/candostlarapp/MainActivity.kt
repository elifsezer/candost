package com.example.esezer.candostlarapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import android.widget.SearchView
import com.trendyol.bubblescrollbarlib.BubbleTextProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() /*SearchView.OnQueryTextListener*/ {


    var tumDostlar = ArrayList<Dost>()
    var myAdapter = DostlarRecyclerViewAdapter(tumDostlar)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerviewDost.apply {
            veriKaynaginiDoldur()
            recyclerviewDost.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerviewDost.adapter = myAdapter
        }

        fastscroll.attachToRecyclerView(recyclerviewDost)
        fastscroll.bubbleTextProvider = BubbleTextProvider { myAdapter.data[it] }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.filtre_menu, menu)
        //menu xmlindeki ikonu bulmak için
        var aramaItem = menu?.findItem(R.id.app_bar_search)
        var searchView = aramaItem?.actionView as SearchView

        //biz yazdıkca bulunması için
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

   /* //her bir karaktere basıldıgınsa aram ayapar
    override fun onQueryTextChange(newText: String?): Boolean {
        var girilenVeri=newText?.toLowerCase()
        //kullancının girdiği değer ile listemizdekini karşılaştırıp eşleşenleri tutacak array
        var arananlar=ArrayList<Dost>()
        //butun hayvanları geziyoruz.
        for (dost in tumDostlar)
        {
            var adi=dost.isim.toLowerCase()
            if (adi.contains(girilenVeri.toString()))
            {
                arananlar.add(dost)
            }
        }
        myAdapter.setFilter(arananlar)
        return true
    }*/

    fun veriKaynaginiDoldur() {
        var resimler = arrayOf(
            R.drawable.ani_cat_one,
            R.drawable.ani_cat_two,
            R.drawable.ani_cat_three,
            R.drawable.ani_cat_four,
            R.drawable.ani_cat_five,
            R.drawable.ani_cat_six,
            R.drawable.ani_cat_seven,
            R.drawable.ani_dog_one,
            R.drawable.ani_dog_two,
            R.drawable.ani_dog_three,
            R.drawable.ani_dog_four,
            R.drawable.ani_dog_five,
            R.drawable.ani_deer_one,
            R.drawable.ani_deer_two,
            R.drawable.ani_deer_three,
            R.drawable.ani_deer_four,
            R.drawable.bird_parrot_one,
            R.drawable.bird_parrot_two,
            R.drawable.bird_parrot_three,
            R.drawable.bird_parrot_four,
            R.drawable.bird_parrot_five,
            R.drawable.bird_parrot_six,
            R.drawable.bird_parrot_seven,
            R.drawable.bird_parrot_eight
        )

        var isimler = arrayOf(
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

        for (i in 0..resimler.size - 1) {
            var eklenecekDost = Dost(isimler[i], resimler[i])
            tumDostlar.add(eklenecekDost)
        }
    }
}
