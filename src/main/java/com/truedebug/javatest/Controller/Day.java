package com.truedebug.javatest.Controller;

public class Day {
    
    public Day(){}

    public String valueOf(int dayOfWeek) {
        switch(dayOfWeek){
            case 1:
            return "Domingo";
            case 2:
            return "Lunes";
            case 3:
            return "Miércoles";
            case 4:
            return "Jueves";
            case 5:
            return "Jueves";
            case 6:
            return "Viernes";
            case 7:
            return "Sábado";
        }
        return "";
    }
}
