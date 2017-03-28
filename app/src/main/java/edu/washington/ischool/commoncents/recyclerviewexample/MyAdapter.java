package edu.washington.ischool.commoncents.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yulong on 3/21/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

  private String[] dataSet;
  private ColorWheel colorWheel = new ColorWheel();

  public MyAdapter(String[] dataSet) {
    this.dataSet = dataSet;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    // Create a new view
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_item, parent, false);
    return new ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
    final String text = this.dataSet[position];
    holder.layout.setBackgroundColor(colorWheel.getColor());
    holder.textView.setText(text);
    holder.button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(view.getContext(), "Getting more info on " + text + "...",
            Toast.LENGTH_SHORT).show();
      }
    });

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(view.getContext(), text + " was clicked", Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public int getItemCount() {
    return dataSet.length;
  }

  // Custom holder specific to my RecyclerView
  public static class ViewHolder extends RecyclerView.ViewHolder {

    // My item cell only has a textview and a button
    public LinearLayout layout;
    public TextView textView; // god name
    public Button button; // more info, possibly

    public ViewHolder(View itemView) {
      super(itemView);
      this.layout = (LinearLayout) itemView.findViewById(R.id.layout);
      this.textView = (TextView) itemView.findViewById(R.id.cellTextView);
      this.button = (Button) itemView.findViewById(R.id.cellButton);
    }
  }
}
