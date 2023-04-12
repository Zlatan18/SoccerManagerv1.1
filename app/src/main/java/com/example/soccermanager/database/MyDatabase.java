package com.example.soccermanager.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.soccermanager.dao.CustomerDAO;
import com.example.soccermanager.dao.HistoryBuyDAO;
import com.example.soccermanager.dao.ManagerCategoryDAO;
import com.example.soccermanager.dao.ManagerDAO;
import com.example.soccermanager.dao.NotificationDAO;
import com.example.soccermanager.dao.NotificationDetailsDAO;
import com.example.soccermanager.dao.OrderDAO;
import com.example.soccermanager.dao.OrderDetailsDAO;
import com.example.soccermanager.dao.PitchCategoryDAO;
import com.example.soccermanager.dao.PitchDAO;
import com.example.soccermanager.dao.ServiceDAO;
import com.example.soccermanager.dao.TimeDAO;
import com.example.soccermanager.dao.TimeOrderDetailsDAO;
import com.example.soccermanager.model.Customer;
import com.example.soccermanager.model.HistoryBuy;
import com.example.soccermanager.model.Manager;
import com.example.soccermanager.model.ManagerCategory;
import com.example.soccermanager.model.MyNotification;
import com.example.soccermanager.model.MyTime;
import com.example.soccermanager.model.NotificationDetails;
import com.example.soccermanager.model.Order;
import com.example.soccermanager.model.OrderDetails;
import com.example.soccermanager.model.Pitch;
import com.example.soccermanager.model.PithCategory;
import com.example.soccermanager.model.ServiceBall;
import com.example.soccermanager.model.TimeOrderDetails;


@Database(entities = {Customer.class, Manager.class, Order.class
        , OrderDetails.class, Pitch.class, PithCategory.class
        , ServiceBall.class, ManagerCategory.class, MyNotification.class
        , MyTime.class, TimeOrderDetails.class, HistoryBuy.class
        , NotificationDetails.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    private static String DB_NAME = "PITCH_MANAGER22";
    private static MyDatabase instance;

    public static synchronized MyDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),MyDatabase.class,DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract CustomerDAO customerDAO();
    public abstract ManagerDAO managerDAO();
    public abstract OrderDAO orderDAO();
    public abstract OrderDetailsDAO orderDetailsDAO();
    public abstract PitchCategoryDAO pitchCategoryDAO();
    public abstract PitchDAO pitchDao();
    public abstract ServiceDAO serviceDAO();
    public abstract ManagerCategoryDAO managerCategoryDAO();
    public abstract TimeOrderDetailsDAO timeOrderDetailsDAO();
    public abstract TimeDAO timeDAO();
    public abstract HistoryBuyDAO historyBuyDAO();
    public abstract NotificationDetailsDAO notificationDetailsDAO();
    public abstract NotificationDAO notificationDAO();
}
