package ar.edu.untref.aydoo;

/*Tipo de objeto: Objeto de valor*/
public enum Month {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    int daysOfTheMonth;
    Month(int days) {
        daysOfTheMonth = days;
    }

    public int getDaysOfTheMonth(){
        return daysOfTheMonth;
    }
}
