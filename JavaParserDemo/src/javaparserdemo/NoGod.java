/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaparserdemo;

/**
 *
 * @author Thomas
 */
public class NoGod {
    private int Age;
    private int Voiture;
    private int Rail;
    private int Poutrelle;
    private int Lanterne;
    
    public int buildSolidCar()
    {
        return Voiture + Rail + Poutrelle;
    }
    
    public int buildSolidLantern()
    {
        return Lanterne + Poutrelle;
    }
    
    public int getAge()
    {
        return Age;
    }
}
