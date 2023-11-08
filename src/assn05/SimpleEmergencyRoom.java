package assn05;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients;

    public SimpleEmergencyRoom() {
        patients = new ArrayList<>();
    }

    // TODO: dequeue
    public Patient dequeue() {
    	if (patients.size() == 0) return null;
        else{
            Patient highest = patients.get(0);
            for (int i = 1; i < patients.size(); i++) {
                if (patients.get(i).getPriority().compareTo(highest.getPriority()) > 0){
                    highest = patients.get(i);
                }
            }
            patients.remove(highest);
            return highest;
        }
    }

    public <V, P> void addPatient(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        patients.add(patient);
    }

    public <V> void addPatient(V value) {
        Patient patient = new Patient(value);
        patients.add(patient);
    }

    public List getPatients() {
        return patients;
    }

    public int size() {
        return patients.size();
    }

}
