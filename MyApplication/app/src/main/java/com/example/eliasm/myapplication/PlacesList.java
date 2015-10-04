package com.example.eliasm.myapplication;
import java.io.Serializable;
import java.util.List;

import com.google.api.client.util.Key;

/** Implement this class from "Serializable"
 * So that you can pass this class Object to another using Intents
 * Otherwise you can't pass to another actitivy
 * */
/**
 * Created by EliasM on 03/10/2015.
 */
public class PlacesList implements Serializable {
    @Key
    public String status;

    @Key
    public List<Place> results;
}
