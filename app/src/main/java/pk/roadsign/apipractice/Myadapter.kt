package pk.roadsign.apipractice

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Myadapter(var mainActivity: MainActivity,var list: ArrayList<Mydata>) : RecyclerView.Adapter<Myadapter.Myclass>() {
    class Myclass(itemview:View):RecyclerView.ViewHolder(itemview) {

        lateinit var userid:TextView
        lateinit var id:TextView
        lateinit var title:TextView
        lateinit var body:TextView

        init {
            userid=itemview.findViewById(R.id.userid)
            id=itemview.findViewById(R.id.id)
            title=itemview.findViewById(R.id.title)
            body=itemview.findViewById(R.id.body)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {

        var view=LayoutInflater.from(mainActivity).inflate(R.layout.abc,parent,false)
        return Myclass(view)
    }

    override fun getItemCount(): Int {

        return list.size

    }

    override fun onBindViewHolder(holder: Myclass, position: Int) {

        holder.userid.text=list[position].userid.toString()
        holder.id.text=list[position].id.toString()
        holder.title.text=list[position].title.toString()
        holder.body.text=list[position].body.toString()



    }

}
