package douglasspgyn.com.github.androidtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import douglasspgyn.com.github.androidtest.unitconverter.UnitConverterActivity;

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
}
