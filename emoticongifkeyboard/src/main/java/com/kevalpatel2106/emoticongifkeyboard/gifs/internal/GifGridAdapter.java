package com.kevalpatel2106.emoticongifkeyboard.gifs.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kevalpatel2106.emoticongifkeyboard.R;
import com.kevalpatel2106.emoticongifkeyboard.gifs.Gif;

import java.util.List;

/**
 * Created by Keval on 18-Aug-17.
 */

final class GifGridAdapter extends ArrayAdapter<Gif> {
    private final Context mContext;
    private final ItemSelectListener mListener;
    private final List<Gif> mData;

    GifGridAdapter(@NonNull final Context context,
                   @NonNull final List<Gif> data,
                   @NonNull final ItemSelectListener listener) {
        super(context, R.layout.item_emojicon, data);
        //noinspection ConstantConditions
        if (context == null || data == null || listener == null)
            throw new IllegalArgumentException("Null parameters not allowed.");

        mContext = context;
        mData = data;
        mListener = listener;
    }

    @Override
    public Gif getItem(int position) {
        return mData.get(position);
    }

    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if (v == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_gif, parent, false);

            holder = new ViewHolder();
            holder.gifIv = v.findViewById(R.id.gif_iv);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        final Gif gif = getItem(position);
        if (gif != null) {
            Glide.with(mContext)
                    .load(gif.getPreviewGifUrl())
                    .asGif()
                    .crossFade()
                    .centerCrop()
                    .into(holder.gifIv);

            holder.gifIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.OnListItemSelected(gif);
                }
            });
        }
        return v;
    }

    interface ItemSelectListener {
        void OnListItemSelected(@NonNull Gif gif);
    }

    private class ViewHolder {
        private ImageView gifIv;
    }
}