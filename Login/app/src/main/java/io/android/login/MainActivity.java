package io.android.login;import android.support.annotation.NonNull;import android.support.v7.app.AlertDialog;import android.support.v7.app.AppCompatActivity;import android.os.Bundle;import android.util.Log;import android.view.View;import android.widget.Button;import android.widget.EditText;import com.google.android.gms.tasks.OnCompleteListener;import com.google.android.gms.tasks.Task;import com.google.firebase.auth.AuthResult;import com.google.firebase.auth.FirebaseAuth;public class MainActivity extends AppCompatActivity {    private FirebaseAuth user;    private EditText e1;    private EditText e2;    private Button btn;    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        user = FirebaseAuth.getInstance();        e1 = (EditText) findViewById(R.id.e1);        e2 = (EditText) findViewById(R.id.e2);        btn = (Button) findViewById(R.id.btn);        btn.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View view) {                String emial = e1.getText().toString();                String pass = e2.getText().toString();                //cadastro                user.createUserWithEmailAndPassword(emial, pass)                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {                            @Override                            public void onComplete(@NonNull Task<AuthResult> task) {                                if(task.isSuccessful()){                                    Log.i("FI", "sucesso");                                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);                                    adb.setTitle("CADASTRO");                                    adb.setMessage("Sucesso");                                    adb.setNeutralButton("OK", null);                                    adb.show();                                }else{                                    Log.i("FI", "ERRO ...");                                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);                                    adb.setTitle("CADASTRO");                                    adb.setMessage("ERRO");                                    adb.setNeutralButton("OK", null);                                    adb.show();                                }                            }                        });            }        });    }}