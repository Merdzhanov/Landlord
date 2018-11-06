package com.landlord.android.views.MessagesList;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.landlord.android.R;
import com.landlord.android.models.ChatMessage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder> {
    private List<ChatMessage> mMessages;
    private OnMessageClickListener mOnMessageClickListener;

    @Inject
    public MessagesAdapter() {
        mMessages = new ArrayList<>();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.setOnClickListener(mOnMessageClickListener);
        holder.bind(mMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    public ChatMessage getItem(int position) {
        return mMessages.get(position);
    }

    public void clear() {
        mMessages.clear();
    }

    public void addAll(List<ChatMessage> ChatMessage) {
        mMessages.addAll(ChatMessage);
    }

    public void setOnMessageClickListener(OnMessageClickListener onMessageClickListener) {
        this.mOnMessageClickListener = onMessageClickListener;
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_message_user)
        TextView mUserTextView;

        @BindView(R.id.tv_message_text)
        TextView mMessageTextView;

        @BindView(R.id.tv_message_time)
        TextView mTimeTextView;

        private OnMessageClickListener mOnClickListener;
        private ChatMessage mMessage;

        MessageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(ChatMessage Message) {
            mUserTextView.setText(Message.getMessageUser());
            mMessageTextView.setText(Message.getMessageText());
            mTimeTextView.setText(Math.toIntExact(Message.getMessageTime()));
            mMessage = Message;
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mMessage);
        }

        public void setOnClickListener(OnMessageClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnMessageClickListener {
        void onClick(ChatMessage Message);
    }
}