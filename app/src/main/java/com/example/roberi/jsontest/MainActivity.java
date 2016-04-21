package com.example.roberi.jsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtText = (TextView) findViewById(R.id.txtText);
        String strJson="{" +
                "\"Employee\" :[" +
                "{" +
                "\"id\":\"01\"," +
                "\"name\":\"Gopal Varma\"," +
                "\"salary\":\"500000\"" +
                "}," +
                "{" +
                "\"id\":\"02\"," +
                "\"name\":\"Sairamkrishna\"," +
                "\"salary\":\"500000\"" +
                "}," +
                "{" +
                "\"id\":\"03\"," +
                "\"name\":\"Sathish kallakuri\"," +
                "\"salary\":\"600000\"" +
                "}" +
                "]" +
                "}";
        String data = "";

        try {
            JSONObject  jsonRootObject = new JSONObject(strJson);
//            Toast abc = Toast.makeText(this, jsonRootObject.toString() , Toast.LENGTH_LONG);
//            abc.show();

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");
            JSONArray jsonArrey = jsonRootObject.optJSONArray("Employee");
            Toast abc = Toast.makeText(this, String.valueOf(jsonArray.length()) , Toast.LENGTH_LONG);
            abc.show();

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                float salary = Float.parseFloat(jsonObject.optString("salary").toString());

                data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
            }
            txtText.setText(data);

        } catch (JSONException e) {e.printStackTrace();}

    }
}
