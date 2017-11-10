package com.example.heltonsouza.helloactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(onClickLogin());
    }

    private View.OnClickListener onClickLogin() {
        return  new Button.OnClickListener() {
            public void onClick(View v){
                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);

                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                if("helton".equals(login) && "123".equals(senha)){
//                    alert("Bem vindo login realizado");

                    Intent intent = new Intent(getContext(), BemVindoActivity.class);
                    Bundle params = new Bundle();
                    params.putString("nome", "Helton Silvieira");
                    intent.putExtras(params);
                    startActivity(intent);

                }else{
                    alert("Login ou senha incorretos");
                }
            }
        };

    }

    private Context getContext() {
        return this;
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


}
