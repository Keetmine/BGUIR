/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spp_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author stud309
 */
public class PhoneService {
     private ArrayList<PhoneNumber> abonents;

    PhoneService(){

    }

    public void setup(){
        this.setDefaultNumbers();

        System.out.print("\n1. Добавить абонента \n2. Вывести всех абонентов \n3. Пополнить баланс абонента \nНомер: ");

        Scanner selectScan = new Scanner(System.in);
        int selectPoint = selectScan.nextInt();

        while(true)
        {
            
            switch (selectPoint){
                case 1: this.addAbonent(); break;
                case 3: this.addMoney(); break;
                case 2: this.echoFullList(); break;
            }
            
            System.out.print("\n1. Добавить абонента \n2. Вывести всех абонентов \n3. Пополнить баланс абонента \nНомер: ");

            selectPoint = selectScan.nextInt();
        }
    }

    private void addMoney(){
        this.echoList();
        System.out.print("Выберети номер абонента для пополнения баланса");

        Scanner selectScan = new Scanner(System.in);
        int selectPoint = selectScan.nextInt();
        
        PhoneNumber abonent = this.abonents.get(selectPoint);
        
        System.out.print("Введите сумму пополнения");
        
        abonent.setBalance(abonent.getBalance() + selectScan.nextInt());
        
        
    }
    
    private void addAbonent()
    {
        PhoneNumber newAbonent = new PhoneNumber();
        
        Scanner selectScan = new Scanner(System.in);
//        int selectPoint = selectScan.nextInt();
        
        System.out.print("Введиите ФИО: ");
        
        String fio = selectScan.next();
        newAbonent.setFio(fio);
        
        System.out.print("\nВведиите Тариф: ");
        
        String tarif = selectScan.next();
        newAbonent.setTarif(tarif);
        
        System.out.print("\nВведиите паспорт: ");
        
        String passport = selectScan.next();
        newAbonent.setPassport(passport);
        
        System.out.print("\nВведиите номер: ");
        
        String nomer = selectScan.next();
        newAbonent.setNumber(nomer);
        
        this.abonents.add(newAbonent);
    }
    
    private void echoAbonent(int num){
        if (this.abonents.size() > num) {
            PhoneNumber abonent = this.abonents.get(num);
            System.out.print(String.format(" \n----\n Имя: %s \n Тариф: %s \n Номер: %s \n Паспорт: %s \n Баланс: %s", abonent.getFio(), abonent.getTarif(), abonent.getNumber().toString(), abonent.getPassport(), abonent.getStringBalance()));
        } else {
            System.out.print("Нет абонента с таким индексом");
        }
    }

    private void echoList(){
        for (PhoneNumber item: this.abonents) {
            System.out.println(this.abonents.indexOf(item) + ". " + item.getFio());
        }
    }

    private void echoFullList(){
        for (PhoneNumber item: this.abonents) {
            echoAbonent(this.abonents.indexOf(item));
        }
    }
    
    private void setDefaultNumbers()
    {
        PhoneNumber abon1 = new PhoneNumber();
        abon1.setNumber("+375(29)525-16-33");
        abon1.setBalance(-20);
        abon1.setFio("Иванов Кирилл Евгеньевич");
        abon1.setPassport("КВ89034566");
        abon1.setTarif("Комфорт лайт");

        PhoneNumber abon2 = new PhoneNumber();
        abon2.setNumber("+375(29)394-53-72");
        abon2.setBalance(1);
        abon2.setFio("Ефимова Яна Андрияновна ");
        abon2.setPassport("КВ8453394563");
        abon2.setTarif("Удобный");

        PhoneNumber abon3 = new PhoneNumber();
        abon3.setNumber("+375(29)798-23-70");
        abon3.setBalance(54);
        abon3.setFio("Добронравов Никон Яковович");
        abon3.setPassport("КВ8904563");
        abon3.setTarif("Семейный");

        PhoneNumber abon4 = new PhoneNumber();
        abon4.setNumber("+375(29)806-07-30");
        abon4.setBalance(23);
        abon4.setFio("Другакова Мирослава Яновна");
        abon4.setPassport("КВ8903394566");
        abon4.setTarif("4G Макси");

        PhoneNumber abon5 = new PhoneNumber();
        abon5.setNumber("+375(29)440-73-68");
        abon5.setBalance(44);
        abon5.setFio("Чигиркин Казимир Федотович");
        abon5.setPassport("КВ8903345663");
        abon5.setTarif("Комфорт+");

        PhoneNumber abon6 = new PhoneNumber();
        abon6.setNumber("+375(29)952-61-17");
        abon6.setBalance(3);
        abon6.setFio("Яшнова Зоя Тимофеевна ");
        abon6.setPassport("КВ895664А3");
        abon6.setTarif("Комфорт 2+");

        PhoneNumber abon7 = new PhoneNumber();
        abon7.setNumber("+375(29)471-31-16");
        abon7.setBalance(14);
        abon7.setFio("Булкина Анастасия Глебовна");
        abon7.setPassport("КВ894390А3");
        abon7.setTarif("Абсолют");

        this.abonents = new ArrayList<PhoneNumber>();
        this.abonents.add(abon1);
        this.abonents.add(abon2);
        this.abonents.add(abon3);
        this.abonents.add(abon4);
        this.abonents.add(abon5);
        this.abonents.add(abon6);
        this.abonents.add(abon7);
    }
}
