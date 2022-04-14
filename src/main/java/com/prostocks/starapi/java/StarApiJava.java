/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.prostocks.starapi.java;
import com.noren.javaapi.NorenApiJava;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author itsku
 */
public class StarApiJava {

    public static void main(String[] args) {
        System.out.println("Hello and Welcome to StarApi-Java!");
        NorenApiJava api = new NorenApiJava("https://starapiuat.prostocks.com/NorenWClientTP/");
        
        String response = api.login("USER", "PWD", "SECOND_FACTOR", "VENDOR_CODE", "APISECRET", "java-");
        System.out.println(response);
            
        JSONObject search_reply = api.search("NSE", "TCS"); 
        System.out.println(search_reply.toString());
        
        JSONObject reply = api.place_order("B","I", "NSE", "CANBK-EQ", 1, 0, "L", 220.0, "java", null, null, null, null, null, null); 
        System.out.println(reply.toString());
        
        JSONArray book; 
        book = api.get_order_book();
        System.out.println(book.toString());
        
        book = api.get_trade_book(); 
        if(book != null)
            System.out.println(book.toString());
        
        
    }
}
