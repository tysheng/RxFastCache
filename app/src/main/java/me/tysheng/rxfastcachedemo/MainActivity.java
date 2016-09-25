package me.tysheng.rxfastcachedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.tysheng.rxfastcache.RxFastCache;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.put).setOnClickListener(this);
        findViewById(R.id.get).setOnClickListener(this);
    }

    private void putCache() {
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("C");
        languages.add("Python");
        Person person = new Person("tysheng", 22, languages);
        RxFastCache.put(TAG, person)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        String msg;
                        if (aBoolean) {
                            msg = "success";
                        } else {
                            msg = "error";
                        }
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT)
                                .show();
                    }
                });
    }

    private void getCache() {
        RxFastCache.get(TAG, Person.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Person>() {
                    @Override
                    public void call(Person person) {
                        if (person != null)
                            Toast.makeText(getApplicationContext(), person.toString(), Toast.LENGTH_SHORT)
                                    .show();
                    }
                });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.put) {
            putCache();
        } else if (v.getId() == R.id.get) {
            getCache();
        }
    }


}
