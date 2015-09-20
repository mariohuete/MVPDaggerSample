package com.nictalus.mvp.models;

import com.google.gson.annotations.Expose;


/**
 * @author mariobama
 * @since 26/08/15
 */
public class UserModel {

    @Expose private Integer id;
    @Expose private String name;
    @Expose private String username;
    @Expose private String email;
    @Expose private Address address;
    @Expose private String phone;
    @Expose private String website;
    @Expose private Company company;


    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return The website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website The website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return The company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company The company
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    public class Address {

        @Expose private String street;
        @Expose private String suite;
        @Expose private String city;
        @Expose private String zipcode;
        @Expose private Geo geo;


        /**
         * @return The street
         */
        public String getStreet() {
            return street;
        }

        /**
         * @param street The street
         */
        public void setStreet(String street) {
            this.street = street;
        }

        /**
         * @return The suite
         */
        public String getSuite() {
            return suite;
        }

        /**
         * @param suite The suite
         */
        public void setSuite(String suite) {
            this.suite = suite;
        }

        /**
         * @return The city
         */
        public String getCity() {
            return city;
        }

        /**
         * @param city The city
         */
        public void setCity(String city) {
            this.city = city;
        }

        /**
         * @return The zipcode
         */
        public String getZipcode() {
            return zipcode;
        }

        /**
         * @param zipcode The zipcode
         */
        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        /**
         * @return The geo
         */
        public Geo getGeo() {
            return geo;
        }

        /**
         * @param geo The geo
         */
        public void setGeo(Geo geo) {
            this.geo = geo;
        }

    }

    public class Company {

        @Expose private String name;
        @Expose private String catchPhrase;
        @Expose private String bs;


        /**
         * @return The name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return The catchPhrase
         */
        public String getCatchPhrase() {
            return catchPhrase;
        }

        /**
         * @param catchPhrase The catchPhrase
         */
        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        /**
         * @return The bs
         */
        public String getBs() {
            return bs;
        }

        /**
         * @param bs The bs
         */
        public void setBs(String bs) {
            this.bs = bs;
        }

    }

    public class Geo {

        @Expose private String lat;
        @Expose private String lng;


        /**
         * @return The lat
         */
        public String getLat() {
            return lat;
        }

        /**
         * @param lat The lat
         */
        public void setLat(String lat) {
            this.lat = lat;
        }

        /**
         * @return The lng
         */
        public String getLng() {
            return lng;
        }

        /**
         * @param lng The lng
         */
        public void setLng(String lng) {
            this.lng = lng;
        }

    }

}