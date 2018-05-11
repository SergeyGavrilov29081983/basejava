
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];

    void clear() {
        this.storage = new Resume[10000];
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++){
            if (storage[i] != null ){
                continue;
            }
            storage[i] = r;
            break;
        }
    }

    Resume get(String uuid) {
        try {
          for (int i = 0; i < storage.length; i++){
              if (uuid == storage[i].uuid){
                  return storage[i];
              }
          }

        } catch(NullPointerException ex) {
            return null;
        }
        return null;
    }

    void delete(String uuid) {
        String searchKey = uuid;
        int i = 0;
        int index = 0;
        int count = storage.length;
        try {
            for (i = 0; i < count; i++) {
                if (storage[i].uuid == searchKey) {
                    index = Arrays.asList(storage).indexOf(storage[i]);
                    break;
                }
            }
            for (int k = i; k < count - 1; k++)
                storage[k] = storage[k + 1];
            count--;
        } catch (Exception ex){

        }
        System.out.println(index);
    }

    Resume[] getAll() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                count += 1;
            }
        }
        Resume[] resume = new Resume[count];
        for (int i = 0; i < storage.length; i++){
            if (storage[i] != null){
                resume[i] = storage[i];
            }
            else break;
        }
        return resume;
    }

    int size() {
        int count = 0;
        try{
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] != null) {
                    count += 1;
                }
            }
            return count;
        } catch (NullPointerException ex) {
            return 0;
        }
    }
}
