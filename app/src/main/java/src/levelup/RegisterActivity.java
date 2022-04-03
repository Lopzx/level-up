package src.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth Auth;
    //VIEW
    private TextView signin_link;
    private EditText input_username;
    private EditText input_email;
    private EditText input_password;
    private EditText input_repassword;
    private Button button_submit;
    //Listener
    View.OnClickListener register;
    View.OnClickListener redirectToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_register);

        initListener();
        init();
    }

    private void initListener(){
        register = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        };
        redirectToLogin = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent redirectIntent = new Intent(getApplicationContext(), src.levelup.LoginActivity.class);
                startActivity(redirectIntent);
            }
        };
    }

    private void init(){
        // Initialize
        Auth = FirebaseAuth.getInstance();
        signin_link = findViewById(R.id.signin_link);
        input_username = findViewById(R.id.input_username);
        input_email = findViewById(R.id.input_email);
        input_password = findViewById(R.id.input_password);
        input_repassword = findViewById(R.id.input_repassword);
        button_submit = findViewById(R.id.button_submit);

        // Set Listener
        button_submit.setOnClickListener(register);
        signin_link.setOnClickListener(redirectToLogin);
    }

    private Boolean validate(){
        return true;
    }

    private void register(){
        Boolean validate_status = validate();
        String username = input_username.getText().toString();
        String email = input_email.getText().toString();
        String password = input_password.getText().toString();
        String repassword = input_repassword.getText().toString();

        if(validate_status.equals(true)){
            Auth.createUserWithEmailAndPassword(email,password);
        }
    }
}
