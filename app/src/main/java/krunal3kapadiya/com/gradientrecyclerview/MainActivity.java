package krunal3kapadiya.com.gradientrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import krunal3kapadiya.com.gradientrecyclerview.data.DataAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> dataList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            dataList.add(getString(R.string.index_no, String.valueOf(i)));
        }

        // view initialization and setting adapter
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        DataAdapter adapter = new DataAdapter(this, dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
