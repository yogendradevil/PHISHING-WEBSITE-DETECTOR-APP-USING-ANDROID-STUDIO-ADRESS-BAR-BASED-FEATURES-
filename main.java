package gocy.com;
 import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.*;
 
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
 
public class MainActivity extends AppCompatActivity {
    EditText url;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
url = findViewById(R.id.url);
            button = findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
        String title = "STATUS";
                    String msg = url.getText()+" is SAFE";
                    String msg1 = url.getText()+" is PHISHING";
 
                    int pc = 0;
                    int x = 0;
                    String c1 = "//";
                    String c2 = "http";
 
                    for (int i = 0; i < url.length(); i++) {
                        if (url.getText().charAt(i) == '.') {
                            x++;	
                        }
                    }                                                  // For counting number of dots
 
 	if (!url.getText().toString().contains("www")) {
                        pc = pc + 1;
                    }                             // To check URL is starting with IP address or not
                    if (url.length() > 75) {
                        pc = pc + 1;
                    }                                                  // To check URL length
                    if (url.getText().toString().contains("-")) {
                        pc = pc + 1;
                    }                                           // To check URL is containing "-" or not
                    if (url.getText().toString().contains("tiny")) {
                        pc = pc + 1;
                    }                                      // To check URL is containing "tiny" or not
                    if (url.getText().toString().contains("@")) {
                        pc = pc + 1;
                    }                                         // To check URL is containing "@" or not
                    if (x >= 4) {
                        pc = pc + 1;
                    }                               // To check URL is not having more then 4 dots
                    Pattern p = Pattern.compile(c1);
                    Matcher m = p.matcher(url.getText());
                    int c=0;
                    while (m.find())
                        c++;
                    if (c>=2){
                        pc=pc+1;
                    }                                  // To check URL is not having more then 2 "//"
                    Pattern p1 = Pattern.compile(c2);
                    Matcher m1 = p1.matcher(url.getText());
                    int d=0;
                    while (m1.find())
                        d++;
                    if (d>1){
                        pc++;
                    }                         // To check URL is not having http token as domain
                    if (pc<3) {
 
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle(title)
                                .setMessage(msg)
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
 
                                        dialog.dismiss();
 
                                    }
                                }).create().show();
                    }                                           // this is used to show the result
                    if (pc>=3) {
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle(title)
                                .setMessage(msg1)
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
 
                                        dialog.dismiss();
 
                                    }
                                }).create().show();
                    }                                                  // this is used to show the result
                } });
}
}
