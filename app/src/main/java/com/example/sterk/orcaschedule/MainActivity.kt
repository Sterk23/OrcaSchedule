package com.example.sterk.orcaschedule

import android.os.Bundle
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.example.sterk.orcaschedule.model.ListMatches
import com.example.sterk.orcaschedule.model.Match
import com.example.sterk.orcaschedule.orcaapi.VolleyCallback
import com.example.sterk.volleydemo.adapter.MatchAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val url: String = "https://script.google.com/macros/s/AKfycbx8r6QbP9yJv9PXI9I87YtodXJmN1Sim2NQHI1huvLWHyPGBeAs/exec?path=/product"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMatchList(object : VolleyCallback<ArrayList<Match>> {
            override fun onSuccess(list: ArrayList<Match>) {

                val matchAdapter = MatchAdapter(list,null)
                recyclerView.apply {
                    layoutManager = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
                    isNestedScrollingEnabled = false
                    adapter = matchAdapter
                    onFlingListener = null
                }

                matchAdapter.notifyDataSetChanged()
//                progressBar.visibility = View.VISIBLE
            }
        })
    }


    private fun getMatchList( callback: VolleyCallback<ArrayList<Match>>)  {
        //initialize RequestQueue
        val mRequestQueue = Volley.newRequestQueue(this)
        //Initialize Request
        val mJsonRequest = StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->
            //            Toast.makeText(this,"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen
            val list = Gson().fromJson(response, ListMatches::class.java)
            val matches = list.matches
            callback.onSuccess(matches)
//            Toast.makeText(this,team1,Toast.LENGTH_LONG).show()
        }, Response.ErrorListener { error ->

        })
        mRequestQueue.add(mJsonRequest)

    }
}
