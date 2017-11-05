package com.example.shubhraj.widgetapp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Shubhraj on 27-10-2017.
 */

public class WidgetProvider extends AppWidgetProvider
{
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int length = appWidgetIds.length;
        for(int i=0;i<length;i++)
        {
            int appWidgetId = appWidgetIds[i];
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.widget_layout);
            remoteViews.setTextViewText(R.id.text_view, getRandomName());

            Intent intent = new Intent(context, WidgetProvider.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            remoteViews.setOnClickPendingIntent(R.id.random_button, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        }
    }

    private String getRandomName() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Shubhraj");
        names.add("Ashu");
        names.add("Yash");
        names.add("Nuni");
        names.add("Harsh");
        names.add("Priya");
        names.add("Deblal");
        names.add("Sheblal");
        Random random = new Random();
        return names.get(random.nextInt(names.size()));
    }
}
