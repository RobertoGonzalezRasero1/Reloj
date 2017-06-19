/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj_despertador;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Arasa
 */
public class Reloj {

    public static LocalTime hora;
    public static LocalTime alarma;

    /**
     * 
     * menu options
     */
    public static void main() {
    hora = LocalTime.of(0, 0);
        alarma = LocalTime.of(13, 04);
        Boolean quedarse = true;
        Timer timer = new Timer();
        TimerTask task;
        task = new TimerTask() {
            @Override
            public void run() {
                if (alarma.getHour() == (LocalTime.now().getHour() + hora.getHour())
                        && alarma.getMinute() == (LocalTime.now().getMinute() + hora.getMinute())
                        && Botonera.alarmActive == true
                        && Altavoz.ringON == true) {
                    Altavoz.playSound();
                } else {
                    Display.showHr();
                }
            }
        };
        timer.schedule(task, 10, 10000);
        do {//configure hour , configure alarm ,alarm on, off and stop alarm

            int option = Integer.parseInt(JOptionPane.showInputDialog("\n 1: Configurar Hr \n 2: Configurar alarma \n 3 : Alarma on \n 4: Alarma off\n 5: Stop Alarma"));
            switch (option) {
                case 1:
                    Botonera.configHr();

                    break;
                case 2:
                    Botonera.configAlarm();
                    
                    break;
                case 3:
                    Botonera.alarmON();
                   
                    break;
                case 4:
                     Botonera.alarmOFF();
                   
                    break;
                case 5:
                     Botonera.stopAlarm();
                    quedarse = false;
                    break;

            }
        } while (quedarse);
   
        timer.cancel();
    }
}
