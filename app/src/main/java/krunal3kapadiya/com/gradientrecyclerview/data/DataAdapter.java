package krunal3kapadiya.com.gradientrecyclerview.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import krunal3kapadiya.com.gradientrecyclerview.R;

/**
 * Created by sanjay on 8/25/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<String> mDataList;
    private int[] mColors;

    public DataAdapter(Context context, ArrayList<String> dataList) {
        mContext = context;
        mDataList = dataList;

        mColors = getGradientColors(ContextCompat.getColor(context, R.color.startColor), ContextCompat.getColor(context, R.color.endColor), mDataList.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataList.get(position));

        LayerDrawable bgDrawable = (LayerDrawable) holder.mLayout.getBackground();
        GradientDrawable shape = (GradientDrawable) bgDrawable.findDrawableByLayerId(R.id.background_shape);
        shape.setColor(mColors[position]);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mLayout;
        TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mLayout = itemView.findViewById(R.id.row_id_layout);
            mTextView = itemView.findViewById(R.id.row_data_text);
        }
    }

    public int[] getGradientColors(int startColor, int endColor, int size) {
        int colors[] = new int[size];

        int startR = Color.red(startColor);
        int startG = Color.green(startColor);
        int startB = Color.blue(startColor);

        int endR = Color.red(endColor);
        int endG = Color.green(endColor);
        int endB = Color.blue(endColor);

        ValueInterpolator interpolatorR = new ValueInterpolator(0, size - 1, endR, startR);
        ValueInterpolator interpolatorG = new ValueInterpolator(0, size - 1, endG, startG);
        ValueInterpolator interpolatorB = new ValueInterpolator(0, size - 1, endB, startB);

        for (int i = 0; i < size; ++i) {
            colors[i] = Color.argb(255, (int) interpolatorR.map(i), (int) interpolatorG.map(i), (int) interpolatorB.map(i));
        }
        return colors;
    }
}
