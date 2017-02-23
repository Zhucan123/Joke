package com.example.zhucan.joke.ui.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zhucan.joke.R;
import com.example.zhucan.joke.ui.ResponseCode;
import com.example.zhucan.joke.ui.utils.HttpManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText username=null;
    private EditText password=null;
    private Button longin=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_main);

        longin=(Button)findViewById(R.id.Loginbutton);
        username=(EditText)findViewById(R.id.passname) ;
        password=(EditText)findViewById(R.id.password);
        longin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                String pass=password.getText().toString();
                LoginTask task=new LoginTask(LoginActivity.this,name,pass);
                task.execute();


            }
        });


        Button bt = (Button) findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this).setTitle("用户协议")
                        .setIcon(R.mipmap.ic_launcher).setMessage("我的地盘我做主...");
                setPositiveButton(builder);
                setNegativeButton(builder).create().show();



            }
            private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder){
                return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LoginActivity.this,"已阅读本内容", Toast.LENGTH_LONG).show();
                    }
                });
            }
            private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder){
                return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LoginActivity.this,"不同意本协议", Toast.LENGTH_LONG).show();
                    }
                });
            }

        });
    }
            public void ture(View view) {
                Intent intent = new Intent(LoginActivity.this, Useragree.class);
                startActivity(intent);

            }
    public class LoginTask extends AsyncTask<String,Void,String> {

        private String callback=null;
        private String name=null;
        private String pass=null;
        private Context context=null;
        public LoginTask(Context context, String name, String pass){

            this.name=name;
            this.pass=pass;
            this.context=context;
        }
        protected String doInBackground(String...params){
            Map<String,String> map=new HashMap<>();
            map.put("username",name);
            map.put("password",pass);

            try {
                String str= HttpManager.postRequest("http:119.29.227.219:8888/api/login",map);
                Gson gs=new Gson();
                ResponseCode responseCode=gs.fromJson(str,ResponseCode.class);
                callback=responseCode.getResultCode();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return callback;

        }
        protected void onPostExecute(String string){
            if (callback!=null){
                switch (callback){
                    case "0":Toast.makeText(context,"登录成功,页面跳转中...",Toast.LENGTH_LONG).show();

                        Intent intent=new Intent();
                        intent.setClass(context.getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case "1":Toast.makeText(context,"登录失败,请输入正确的用户名和密码",Toast.LENGTH_LONG).show();

                }


            }

        }

    }
        }
