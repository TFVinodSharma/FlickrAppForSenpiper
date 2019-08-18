package flickagram.com.flickagram.modules.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import flickagram.com.flickagram.R;

import static android.net.Uri.fromFile;

public class DetailsActivity extends AppCompatActivity implements  View.OnClickListener {
    Button BtnShareImage,BtnShareLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ImageView GetImage=findViewById(R.id.getImage);
        TextView textView=findViewById(R.id.txtview);
        BtnShareImage=findViewById(R.id.btnShareImage);
        BtnShareLink=findViewById(R.id.btnShareLink);

        BtnShareImage.setOnClickListener(this);
        BtnShareLink.setOnClickListener(this);

        Bundle bundle=this.getIntent().getExtras();
        int pic=bundle.getInt("image");
        String name=bundle.getString("text");
        GetImage.setImageResource(pic);
        textView.setText(name);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.btnShareImage)
        {
            shareImage();
        }
        else if(v.getId()==R.id.btnShareLink) {
            shareTextUrl();
        }

    }

    private void shareTextUrl() {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
        share.putExtra(Intent.EXTRA_TEXT, "https://developer.android.com");

        startActivity(Intent.createChooser(share, "Share link!"));
    }
    private void shareImage() {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
        share.putExtra(Intent.EXTRA_TEXT, "Error");

        startActivity(Intent.createChooser(share, "Share link!"));
    }
}
