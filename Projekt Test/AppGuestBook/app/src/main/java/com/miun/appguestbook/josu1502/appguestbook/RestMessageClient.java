package com.miun.appguestbook.josu1502.appguestbook;

import android.os.AsyncTask;

import org.w3c.dom.Document;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joakim on 17-02-07.
 */

public class RestMessageClient {

    private URL url;
    private MessageReciver messageReciver;
    private MessageListener ml;

    public RestMessageClient(URL url){
        this.url = url;
    }

    /**
     * Send a asynchronous request for all messages.
     */
    public void requestMessages() {
        messageReciver = new MessageReciver();
        messageReciver.execute();

    }

    /**
     * Add listener that recived requested messages.
     */
    public void setMessageListener(MessageListener ml) {
        this.ml = ml;
    }

    public class MessageReciver extends AsyncTask<Void,Void,List<Message>> {

        @Override
        protected List<Message> doInBackground(Void... params) {
            List<Message> messageList = null;

            try {
                InputStream inStream = url.openStream();
                MessageBuilder builder = new MessageBuilder(inStream);
                messageList = builder.getMessages();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return messageList;
        }

        @Override
        protected void onPostExecute(List<Message> messages) {
            ml.messageRecived(messages);
        }
    }


}
