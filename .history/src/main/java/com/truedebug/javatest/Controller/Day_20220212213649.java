package com.truedebug.javatest.Controller;

public class Day {
    Domingo,
    Lunes,
    Martes,
    Miércoles,
    Jueves,
    Viernes,
    Sábado;

    public Object valueOf(int dayOfWeek) {
        switch(dayOfWeek){
            case 1:
            return Day.Domingo;
            case 2:
            return Day.Lunes;
            case 3:
            return Day.Miércoles;
            case 4:
            return Day.Jueves;
            case 5:
            return Day.Jueves;
            case 6:
            return Day.Viernes;
            case 7:
            return Day.Sábado;
        }
        return dayOfWeek;
    }
}
