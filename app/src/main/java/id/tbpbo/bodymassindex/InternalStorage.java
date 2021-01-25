package id.tbpbo.bodymassindex;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class InternalStorage {
    SharedPreferences mSettings;
    SharedPreferences.Editor editor;

    public SharedPreferences openShared(Context context){
        mSettings = context.getSharedPreferences("Storage", context.MODE_PRIVATE);
        editor = mSettings.edit();
        return mSettings;
    }

    public void setString(String key,String value){
        editor.putString(key,value);
        editor.commit();
    }

    public void setBoolean(String key,Boolean value){
        editor.putBoolean(key,value);
        editor.commit();
    }

    public void setInt(String key,int value){
        editor.putInt(key,value);
        editor.commit();
    }

    public void setFloat(String key,Float value){
        editor.putFloat(key,value);
        editor.commit();
    }

    public void setLong(String key,long value){
        editor.putLong(key,value);
        editor.commit();
    }

    public String getString(String key){
        return mSettings.getString(key,null);
    }

    public Boolean getBoolean(String key){
        return mSettings.getBoolean(key,false);
    }

    public int getInt(String key){
        return mSettings.getInt(key,-1);
    }

    public Float getFloat(String key){
        return mSettings.getFloat(key,-1);
    }

    public long getLong(String key){
        return mSettings.getLong(key,-1);
    }

    public void removeStorageAll(){
        editor.clear();
        editor.commit();
    }




}
