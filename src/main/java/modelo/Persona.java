/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Color;
import java.awt.Point;
import javax.swing.text.Position;

/**
 *
 * @author Adrian
 */
public class Persona
{
    Color color;
    Point position;

    public Persona(Color color, Point position) {
        this.color = color;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Persona{" + "color=" + color + ", position=" + position + '}';
    }
    
    
    
    
}
