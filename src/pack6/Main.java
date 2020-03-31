package pack6;

public class Main {




    public static void main(String[] args) {

        ConnectToDB.connect();
        Doctor doctor = new Doctor();
        doctor.address = "Iasi";
        doctor.age =30;
        doctor.name="Andrei Popescu";
        doctor.telephone="0751991111";


    }
}
