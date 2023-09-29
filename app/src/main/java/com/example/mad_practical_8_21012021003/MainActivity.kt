package com.example.mad_practical_8_21012021003

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun SetAlarm(militime:Long,action:String){
        val intentalarm = Intent(applicationContext,MyReceiver::class.java)
        intentalarm.putExtra(MyReceiver.ALARMKEY,action)
        val pendingintent = PendingIntent.getBroadcast(applicationContext,4345,intentalarm,PendingIntent.FLAG_IMMUTABLE or  PendingIntent.FLAG_UPDATE_CURRENT)
        val manager = getSystemService(ALARM_SERVICE) as AlarmManager
        if(action==MyReceiver.ALARMSTART)
        {
            manager.setExact(AlarmManager.RTC_WAKEUP,militime,pendingintent)
        }
        else if (action == MyReceiver.ALARMSTOP){
            manager.cancel(pendingintent)
            sendBroadcast(intentalarm)
        }
    }
}