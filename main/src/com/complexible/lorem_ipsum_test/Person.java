package com.complexible.lorem_ipsum_test;

import com.google.common.base.Objects;

public final class Person {
    private String mName;
    private String address;
    private String phoneNumber;
    private Car car;

    public Person() {
    }

    public Person(final String theName) {
        this.mName = theName;
    }

    public Person(final String theName, Car car) {
        this.mName = theName;
        this.car = car;
    }

    public Person(final String theName, final String address) {
        this.mName = theName;
        this.address = address;
    }

    public Person(final String theName, final String address, Car car) {
        this.mName = theName;
        this.address = address;
        this.car = car;
    }

    public Person(final String theName, final String address, final String phoneNumber) {
        this.mName = theName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Person(final String theName, final String address, final String phoneNumber, Car car) {
        this.mName = theName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.car = car;
    }

    public String getName() {
        return mName;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Car getCar() {
        return car;
    }

    public void setName(final String theName) {
        mName = theName;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mName);
    }

    @Override
    public boolean equals(final Object theObj) {
        if (theObj == this) {
            return true;
        }
        else if (theObj instanceof Person) {
            return Objects.equal(mName, ((Person) theObj).mName);
        }
        else {
            return false;
        }
    }
}