package assn07;

import java.util.*;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "password321";
    private Account[] _passwords;

    private int size;

    public PasswordManager() {
        _passwords = new Account[50];
        size = 0;
    }


    // TODO: put
    @Override
    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % 50;
        if (_passwords[index] == null) { //if nothing is in this slot, create new LL
            _passwords[index] = new Account(key, value);
        }
        else{ //insert at tail of list
            Account current = _passwords[index];
            while (current.getNext() != null) {
                if (current.getWebsite().equals(key)) {
                    current.setPassword(value);
                    return;
                }
                current = current.getNext();
            }
            if (current.getWebsite().equals(key)) {
                current.setPassword(value);
                return;
            }
            current.setNext(new Account(key, value));
        }
        size++;
    }

    // TODO: get
    @Override
    public V get(K key) {
        int index = Math.abs(key.hashCode()) % 50;

        Account current = _passwords[index];

        if (current == null) return null;

        if (current.getWebsite().equals(key)) {//check head node
            return (V) current.getPassword();
        }

        while (current.getNext() != null) {
            current = current.getNext();
            if (current.getWebsite().equals(key)) {
                return (V) current.getPassword();
            }
        }
        return null;
    }

    // TODO: size
    @Override
    public int size() {
        return size;
    }

    // TODO: keySet
    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();

        for (int i = 0; i < _passwords.length; i++){
            Account current = _passwords[i];

            while (current!= null) {
                set.add((K) current.getWebsite());
                current = current.getNext();
            }
        }
        return set;
    }

    // TODO: remove
    @Override
    public V remove(K key) {
        int index = Math.abs(key.hashCode()) % 50;

        Account current = _passwords[index]; //start at beginning of LL

        if (current == null) return null; //if it's not there
        if (current.getWebsite().equals(key)){//case 1: target is 1st element
            V temp = (V) current.getPassword();
            _passwords[index] = current.getNext();
            size--;
            return temp;
        }
        Account prev = current; //case 2: target is NOT 1st element
        current = current.getNext();
        while(current != null){
            if (current.getWebsite().equals(key)) {
                V temp = (V) current.getPassword();
                prev.setNext(current.getNext());
                size--;
                return temp;
            }
            prev = current; //traverses through LL
            current = current.getNext();
        }
        return null; //we didn't find it
    }

    // TODO: checkDuplicate
    @Override
    public List<K> checkDuplicate(V value) {
        List<K> list = new ArrayList<>();

        for (int i = 0; i < _passwords.length; i++){
            Account current = _passwords[i];

            while (current!= null) {
                if (current.getPassword().equals(value)) list.add((K) current.getWebsite());
                current = current.getNext();
            }
        }
        return list;
    }

    // TODO: checkMasterPassword
    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        return enteredPassword.equals(MASTER_PASSWORD);
    }

    /*
    Generates random password of input length
     */
    @Override
    public String generateRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }
}
