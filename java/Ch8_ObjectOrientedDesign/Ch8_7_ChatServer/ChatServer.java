package com.CrackingTheCodingInterview.Ch8_ObjectOrientedDesign.Ch8_7_ChatServer;

import java.text.SimpleDateFormat;
import java.util.*;

public class ChatServer
{
    class User
    {
        int id;
        String first_name;
        String last_name;
        String account_name;
        UserStatus status = null;

        private HashMap<Integer, PrivateChat> privateChats; // Maps from the other user ids to their PrivateChats.

        private HashMap<Integer, AddRequest> addRequests; // Maps from the other user ids to their add requests.

        private HashMap<Integer, AddRequest> sentRequests; // Maps from the other user ids to their sent requests.
    }

    List<User> user_list;

    class UserManager
    {
        // Add user
        public boolean add_user(int id, HashMap<String, Object> values_map)
        {
            User u = new User();

            // Check properties of values_map to add to the user we're creating.
            if (values_map.get("first_name") != null)
            {
                u.first_name = (String)values_map.get("first_name");
            }
            if (values_map.get("last_name") != null)
            {
                u.last_name = (String)values_map.get("last_name");
            }
            if (values_map.get("account_name") != null)
            {
                u.account_name = (String)values_map.get("account_name");
            }

            user_list.add(u);
            return true;
        }
    }

    public abstract class Message
    {
        String contents; // Message contents in XML
        int from_user;
        int to_user;
        SimpleDateFormat timestamp;
        boolean read = false;

        public Message(int from_user, int to_user, String contents)
        {
            this.from_user = from_user;
            this.to_user = to_user;
            this.contents = contents;
        }
    }

    public abstract class Conversation
    {
        protected ArrayList<User> participants;
        protected int id;
        protected ArrayList<Message> messages;

        public ArrayList<Message> getMessages()
        {
            return this.messages;
        }

        public boolean addMessage(Message m)
        {
            this.messages.add(m);
            return true;
        }
    }

    public class PrivateChat extends Conversation
    {
        User user1;
        User user2;
        public PrivateChat(User user1, User user2)
        {
            this.user1 = user1;
            this.user2 = user2;
        }
    }

    class AddRequest
    {
        protected int id;
        User from_user;
        User to_user;

        public AddRequest(User from_user, User to_user)
        {
            this.from_user = from_user;
            this.to_user = to_user;
        }
    }

    public enum UserStatus
    {
        Away, Busy, Available;
    }

    public enum RequestStatus
    {
        Read, Accepted, Unread;
    }
}
