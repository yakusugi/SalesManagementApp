package com.example.salesmanagementapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

class TaskDbConnect extends AsyncTask<Void, Void, String> {
    Activity activity = null;

    public TaskDbConnect(Activity act){
        activity = act;
    }

    @Override
    protected String doInBackground(Void... params) {
        String text1="";

        try{
            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn= DriverManager.getConnection("jdbc:mysql://192.168.0.32/sales_db","and_user","android0216");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf8/sales_db","and_user","android0216");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from sales_data");

            while(rs.next()){
                int id=rs.getInt(1);
                Date date=rs.getDate(2);
                int clientCd=rs.getInt(3);
                int productCd=rs.getInt(4);
                int amount=rs.getInt(5);
                text1+=id+" "+date+" "+clientCd+" "+productCd+" "+amount+" "+"\r\n";
            }

        }catch(Exception e){
            text1=e.getMessage();
        }

        return text1;
    }

    protected void onPostExecute(String result){
        TextView tv = (TextView)activity.findViewById(R.id.textview1);
        tv.setText(result);
    }
}
