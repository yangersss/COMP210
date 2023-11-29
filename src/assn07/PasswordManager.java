package assn07;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "YOUR PASSWORD HERE";
    private Account[] _passwords;

    public PasswordManager() {
        _passwords = new Account[50];
    }


    // TODO: put
    @Override
    public void put(K key, V value) { }

    // TODO: get
    @Override
    public V get(K key) {
        return null;
    }

    // TODO: size
    @Override
    public int size() {
        return 0;
    }

    // TODO: keySet
    @Override
    public Set<K> keySet() {
        return null;
    }

    // TODO: remove
    @Override
    public V remove(K key) {
        return null;
    }

    // TODO: checkDuplicate
    @Override
    public List<K> checkDuplicate(V value) {
        return null;
    }

    // TODO: checkMasterPassword
    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        return false;
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
