package com.example.rodrigosouza.presencebarcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rodrigosouza.presencebarcode.api.ApiService;
import com.example.rodrigosouza.presencebarcode.model.Token;
import com.example.rodrigosouza.presencebarcode.model.Usuario;
import com.example.rodrigosouza.presencebarcode.utils.Constants;
import com.example.rodrigosouza.presencebarcode.utils.SecurityPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    ApiService apiService;
    SecurityPreferences securityPreferences;

    private EditText edUsername;
    private EditText edPassword;
    private Button btEntrar;
    private TextView tvEsqueciSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindView();
        initComponents();
    }

    public void initComponents(){
        apiService = new ApiService("");
        securityPreferences = new SecurityPreferences(this);
        btEntrar.setOnClickListener(this);
        tvEsqueciSenha.setOnClickListener(this);
        estaLogado();
    }

    public void bindView(){

        edUsername = findViewById(R.id.editUsernameLogin);
        edPassword = findViewById(R.id.editPasswordLogin);
        tvEsqueciSenha = findViewById(R.id.tv_forgotpassword);
        btEntrar = findViewById(R.id.btnEntrarLogin);
    }

    private void realizarLogin(Usuario usuario) {
        Call<Token> call = apiService.loginEndPoint.getToken(usuario);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.isSuccessful()){
                    logarUsuario(response.body());

                }
            }
            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Erro" + t.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void logarUsuario(Token token) {
        securityPreferences.saveString(Constants.TOKEN, token.getToken());
        initProxActivity();
    }

    private Usuario criarUsuario() {
        String password = edPassword.getText().toString();
        String username = edUsername.getText().toString();
        Toast.makeText(this, username +"-" + password, Toast.LENGTH_SHORT).show();
        return new Usuario(username, password);
    }

    private boolean estaLogado(){
        String token = securityPreferences.getSavedString(Constants.TOKEN);
        return token.equals("") ? false : true;
    }

    private void initProxActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEntrarLogin:
                realizarLogin(criarUsuario());
                break;

            case R.id.tv_forgotpassword:
//                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
//                startActivity(intent);
//                finish();
                break;
            default:
                break;
        }
    }
}
