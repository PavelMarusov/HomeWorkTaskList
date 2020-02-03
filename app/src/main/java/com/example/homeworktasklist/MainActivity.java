package com.example.homeworktasklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IEditTextFr,IRecyclerFragment {
  EditTextFragment editTextFragment = EditTextFragment.editTextFragment(this);
  RecylerFragment recylerFragment = RecylerFragment.editRecyclerFr(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragment(editTextFragment);
    }

    public void getFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }

    @Override
    public void getIfo(Task task) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("task",task);
        recylerFragment.setArguments(bundle);
        getFragment(recylerFragment);

    }

    @Override
    public void goToBack() {
    getFragment(editTextFragment);
    }
}
