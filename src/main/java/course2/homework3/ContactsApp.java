package course2.homework3;

public class ContactsApp {
    public static void main(String[] args) {
        Contacs contacs = new Contacs();
        contacs.add("Иванов", "+79653567956");
        contacs.add("Тихонов", "+79219539874");
        contacs.add("Нефедов", "+79988531682");
        contacs.add("Костиков", "+79207429635");
        contacs.add("Иванов", "+79219832723");
        contacs.add("Ливанов", "+79187498821");
        contacs.add("Асташин", "+79160253816");
        contacs.add("Володин", "+79172304012");
        contacs.add("Чуркин", "+79889090562");
        contacs.add("Капустин", "+79129087650");
        System.out.println(contacs.get("Иванов"));
    }
}
