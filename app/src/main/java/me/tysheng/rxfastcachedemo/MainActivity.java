package me.tysheng.rxfastcachedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.tysheng.rxfastcache.RxFastCache;


public class MainActivity extends Activity implements View.OnClickListener {
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
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean aBoolean) throws Exception {
                        Toast.makeText(getApplicationContext(),
                                aBoolean?"success":"error",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });
    }

    private void getCache() {
        RxFastCache.get(TAG, Person.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Person>() {
                    @Override
                    public void accept(@NonNull Person person) throws Exception {
                        if (person != null)
                        {
                            Toast.makeText(getApplicationContext(), person.toString(), Toast.LENGTH_SHORT)
                                    .show();
                        }
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
