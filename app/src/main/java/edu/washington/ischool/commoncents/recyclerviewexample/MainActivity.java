package edu.washington.ischool.commoncents.recyclerviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
  private RecyclerView recyclerView;
  private RecyclerView.Adapter adapter;
  private RecyclerView.LayoutManager layoutManager;

  private String[] gods = {
      "Zeus", "Poseidon", "Hades", "Athena", "Apollo", "Artemis", "Demeter",
      "Hephaestus", "Ares", "Aphrodite", "Dionysus", "Hera", "Hestia"
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    adapter = new MyAdapter(this.gods);
    recyclerView.setAdapter(adapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.action_settings) {

      return true;
    } else {
      return super.onOptionsItemSelected(item);
    }
  }
}
