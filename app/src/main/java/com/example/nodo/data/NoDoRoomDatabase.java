package com.example.nodo.data;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.nodo.model.NoDo;


@Database(entities = {NoDo.class},version = 1)
@Dao
public abstract class NoDoRoomDatabase  extends RoomDatabase {

    private  static  volatile NoDoRoomDatabase INSTANCE;

     public  abstract  NoDoDao noDoDao();

     //Create singleton
     public static  NoDoRoomDatabase getDatabase(final Context context){
         if(INSTANCE==null)
         {
             synchronized (NoDoRoomDatabase.class)
             {
                 if(INSTANCE == null)
                 {
                     //create db
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoDoRoomDatabase.class,"nodo_Database")
                            .addCallback(roomDatabaseCallBack)
                            .build();
                 }
             };
         }
         return  INSTANCE;
     };
     private static RoomDatabase.Callback roomDatabaseCallBack =  new RoomDatabase.Callback()
     {
         @Override
         public void onOpen(@NonNull SupportSQLiteDatabase db) {
             super.onOpen(db);
             new PopulateDbAsync(INSTANCE).execute();
         }
     };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
         private final NoDoDao noDoDao;
        public PopulateDbAsync(NoDoRoomDatabase db) {
            noDoDao = db.noDoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
//            noDoDao.deleteAll();
//
//            NoDo noDo = new NoDo("Buy a new ferrari");
//            noDoDao.insert(noDo);
//
//            noDo = new NoDo("Buy big house");
//            noDoDao.insert(noDo);
            return null;
        }
    }
}
