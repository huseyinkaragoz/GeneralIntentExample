package studyjam.example.generalintentexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,mailAdres,subject,content;
    String []adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        mailAdres=(EditText)findViewById(R.id.mail_adress);
        subject=(EditText)findViewById(R.id.subject_text);
        content=(EditText)findViewById(R.id.mail_content);

    }
    public void send(View v){
        String senderName,mailContent,mailSubject,mailText;
        adress=new String[1];
        senderName=name.getText().toString();
        mailSubject=subject.getText().toString();
        mailContent=content.getText().toString();
        mailText="Merhaba \n Benim Adım "+senderName+",\n"+mailContent+ "\n İyi Günler Dilerim";
        adress[0]=mailAdres.getText().toString();
        composeEmail(adress,mailSubject,mailText);
    }

    public void composeEmail(String[] addresses, String subject,String content) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,content);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
