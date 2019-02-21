package es.estech.ejemplorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUsers;
    private RecyclerView.Adapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<User> userList = UsersRepository.getInstance().getUsers();

        //setting recyclerview, with adapter -> passing to it the list with data
        rvUsers = findViewById(R.id.recyclerView);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        rvAdapter = new UserAdapter(userList, getApplicationContext());
        rvUsers.setAdapter(rvAdapter);



    }
}
