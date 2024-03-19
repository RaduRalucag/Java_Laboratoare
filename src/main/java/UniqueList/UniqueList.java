package UniqueList;

import java.util.ArrayList;
import java.util.Collection;

public class UniqueList<T> extends ArrayList<T> {

    public UniqueList() {
        super();
    }

    @Override
    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }
        return super.add(element);
    }

    @Override
    public void add(int index, T element) {
        if (!contains(element)) {
            super.add(index, element);
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean modified = false;
        for (T element : collection) {
            if (!contains(element)) {
                super.add(element);
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
         return addAll(collection);
    }
}

