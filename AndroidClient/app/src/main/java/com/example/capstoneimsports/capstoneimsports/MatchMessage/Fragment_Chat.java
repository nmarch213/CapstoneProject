package com.example.capstoneimsports.capstoneimsports.MatchMessage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.capstoneimsports.capstoneimsports.R;
import com.example.capstoneimsports.capstoneimsports.activities.Match_Activity;
import com.example.capstoneimsports.capstoneimsports.models.Match_model;
import com.example.capstoneimsports.capstoneimsports.models.User_model;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class Fragment_Chat extends Fragment {
    private static final String TAG = "ChatFragment";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static Match_model match;
    private static Match_Activity match_Activity;
    private static Socket socket;

    private EditText mInputMessageView;
    private RecyclerView mMessagesView;
    private OnFragmentInteractionListener mListener;
    private List<Message> mMessages = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;

    private Emitter.Listener handleIncomingMessages = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    String message;
                    String username;
                    String timestamp;
                    int match_id;
                    try {
                        message = data.getString("text");
                        username = data.getString("username");
                        addMessage(message, username);

                    } catch (JSONException e) {
                        // return;
                    }
                }
            });
        }
    };

    private Emitter.Listener chat_history = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {

            JSONArray data = (JSONArray) args[0];
                    String message;
            String username;
            String timestamp;
            JSONObject newmessage;
            int match_id;
            int i = 0;
                    try {
                        if (data == null) return;
                        for (i = 0; data.get(i) != null; i++) {
                            newmessage = data.getJSONObject(i);
                            message = newmessage.getString("content");
                            username = newmessage.getString("username");
                            addMessage(message, username);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

        }
    };

    public Fragment_Chat() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatFragment.
     */
    public static Fragment_Chat newInstance(String param1, String param2) {
        Fragment_Chat fragment = new Fragment_Chat();
        Bundle args = new Bundle();
        Boolean canISend = false;
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mAdapter = new MessageAdapter(mMessages);
        try {
            String url = "http://104.197.124.0:8081";
            socket = IO.socket(url);
            socket.connect();

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        socket.on("chat", chat_history);
        socket.on("newmessage", handleIncomingMessages);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_chat, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


        List<Message> chat_history;

//        Emitter.Listener get_chat_history = new Emitter.Listener(){
//
//            @Override
//            public void call(Object... args) {
//                JSONObject chat = (JSONObject) args[0];
//
//            }
//        };
        mAdapter = new MessageAdapter(mMessages);
        /*try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/

    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        socket.emit("get_chat_history", match.getMatch_id());

        mMessagesView = (RecyclerView) view.findViewById(R.id.messages);
        mMessagesView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMessagesView.setAdapter(mAdapter);

        final LinearLayout msg_frame = (LinearLayout) view.findViewById(R.id.message_input_frame);

        ImageButton sendButton = (ImageButton) view.findViewById(R.id.send_button);
        mInputMessageView = (EditText) view.findViewById(R.id.message_input);

//

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
                msg_frame.setVisibility(View.INVISIBLE);

            }
        });

        final FloatingActionButton FAB = (FloatingActionButton) view.findViewById(R.id.start_message);

        FAB.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                msg_frame.setVisibility(View.VISIBLE);
                mInputMessageView.performClick();
                mInputMessageView.requestFocus();

                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(mInputMessageView, InputMethodManager.SHOW_IMPLICIT);
            }
        });

    }

    private void sendMessage() {
        String message = mInputMessageView.getText().toString().trim();
        String username = User_model.getUsername();
        mInputMessageView.setText("");
        addMessage(message, username);
        JSONObject sendText = new JSONObject();
        try {
            sendText.put("match_id", match.getMatch_id());
            sendText.put("text", message);
            sendText.put("username", User_model.getUsername());
            socket.emit("message", sendText);
        } catch (JSONException e) {
            Log.e(TAG, "Error sending message.", e);
        }

    }


    private void addMessage(String message, String username) {

        mMessages.add(new Message.Builder(Message.TYPE_MESSAGE).message(message).username(username).build());

        mAdapter = new MessageAdapter(mMessages);
        mAdapter.notifyItemInserted(0);
        scrollToBottom();
    }

    private void scrollToBottom() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mMessagesView.scrollToPosition(mAdapter.getItemCount() - 1);
            }
        });
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        socket.disconnect();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        socket.disconnect();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }

}