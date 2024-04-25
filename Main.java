import java.util.Date;
import java.util.Locale;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormatSymbols;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    public static void main(String[] args) {
        Person rusya = new Person();
        rusya.setName("Руська");
        rusya.setPapka("батяни");
        rusya.speak();
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_MONTH, 90);
        int dow = c.get(Calendar.DAY_OF_WEEK);
        String dayDay = rusya.getDayName(dow, new Locale("ja", "RU"));
        System.out.println("а сегодня на японском у нас - " + dayDay);

        JFrame frame = new JFrame("Моё первое окно");
        frame.setVisible(true);

        JLabel label = new JLabel(dayDay);
        frame.add(label);
    }
}


class Person {
    private String name;
    private String papka;
    private int percent;
    private String[] days = {
            "понедельник",
            "вторник",
            "среда",
            "четверг",
            "пятница",
            "суббота",
            "воскресенье"
    };

    public void setDays(String[] dayDay) {
        days = dayDay;
    }

    private String getDay(int index) {
        if (index > days.length - 1) {
            return null;
        }
        return days[index];
    }

    public void setName(String nameName) {
        name = nameName;
    }

    public String getName() {
        return name;
    }

    public void setPapka(String papkaPapka) {
        papka = papkaPapka;
    }

    public String getPapka() {
        return papka;
    }

    private int getPercent() {
        percent = 1 + (int) (Math.random() * 100);
        return percent;
    }


    public void speak() {
        for (int i = 0; i < days.length; i++) {
            System.out.println("В " + getDay(i) + " " + name + " от " + papka + " усвоил информацию на " + getPercent() + "%");
        }
    }

    public static String getDayName(int day, Locale locale) {
        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        String[] dayNames = symbols.getWeekdays();
        return dayNames[day];
    }
}