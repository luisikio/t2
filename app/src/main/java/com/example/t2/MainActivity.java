package com.example.t2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactsAdapter.OnNoteListener{

    public RecyclerView rv;
    public Button btnllamar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv= findViewById(R.id.rvContacts);
        btnllamar=findViewById(R.id.buttonLLamar);
        List<Contacts> contacts= getContacts();

        ContactsAdapter adapter=new ContactsAdapter(contacts,this);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setHasFixedSize(true);
        //configurar
        rv.setAdapter(adapter);

//        btnllamar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel "+getContacts()));
//                startActivity(intent);
//            }
//        });

    }
    private List<Contacts> getContacts(){
        List<Contacts> contacts =new ArrayList<>();
        contacts.add(new Contacts(1,"luis carranza","123456"));
        contacts.add(new Contacts(1,"Hope Hogsden","238-592-1900"));
        contacts.add(new Contacts(3,"Rafa Poel","573-970-5667"));
        contacts.add(new Contacts(2,"Morgan Louis","879-584-2020"));
        contacts.add(new Contacts(5,"Maurise Shillaker","418-730-7357"));
        contacts.add(new Contacts(4,"Freeland McAviy","121-408-4798"));
        contacts.add(new Contacts(7,"Juliet Adamson","325-592-9598"));
        contacts.add(new Contacts(6,"Blondy Pfaffel","196-159-6664"));
        contacts.add(new Contacts(9,"Merola Clemens","433-177-6103"));
        contacts.add(new Contacts(8,"Jessalin Bonifazio","159-427-2997"));
        contacts.add(new Contacts(10,"Gilli Meconi","510-532-8954"));
        contacts.add(new Contacts(11,"Robenia Kynder","453-557-4379"));
        contacts.add(new Contacts(12,"Herbert Fraczkiewicz","793-618-5260"));
        contacts.add(new Contacts(13,"Ardra Presho","491-165-2797"));
        contacts.add(new Contacts(14,"Vinnie Ghilardi","513-565-4422"));
        contacts.add(new Contacts(15,"Ferdinanda Waleworke","323-811-1158"));
        return  contacts;
    }
    public void onNoteClick(int position) {
        Toast.makeText(this,"sss",Toast.LENGTH_SHORT).show();
    }
//    public void onBtnLLamar(View view){
//        Intent intent =new Intent(Intent.ACTION_CALL);
//        intent.setData(Uri.parse("123"));
//        startActivity(intent);
//    }
}