package pk.roadsign.apipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    var list=ArrayList<Mydata>()

     lateinit var recycle:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var que=Volley.newRequestQueue(this)
        var request=StringRequest(Request.Method.GET,"https://jsonplaceholder.typicode.com/posts",
            { response ->
                var array=JSONArray(response)
                for(i in 0 until array.length())
                {
                    var map1=array.getJSONObject(i)

                    var userId=map1.getInt("userId")
                    var id=map1.getInt("id")
                    var title=map1.getString("title")
                    var body=map1.getString("body")
                    var data=Mydata(userId,id,title,body)
                    list.add(data)
                }
                Log.d("==response====", "onCreate: ${list[0]}")

                var adapter =Myadapter(this,list)
                recycle.adapter=adapter
            },
            { error ->
                Log.d("errojhmygj", "onCreate: ${error}")
            })
        que.add(request)




    }

}