package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        String lyrics;
        switch (position) {
            case 1 :
                lyrics = "Пусть бегут неуклюже \n"
                        + "Пешеходы по лужам, \n"
                        + "А вода по асфальту рекой. \n"
                        + "И не ясно прохожим \n"
                        + "В этот день непогожий \n"
                        + "Почему я весёлый такой.";
                break;
            case 2 :
                lyrics = "Спят усталые игрушки, книжки спят.\n"
                        + "Одеяла и подушки ждут ребят.\n"
                        + "Даже сказка спать ложится,\n"
                        + "Чтобы ночью нам присниться.\n"
                        + "Ты ей пожелай:\n"
                        + "Баю-бай.";
                break;
            default :
                lyrics = "Песня не найдена.";
        }
        System.out.println(lyrics);
    }

    public static void main(String[] args) {
        Jukebox lyrics = new Jukebox();
        System.out.println("Текст песни 1:");
        lyrics.music(1);
        System.out.println("\nТекст песни 2:");
        lyrics.music(2);
        System.out.println("\nТекст песни 5:");
        lyrics.music(5);
    }
}
