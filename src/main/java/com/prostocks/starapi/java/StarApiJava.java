/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.prostocks.starapi.java;
import com.noren.javaapi.NorenApiJava;
import org.json.JSONArray;
import org.json.JSONObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.ZoneOffset;

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
        
        JSONObject reply = api.place_order("B","I", "NSE", "CANBK-EQ", 1, 0, "LMT", 220.0, "java", null, null, null, null, null, null); 
        System.out.println(reply.toString());
        
        JSONArray book; 
        book = api.get_order_book();
        System.out.println(book.toString());
        
        book = api.get_trade_book(); 
        if(book != null)
            System.out.println(book.toString());
        
         JSONArray ret1;
        String ret = api.login("FA30417", "Daiwik@7", "062869", "FA30417_U", "afb8bd097e59100b74dae729eb4386de", "java-");
        if (ret != null) {
            
            LocalDateTime lastBusDay = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
            if (lastBusDay.getDayOfWeek().getValue() == 6) {
                lastBusDay = lastBusDay.minusDays(1);
            } else if (lastBusDay.getDayOfWeek().getValue() == 7) {
                lastBusDay = lastBusDay.minusDays(2);
            }
        System.out.println(lastBusDay.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
            long starttime = System.currentTimeMillis();
            System.out.println("The start time is :" + starttime);
             lastBusDay = lastBusDay.minusDays(2);
     
           ret1  = api.get_time_price_series("NSE", "10794", Long.toString(lastBusDay.toEpochSecond(ZoneOffset.UTC)), "1674000000", null);
           System.out.println("The time difference is :" + (System.currentTimeMillis()-starttime) );
            if(ret1 != null)
           System.out.println(ret1.toString());

            }    
    }
}
