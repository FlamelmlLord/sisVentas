/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.ArrayList;

public interface IDao <T> {
    public T search(T obj);
    public ArrayList<T> listAll();
    public boolean delete(T obj);
    public boolean update(T obj);
    public boolean create(T obj);
}