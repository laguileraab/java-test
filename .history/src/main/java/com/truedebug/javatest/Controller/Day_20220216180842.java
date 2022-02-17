package com.truedebug.javatest.Controller;

public class Day {
    
    public Day(){}
    // Método para mostrar el día de la semana a través del número de la semana provisto por Calendar.DAY_OF_WEEK
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
