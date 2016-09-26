/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jme2;

import javax.microedition.midlet.MIDlet;
import jdk.dio.DeviceManager;
import jdk.dio.gpio.GPIOPin;
import jdk.dio.gpio.GPIOPinConfig;

/**
 *
 * @author sihai
 */
public class Jme2 extends MIDlet {
    
    @Override
    public void startApp() {
        try {
            System.out.println("startApp");
            //not ok GPIOPin led=DeviceManager.open(3);
            GPIOPinConfig cfg=new GPIOPinConfig.Builder().setPinNumber(3).setDirection(GPIOPinConfig.DIR_OUTPUT_ONLY).build();
            final GPIOPin led=DeviceManager.open(cfg);
            do{
                Thread.sleep(1000);
                led.setValue(!led.getValue());
                System.out.println(" value :"+led.getValue());
            }while(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void destroyApp(boolean unconditional) {
    }
}
