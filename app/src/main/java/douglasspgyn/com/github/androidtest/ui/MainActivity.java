package douglasspgyn.com.github.androidtest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import douglasspgyn.com.github.androidtest.R;
import douglasspgyn.com.github.androidtest.ui.contact.ContactActivity;
import douglasspgyn.com.github.androidtest.ui.unitconverter.UnitConverterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.unit_converter)
    public void openUnitConverter() {
        startActivity(new Intent(this, UnitConverterActivity.class));
    }

    @OnClick(R.id.friend_list)
    public void openRecyclerView() {
        startActivity(new Intent(this, ContactActivity.class));
    }
}
