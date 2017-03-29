package douglasspgyn.com.github.androidtest.unitconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import douglasspgyn.com.github.androidtest.R;

public class UnitConverterActivity extends AppCompatActivity {

    @Bind(R.id.temperature_to_convert)
    EditText temperatureToConvert;
    @Bind(R.id.temperature_converted)
    TextView temperatureConverted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);

        ButterKnife.bind(this);

        setToolbar();
    }

    private void setToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.unit_converter));
    }

    @OnClick(R.id.convert_to_c)
    public void clickConvertToC() {
        if (isValidTemperature(temperatureToConvert)) {
            float temperature = convertToC(Float.parseFloat(temperatureToConvert.getText().toString()));
            temperatureConverted.setText(getString(R.string.temperature_c, String.format("%.2f", temperature)));
        } else {
            temperatureConverted.setText("");
        }
    }

    @OnClick(R.id.convert_to_f)
    public void clickConvertToF() {
        if (isValidTemperature(temperatureToConvert)) {
            float temperature = convertToF(Float.parseFloat(temperatureToConvert.getText().toString()));
            temperatureConverted.setText(getString(R.string.temperature_f, String.format("%.2f", temperature)));
        } else {
            temperatureConverted.setText("");
        }
    }

    private boolean isValidTemperature(EditText temperature) {
        return temperature != null && !temperature.getText().toString().isEmpty();
    }

    public float convertToC(float temp) {
        return (temp - 32) * 5 / 9;
    }

    public float convertToF(float temp) {
        return (temp * 9 / 5) + 32;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
