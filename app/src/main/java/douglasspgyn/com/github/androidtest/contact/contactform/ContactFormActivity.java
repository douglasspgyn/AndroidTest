package douglasspgyn.com.github.androidtest.contact.contactform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import douglasspgyn.com.github.androidtest.R;
import douglasspgyn.com.github.androidtest.contact.Contact;
import douglasspgyn.com.github.androidtest.contact.ContactMock;

public class ContactFormActivity extends AppCompatActivity {

    @Bind(R.id.create_contact_name)
    EditText name;
    @Bind(R.id.create_contact_phone)
    EditText phone;
    @Bind(R.id.save_contact)
    Button save;

    private Bundle bundle;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);

        ButterKnife.bind(this);

        bundle = getIntent().getExtras();

        setToolbar();

        if (bundle != null) {
            populate();
        }
    }

    private void setToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(bundle == null ? getString(R.string.create_contact) : getString(R.string.edit_contact));
    }

    private void populate(){
        contact = (Contact) bundle.getSerializable("contact");
        name.setText(contact.getName());
        phone.setText(contact.getPhone());
        save.setText(getString(R.string.update));
    }

    @OnClick(R.id.save_contact)
    public void clickSaveContact() {
        if (isValid(name) && isValid(phone)) {
            if (bundle == null) {
                ContactMock.addContact(new Contact(ContactMock.getContacts().size(), name.getText().toString(), phone.getText().toString()));
            } else {
                contact.setName(name.getText().toString());
                contact.setPhone(phone.getText().toString());
                ContactMock.updateContact(contact);
            }
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
