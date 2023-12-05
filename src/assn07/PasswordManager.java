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
            Account x = _passwords[index];
            while (x.getNext() != null) {
                if (x.getWebsite().equals(key)) {
                    x.setPassword(value);
                    return;
                }
                x = x.getNext();
            }
            if (x.getWebsite().equals(key)) {
                x.setPassword(value);
                return;
            }
            x.setNext(new Account(key, value));
        }
        size++;
    }

    // TODO: get
    @Override
    public V get(K key) {
        int index = Math.abs(key.hashCode()) % 50;

        Account x = _passwords[index];

        if (x == null) return null;

        if (x.getWebsite().equals(key)) {//check head node
            return (V) x.getPassword();
        }

        while (x.getNext() != null) {
            x = x.getNext();
            if (x.getWebsite().equals(key)) {
                return (V) x.getPassword();
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
            Account x = _passwords[i];

            while (x != null) {
                set.add((K) x.getWebsite());
                x = x.getNext();
            }
        }
        return set;
    }

    // TODO: remove
    @Override
    public V remove(K key) {
        int index = Math.abs(key.hashCode()) % 50;

        Account x = _passwords[index]; //start at beginning of LL

        if (x == null) return null; //if it's not there
        if (x.getWebsite().equals(key)){//case 1: target is 1st element
            V temp = (V) x.getWebsite();
            x = x.getNext();
            size--;
            return temp;
        }
        while(x.getNext().getWebsite() != key) { //case 2: target is NOT first element
            x = x.getNext();
            if(x == null) { //reaches end and doesn't find target: exit and return false
                return null;
            }
        }
        V temp = (V) x.getWebsite();
        x.setNext(x.getNext().getNext());//removes node by updating next reference
        size--;
        return temp;
    }

    // TODO: checkDuplicate
    @Override
    public List<K> checkDuplicate(V value) {
        List<K> list = new ArrayList<>();

        for (int i = 0; i < _passwords.length; i++){
            Account x = _passwords[i];

            while (x != null) {
                if (x.getPassword().equals(value)) list.add((K) x.getWebsite());
                x = x.getNext();
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
