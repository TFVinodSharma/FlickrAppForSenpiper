package flickagram.com.flickagram.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

public class BaseActivity extends AppCompatActivity {

    //  private DatePickerDialog.OnDateSetListener mDateSetListener;
    private MaterialDialog materialDialog;


    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }


    public void showProgressDialogue(String title, String message) {
        materialDialog = new MaterialDialog.Builder(this)
                .title(title)
                .content(message)
                .progress(true, 0).show();
    }

    public void showProgressDialogue() {
        materialDialog = new MaterialDialog.Builder(this)
                .progress(true, 0).show();
    }

    public void hideProgressDialgogue() {
        materialDialog.hide();
    }


}


