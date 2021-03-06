package com.example.xpark.Module;

/**
 * Author : Dilara Karakas.
 */

import com.example.xpark.DataBaseProvider.FirebaseDBConstants;
import com.google.firebase.database.DataSnapshot;

import java.io.Serializable;

public class User implements Serializable {

    public static final String NOT_PARKED = "NOT_PARKED";

    /** User's Email */
    private final String eMail;
    /** User's Password */
    private String password;
    /** User's Phone  */
    private String phone;
    /** User's Credit Balance */
    private double credit_balance;
    /* uid for auth */
    private String uid;
    /* parked carpark id */
    private String carParkId;



    /**
     * Builds a user object
     */
    public User(){
        this.password = null;
        this.phone = null;
        this.eMail = null;
        this.credit_balance = 0.0;
        this.carParkId = NOT_PARKED;
    }

    public User(DataSnapshot shot)
    {
        this.eMail = (String)shot.child(FirebaseDBConstants.DB_USER_CHILD_EMAIL).getValue();
        this.password = (String)shot.child(FirebaseDBConstants.DB_USER_CHILD_PASSWORD).getValue();
        this.phone = (String)shot.child(FirebaseDBConstants.DB_USER_CHILD_PHONE).getValue();
        this.uid = (String)shot.child(FirebaseDBConstants.DB_USER_CHILD_UID).getValue();
        this.credit_balance = ((Long)(shot.child(FirebaseDBConstants.DB_USER_CHILD_CREDITBALANCE).getValue())).doubleValue();
        this.carParkId = (String)shot.child(FirebaseDBConstants.DB_USER_CHILD_CARPARKID).getValue();
    }

    /**
     * Builds a user object with given information.
     * @param password_ User's password
     * @param phone_ User's phone
     * @param eMail_ User's email
     * @param credit_balance_ User's credit balance
     */
    public User(String password_, String phone_, String eMail_, double credit_balance_){
        this.password = password_;
        this.phone = phone_;
        this.eMail = eMail_;
        this.credit_balance = credit_balance_;
    }

    /**
     * Builds a user object with given information.
     * @param mail User's mail.
     * @param password User's password.
     */
    public User(String mail, String password){
        this.password = password;
        this.eMail = mail;
        this.phone = null;
        this.credit_balance = 0.0;
    }

    /**
     * Setter password
     * @param password given User's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setter phone
     * @param phone given User's phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Setter credit balance
     * @param credit_balance given User's credit balance
     */
    public void setCreditbalance(double credit_balance) {
        this.credit_balance = credit_balance;
    }

    /**
     * Sets the UID for user.
     * @param uid UID to be setted.
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Sets the parked carpark id for user.
     * @param id id to be setted.
     */
    public void setCarparkid(String id){
        this.carParkId = id;
    }

    /**
     * Clears the value of parked carpark id.
     */
    public void removeCarparkid()
    {
        this.carParkId = NOT_PARKED;
    }

    /**
     * Gets the UID of user.
     * @return UID of user.
     */
    public String getUid() {
        return uid;
    }
    /**
     * Getter password
     * @return string is user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter email
     * @return string is user's email
     */
    public String getEmail() {
        return eMail;
    }
    /**
     * Getter phone
     * @return string is user's phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Getter credit_balance
     * @return double is user's credit balance
     */
    public double getCreditbalance() {
        return credit_balance;
    }

    /**
     * Gets the parked carpark id.
     * @return carpark id.
     */
    public String getCarparkid() {return carParkId;}

    /**
     * Overridden toString method to show user's data information
     * @return string user's data information
     */
    @Override
    public String toString() {
        return "User{password="+this.password
                +",email="+this.eMail
                +",phone="+this.phone
                +",uid="+this.uid
                +",credit="+this.credit_balance+
                "}";
    }
}
