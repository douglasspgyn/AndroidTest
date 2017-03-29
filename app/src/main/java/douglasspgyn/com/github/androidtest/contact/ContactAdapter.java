package douglasspgyn.com.github.androidtest.contact;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import douglasspgyn.com.github.androidtest.R;
import douglasspgyn.com.github.androidtest.contact.contactform.ContactFormActivity;

/**
 * Created by Douglas on 29/03/17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private Context context;
    private List<Contact> contactList;

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);

        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        return contactList != null ? contactList.size() : 0;
    }

    public Contact getItem(int position) {
        return contactList.get(position);
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.contact_name)
        TextView name;
        @Bind(R.id.contact_phone)
        TextView phone;

        public ContactViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.contact_row)
        public void clickRow() {
            context.startActivity(new Intent(context, ContactFormActivity.class).putExtra("contact", getItem(getAdapterPosition())));
        }

        @OnClick(R.id.contact_delete)
        public void clickDelete() {
            ContactMock.removeContact(getItem(getAdapterPosition()));
            notifyItemRemoved(getAdapterPosition());
        }
    }
}
