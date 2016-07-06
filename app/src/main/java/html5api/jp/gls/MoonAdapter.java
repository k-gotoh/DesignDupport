package html5api.jp.gls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kgotoh on 2016/04/24.
 */
public class MoonAdapter extends ArrayAdapter<Moon> {

    private LayoutInflater mInflater;

    public MoonAdapter(Context context, List<Moon> list) {
        super(context, 0, list);

        this.mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = this.mInflater.inflate(R.layout.luna_row, parent, false);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView .findViewById(R.id.img);
            holder.name= (TextView) convertView .findViewById(R.id.name);
            holder.reco= (TextView) convertView .findViewById(R.id.reco);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Moon moon = getItem(position);

        holder.img.setImageResource(moon.res);
        holder.name.setText(moon.name);
        holder.reco.setText(moon.reco);

        return convertView;
    }

    class ViewHolder {
        public ImageView img;
        public TextView name;
        public TextView reco;
    }
}
