
package com.moringaschool.live_cleanliness.networks;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostgresqlApiUse {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("user")
    @Expose
    private Integer user;

    /**
     * No args constructor for use in serialization
     *
     */
//    public PostgresqlApiUse() {
//    }

    /**
     *
     * @param name
     * @param user
     */
    public PostgresqlApiUse(String name, Integer user) {
        super();
        this.name = name;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

}