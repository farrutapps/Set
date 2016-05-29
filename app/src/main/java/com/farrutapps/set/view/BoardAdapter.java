package com.farrutapps.set.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import android.graphics.Color;

import com.farrutapps.set.model.Board;

import com.farrutapps.set.R;


import static com.farrutapps.set.model.Constants.*;

public class BoardAdapter extends BaseAdapter {

    private Activity context;
    private Board board;

    private LayoutInflater layoutInflater = null;

    public BoardAdapter(Activity context, Board board)
    {
        this.context = context;
        this.board = board;
        this.layoutInflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return board.getActiveCards().size();
    }

    @Override
    public Object getItem(int position) {
        return board.getActiveCards().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;
        final holderBoard holderBoard;

        if (convertView == null)
        {
            view = layoutInflater.inflate(R.layout.card, null);
            holderBoard = new holderBoard(view);
            view.setTag(holderBoard);
        } else
        {
            holderBoard = (holderBoard) view.getTag();
        }


        // TODO: SET APPEARANCE HERE

        //highlighted
        if(this.board.getActiveCards().get(position).isSelected()==true){
            //TODO: set selection animation here
        }
        else { /*TODO: make sure card is not highlighted / animation is ended*/}

        // background
        int colour;
        colour = this.board.getActiveCards().get(position).getFeature(0);

        int colourRgb = 0;
        switch (colour){
            case COLOUR_BLUE:
                colourRgb=Color.parseColor("#rrggbb");
                break;
            case COLOUR_GREEN:
                colourRgb = Color.parseColor("#rrggbb");
                break;
            case COLOUR_RED: colourRgb = Color.parseColor("#rrggbb");
                break;
        }
        holderBoard.rlCardItem.setBackgroundColor(colourRgb);


        // card selection
        holderBoard.ibCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO set selection animation here too.

                board.cardAction(board.getActiveCards().get(position));
                notifyDataSetChanged();
            }
        });

        return view;
    }

    private void startBoardActivity(int position)
    {
        Intent intent = new Intent().setClass(context, BoardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
       // intent.putExtra(Parameters.LANGUAGE_NAME.toString(), languages.get(position).getLanguageName());
        context.startActivity(intent);
    }
}

class holderBoard {

    public RelativeLayout rlCardItem;


    public ImageButton ibCard;


    public holderBoard(View base)
    {
        this.rlCardItem = (RelativeLayout) base.findViewById(R.id.rl_card);

        this.ibCard = (ImageButton) base.findViewById(R.id.ib_card);

    }
}