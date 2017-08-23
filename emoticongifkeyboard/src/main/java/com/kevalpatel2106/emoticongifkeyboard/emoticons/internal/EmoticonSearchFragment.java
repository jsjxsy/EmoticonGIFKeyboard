package com.kevalpatel2106.emoticongifkeyboard.emoticons.internal;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevalpatel2106.emoticongifkeyboard.R;
import com.kevalpatel2106.emoticongifkeyboard.emoticons.Emoticon;
import com.kevalpatel2106.emoticongifkeyboard.emoticons.EmoticonSelectListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * @author 'https://github.com/kevalpatel2106'
 */
public final class EmoticonSearchFragment extends Fragment implements EmoticonAdapter.ItemSelectListener {

    //List of emoticons to display
    private ArrayList<Emoticon> mEmoticons;

    //Emoticon adapter
    private EmoticonAdapter mAdapter;

    //Listener to notify when emoticons selected.
    private EmoticonSelectListener mEmoticonSelectListener;


    public EmoticonSearchFragment() {
        // Required empty public constructor
    }

    public static EmoticonSearchFragment getNewInstance() {
        return new EmoticonSearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_emoticon_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEmoticons = new ArrayList<>();
        mAdapter = new EmoticonAdapter(getActivity(), mEmoticons, null, this);

        //Set the list
        RecyclerView recyclerView = view.findViewById(R.id.emoticon_search_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void OnListItemSelected(@NonNull Emoticon emoticon) {

    }

    /**
     * Set the {@link EmoticonSelectListener} to get notify whenever the emoticon is selected or deleted.
     *
     * @param emoticonSelectListener {@link EmoticonSelectListener}
     */
    public void setEmoticonSelectListener(@NonNull EmoticonSelectListener emoticonSelectListener) {
        mEmoticonSelectListener = emoticonSelectListener;
    }
}