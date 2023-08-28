package com.example.learningapp.view.screen.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.DrawableRes
import com.example.learningapp.R
import com.example.learningapp.view.MainActivity

private const val CHANNEL_ID = "channelId"
private lateinit var notificationManager: NotificationManager
private lateinit var notificationBuilder: Notification.Builder
private fun createNotificationChannel(context: Context) {
    notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(CHANNEL_ID, "ChannelDescription", importance)
            .also {
                it.enableLights(true)
                it.enableVibration(true)
            }
        notificationManager.createNotificationChannel(channel)
    }
}

fun setPendingIntent(context: Context): PendingIntent {
    val intent = Intent(context, MainActivity::class.java)
    return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
}

fun makeSimpleNotification(
    context: Context,
    title: String,
    content: String,
    @DrawableRes smallIcon: Int
) {
    createNotificationChannel(context)

    notificationBuilder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        Notification.Builder(context, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(smallIcon)
            .setContentIntent(setPendingIntent(context))
    } else {
        Notification.Builder(context)
            .setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(smallIcon)
            .setContentIntent(setPendingIntent(context))
    }

    notificationManager.notify(101, notificationBuilder.build())
}

fun sendInboxStyleNotifications(
    context: Context,
    title: String,
    content: String,
    @DrawableRes smallIcon: Int
) {
    createNotificationChannel(context)

    val style = Notification.InboxStyle()
    style.apply {
        addLine("User 1 : Hey")
        addLine("User 1 : Dear")
        addLine("User 1 : How are you?")
        addLine("User 1 : I need a help")
        addLine("User 1 : can you fix a bug on my code")
        addLine("User 1 : It is quite urgent")
        addLine("User 1 : I am calling you...")
    }

    notificationBuilder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        Notification.Builder(context, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(smallIcon)
            .setStyle(style)
            .setContentIntent(setPendingIntent(context))
    } else {
        Notification.Builder(context)
            .setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(smallIcon)
            .setStyle(style)
            .setContentIntent(setPendingIntent(context))
    }
    notificationManager.notify(202, notificationBuilder.build())
}


fun sendBigPictureStyleNotifications(
    context: Context,
    title: String,
    content: String,
    @DrawableRes smallIcon: Int
) {
    createNotificationChannel(context)

    val style = Notification.BigPictureStyle()
    style.bigPicture(BitmapFactory.decodeResource(context.resources, R.drawable.profile ))

    notificationBuilder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        Notification.Builder(context, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(smallIcon)
            .setStyle(style)
            .setContentIntent(setPendingIntent(context))
    } else {
        Notification.Builder(context)
            .setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(smallIcon)
            .setStyle(style)
            .setContentIntent(setPendingIntent(context))
    }
    notificationManager.notify(302, notificationBuilder.build())
}

/*makeSimpleNotification(
            context = context,
            "title of notification",
            "content of notification",
            R.drawable.ic_facebook
        )*/

/*sendInboxStyleNotifications(
    context = context,
    "title of notification",
    "content of notification",
    R.drawable.ic_facebook
)*/

/*sendBigPictureStyleNotifications(
    context = context,
    "title of notification",
    "content of notification",
    R.drawable.ic_facebook
)*/