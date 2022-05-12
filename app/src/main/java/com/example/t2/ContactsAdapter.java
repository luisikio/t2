package com.example.t2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    List<Contacts> contacts;
    private OnNoteListener monNoteListener;
    Context context;

    public ContactsAdapter(List<Contacts> contacts, OnNoteListener monNoteListener) {
        this.contacts = contacts;
        this.monNoteListener = monNoteListener;

    }

    @NonNull
    @Override
    public ContactsAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        ContactsAdapter.ContactViewHolder vh= new ContactsAdapter.ContactViewHolder(view,monNoteListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contacts contact=contacts.get(position);//enviamos los contactos por position
        TextView itemContName= holder.itemView.findViewById(R.id.itemName);
        TextView itemContNumber=holder.itemView.findViewById(R.id.itemNumber);

        itemContName.setText(contact.name);
        itemContNumber.setText(contact.number);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        OnNoteListener onNoteListener;

        public ContactViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            this.onNoteListener=onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }
    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
