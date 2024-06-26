/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prostocks.starapi.java;

/**
 *
 * @author ubuntu
 */
import com.noren.javaapi.NorenCallback;
        
public class ExampleCallback implements NorenCallback{
    public void Onfeed(String msg)
    {
        System.out.println(msg);
    }
    
    
}
