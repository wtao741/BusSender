package tuxdev.studio.maminasatabus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gc.materialdesign.widgets.SnackBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ukietux on 02/02/16.
 */
public class LoginActivity extends AppCompatActivity {
    private final String USNAME = "demo";
    private final String USPASS = "demo";
    SessionManager session;
    View parentLayout;

    @Bind(R.id.username)
    EditText ETUser;
    @Bind(R.id.password)
    EditText ETPass;
    @Bind(R.id.login)
    Button Login;

    @OnClick(R.id.login)
    void Masuk() {
        if (ETUser.getText().toString().equals(USNAME) && ETPass.getText().toString().equals(USPASS)) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            session.createLoginSession(USNAME, USPASS);
            startActivity(i);
            finish();
        } else {
            SnackBar snackbar = new SnackBar(LoginActivity.this, "Username or password is incorrect");
            snackbar.show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        parentLayout = findViewById(R.id.rootView);
        session = new SessionManager(getApplicationContext());

        ButterKnife.bind(this);
        if (session.isLoggedIn() == true) {
            Intent a = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(a);
            finish();
        }
    }
}
