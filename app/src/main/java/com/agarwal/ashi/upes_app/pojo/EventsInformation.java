package com.agarwal.ashi.upes_app.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ashi on 15-03-2018.
 */

public class EventsInformation implements Parcelable,Comparable<EventsInformation>{
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public Object createFromParcel(Parcel parcel) {
            return new EventsInformation(parcel);
        }

        @Override
        public Object[] newArray(int i) {
            return new EventsInformation[i];
        }
    };
    String eventName;
    String image;
    String eventDescription;
    String date;
    String organiser;
    String contact;
    String school;
    String workshop;
    String seminar;
    String competition;
    String cultural;
    String sports;
    String webminar;
    String society;
    String time;
    String venue;
    String eventid;
    String loginid;

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    boolean expired;
    public EventsInformation()
    {
        //default constructor
    }
    public EventsInformation(Parcel parcel) {
        this.eventName=parcel.readString();
        this.image=parcel.readString();
        this.eventDescription=parcel.readString();
        this.date=parcel.readString();
        this.organiser=parcel.readString();
        this.contact=parcel.readString();
        this.school=parcel.readString();
        this.workshop=parcel.readString();
        this.seminar=parcel.readString();
        this.competition=parcel.readString();
        this.cultural=parcel.readString();
        this.sports=parcel.readString();
        this.webminar=parcel.readString();
        this.society=parcel.readString();
        this.loginid=parcel.readString();
        this.eventid=parcel.readString();
        this.time=parcel.readString();
        this.venue=parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(eventName);
        parcel.writeString(image);
        parcel.writeString(eventDescription);
        parcel.writeString(date);
        parcel.writeString(organiser);
        parcel.writeString(contact);
        parcel.writeString(school);
        parcel.writeString(workshop);
        parcel.writeString(seminar);
        parcel.writeString(competition);
        parcel.writeString(cultural);
        parcel.writeString(sports);
        parcel.writeString(webminar);
        parcel.writeString(society);
        parcel.writeString(eventid);
        parcel.writeString(loginid);
        parcel.writeString(time);
        parcel.writeString(venue);

    }

    //Getter and Setter Methods
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getSeminar() {
        return seminar;
    }

    public void setSeminar(String seminar) {
        this.seminar = seminar;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getCultural() {
        return cultural;
    }

    public void setCultural(String cultural) {
        this.cultural = cultural;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public String getWebminar() {
        return webminar;
    }

    public void setWebminar(String webminar) {
        this.webminar = webminar;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }



    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }



    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    @Override
    public int compareTo(@NonNull EventsInformation eInfo) {
        return getDate().compareTo(eInfo.getDate());
    }
}
