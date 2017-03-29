package douglasspgyn.com.github.androidtest.contact.createcontact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import douglasspgyn.com.github.androidtest.R;
import douglasspgyn.com.github.androidtest.contact.Contact;
import douglasspgyn.com.github.androidtest.contact.ContactMock;

public class CreateContactActivity extends AppCompatActivity {

    @Bind(R.id.create_contact_name)
    EditText name;
    @Bind(R.id.create_contact_phone)
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        ButterKnife.bind(this);

        setToolbar();
    }

    private void setToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.create_contact));
    }

    @OnClick(R.id.create_contact)
    public void clickCreateContact() {
        if (isValid(name) && isValid(phone)) {
            ContactMock.addContact(new Contact(name.getText().toString(), phone.getText().toString()));
            finish();
        } else {
            if (isValid(name)) {
                name.setError(null);
            } else {
                name.setError(getString(R.string.empty_field));
            }
            if (isValid(phone)) {
                phone.setError(null);
            } else {
                phone.setError(getString(R.string.empty_field));
            }
        }
    }

    @OnClick(R.id.cancel)
    public void clickCancel() {
        finish();
    }

    private boolean isValid(EditText input) {
        return input != null && !input.getText().toString().isEmpty();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
