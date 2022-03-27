package course2.homework3;

public class ContactsApp {
    public static void main(String[] args) {
        Contacs.add("Иванов", "+79653567956");
        Contacs.add("Тихонов", "+79219539874");
        Contacs.add("Нефедов", "+79988531682");
        Contacs.add("Костиков", "+79207429635");
        Contacs.add("Иванов", "+79219832723");
        Contacs.add("Ливанов", "+79187498821");
        Contacs.add("Асташин", "+79160253816");
        Contacs.add("Володин", "+79172304012");
        Contacs.add("Чуркин", "+79889090562");
        Contacs.add("Капустин", "+79129087650");
        System.out.println(Contacs.get("Иванов"));
    }
}
